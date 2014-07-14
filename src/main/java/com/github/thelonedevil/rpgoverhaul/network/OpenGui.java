package com.github.thelonedevil.rpgoverhaul.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.MathHelper;

import com.github.thelonedevil.rpgoverhaul.RPGOMain;
import com.github.thelonedevil.rpgoverhaul.Ref;
import com.github.thelonedevil.rpgoverhaul.util.LogHelper;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class OpenGui implements IMessage {

	private int data;

	public OpenGui() {
	}

	public OpenGui(int id) {
		data = id;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		data = ByteBufUtils.readVarInt(buf, 5);
												
												
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeVarInt(buf, data, 5);
	}

	public static class Handler implements IMessageHandler<OpenGui, IMessage> {

		@Override
		public IMessage onMessage(OpenGui message, MessageContext ctx) {
			LogHelper.info(String.format("Received %s from %s", "OpenGui", ctx.getServerHandler().playerEntity.getDisplayName()));
			int x = MathHelper.floor_double(ctx.getServerHandler().playerEntity.posX);
			int y = MathHelper.floor_double(ctx.getServerHandler().playerEntity.posY);
			int z = MathHelper.floor_double(ctx.getServerHandler().playerEntity.posZ);
			ctx.getServerHandler().playerEntity.openGui(RPGOMain.instance, Ref.Armour_Inventory_GUI, ctx.getServerHandler().playerEntity.worldObj, x, y, z);
			return null; // no response in this case
		}
	}
}
