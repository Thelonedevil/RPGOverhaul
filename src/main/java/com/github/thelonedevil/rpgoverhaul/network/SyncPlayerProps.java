package com.github.thelonedevil.rpgoverhaul.network;

import com.github.thelonedevil.rpgoverhaul.player.ExtendedPlayer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class SyncPlayerProps implements IMessage {
	   
	private static NBTTagCompound data;

    public SyncPlayerProps() { }

    public SyncPlayerProps(EntityPlayer player) {
    	data = new NBTTagCompound();
    	ExtendedPlayer.get(player).saveNBTData(data);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
    	data = ByteBufUtils.readTag(buf); // this class is very useful in general for writing more complex objects
    }

    @Override
    public void toBytes(ByteBuf buf) {
    	ByteBufUtils.writeTag(buf, data);
    }

    public static class Handler implements IMessageHandler<SyncPlayerProps, IMessage> {
       
        @Override
        public IMessage onMessage(SyncPlayerProps message, MessageContext ctx) {
            System.out.println(String.format("Received %s from %s", "Properties", ctx.getServerHandler().playerEntity.getDisplayName()));
            data = new NBTTagCompound();
    		// and save our player's data into it
    		ExtendedPlayer.get(ctx.getServerHandler().playerEntity).saveNBTData(data);
            return null; // no response in this case
        }
    }
}
