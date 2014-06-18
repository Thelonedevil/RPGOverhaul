package com.github.thelonedevil.rpgoverhaul.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;

import com.github.thelonedevil.rpgoverhaul.armour.Armour;
import com.github.thelonedevil.rpgoverhaul.inventory.ArmourInventory;
import com.github.thelonedevil.rpgoverhaul.player.ExtendedPlayer;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PlayerTickHandler {

	@SubscribeEvent
	public void playerTick(PlayerEvent.LivingUpdateEvent event) {

		// player events
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;

			ArmourInventory armour = ExtendedPlayer.get(player).customInventory;
			for (int a = 41; a < armour.getSizeInventory(); a++) {
				if (armour.getStackInSlot(a) != null && armour.getStackInSlot(a).getItem() instanceof Armour) {
					((Armour) armour.getStackInSlot(a).getItem()).onWornTick(armour.getStackInSlot(a), player);
				}
			}

		}

	}

}
