package com.github.thelonedevil.rpgoverhaul.handlers;

import java.util.Random;

import net.minecraft.entity.monster.EntityMob;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import com.github.thelonedevil.rpgoverhaul.mobs.ExtendedMob;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EntityJoinWorldHandler {

	@SubscribeEvent
	public void onJoinWorld(EntityJoinWorldEvent event) {
		if (event.entity instanceof EntityMob) {
			ExtendedMob mob = ExtendedMob.get((EntityMob) event.entity);
			mob.setLevel(new Random().nextInt(70));
		}
	}
}
