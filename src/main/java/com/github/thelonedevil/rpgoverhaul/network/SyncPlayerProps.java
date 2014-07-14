package com.github.thelonedevil.rpgoverhaul.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

import com.github.thelonedevil.rpgoverhaul.player.ExtendedPlayer;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class SyncPlayerProps implements IMessage {

	private static NBTTagCompound data;

	public SyncPlayerProps() {
	}

	public SyncPlayerProps(EntityPlayer player) {
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

	public static class Handler implements IMessageHandler<SyncPlayerProps, IMessage> {

		@Override
		public IMessage onMessage(SyncPlayerProps message, MessageContext ctx) {
			System.out.println(String.format("Received %s from %s", "Properties", ctx.getServerHandler().playerEntity.getDisplayName()));
			ExtendedPlayer.get(ctx.getServerHandler().playerEntity).saveNBTData(data);
			return null; 
		}
	}
}
