package com.github.thelonedevil.rpgoverhaul.handlers;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;

import com.github.thelonedevil.rpgoverhaul.mobs.ExtendedMob;
import com.github.thelonedevil.rpgoverhaul.player.ExtendedPlayer;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EntityConstructionHandler {

	@SubscribeEvent
	public void onConstruction(EntityConstructing event) {
		if (event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer) event.entity) == null) {
			ExtendedPlayer.register((EntityPlayer) event.entity);
		}
		if (event.entity instanceof EntityMob) {
			ExtendedMob.register((EntityMob) event.entity);
		}
	}

}
