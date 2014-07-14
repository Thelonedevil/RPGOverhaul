package com.github.thelonedevil.rpgoverhaul.network;

import com.github.thelonedevil.rpgoverhaul.player.ExtendedPlayer;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class UpdateXpPacket implements IMessage {

	private static double xp;

	public UpdateXpPacket() {

	}

	public UpdateXpPacket(double xp) {
		this.xp = xp;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		NBTTagCompound tag = ByteBufUtils.readTag(buf);
		xp = tag.getDouble("xp");
	}

	@Override
	public void toBytes(ByteBuf buf) {
		NBTTagCompound tag = new NBTTagCompound();
		tag.setDouble("xp", xp);
		ByteBufUtils.writeTag(buf, tag);
	}

	public static class Handler implements IMessageHandler<UpdateXpPacket, IMessage> {

		@Override
		public IMessage onMessage(UpdateXpPacket message, MessageContext ctx) {
			ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).addXp(xp);
			return null;
		}

	}

}
