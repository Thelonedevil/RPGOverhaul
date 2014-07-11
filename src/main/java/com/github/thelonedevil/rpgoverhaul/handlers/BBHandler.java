package com.github.thelonedevil.rpgoverhaul.handlers;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BBHandler {

	@SubscribeEvent
	public void onBBDraw(DrawBlockHighlightEvent event) {
		float xMin = event.target.blockX;
		float yMin = event.target.blockY;
		float zMin = event.target.blockZ;

		EntityPlayer player = event.player;

		int x = MathHelper.floor_double(xMin);
		int y = MathHelper.floor_double(yMin);
		int z = MathHelper.floor_double(zMin);

		Block block = event.player.worldObj.getBlock(x, y, z);

		/*
		 * if (block instanceof CrystalCluster) { event.setCanceled(true);
		 * 
		 * }
		 */
	}

}
