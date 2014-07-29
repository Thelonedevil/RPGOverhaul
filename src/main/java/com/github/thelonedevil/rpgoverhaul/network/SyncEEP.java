package com.github.thelonedevil.rpgoverhaul.network;

import com.github.thelonedevil.rpgoverhaul.player.ExtendedPlayer;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by justin on 29/07/2014.
 */
public class SyncEEP implements IMessage {

    public NBTTagCompound data;
    public SyncEEP(){

    }

    public SyncEEP(EntityPlayer player) {
        data = new NBTTagCompound();
        ExtendedPlayer.get(player).saveNBTData(data);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        data = ByteBufUtils.readTag(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeTag(buf, data);
    }
    public static class Handler implements IMessageHandler<SyncEEP, IMessage> {

        @Override
        public IMessage onMessage(SyncEEP message, MessageContext ctx) {
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;

            if (player != null) {
                ExtendedPlayer.get(player).loadNBTData(message.data);
            }


            return null;
        }
    }
}
