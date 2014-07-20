package com.github.thelonedevil.rpgoverhaul.handlers;

import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import com.github.thelonedevil.rpgoverhaul.weapons.Weapon;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class LeftClickHandler {

	@SubscribeEvent
	public void onLeftClick(PlayerInteractEvent event) {
		switch (event.action) {
		case LEFT_CLICK_BLOCK:
			if (event.entityPlayer.capabilities.isCreativeMode && event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() instanceof Weapon) {
				event.setCanceled(true);
			}
			break;
		default:
			break;

		}
	}

}
