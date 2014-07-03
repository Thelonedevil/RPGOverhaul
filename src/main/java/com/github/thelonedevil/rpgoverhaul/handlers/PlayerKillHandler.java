package com.github.thelonedevil.rpgoverhaul.handlers;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import com.github.thelonedevil.rpgoverhaul.mobs.BaseXP;
import com.github.thelonedevil.rpgoverhaul.mobs.ExtendedMob;
import com.github.thelonedevil.rpgoverhaul.player.ExtendedPlayer;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PlayerKillHandler {
	@SubscribeEvent
	public void onPlayerKill(LivingDeathEvent event) {
		DamageSource source = event.source;
		if (source.getSourceOfDamage() instanceof EntityPlayer) {
			ExtendedPlayer player = ExtendedPlayer.get((EntityPlayer) source.getSourceOfDamage());
			EntityLivingBase e = event.entityLiving;
			if (e instanceof EntityMob) {
				ExtendedMob mob = ExtendedMob.get((EntityMob) e);
				int moblevel = mob.getLevel();
				System.out.println("mob level="+moblevel);
				if (e instanceof EntityCreeper) {

					double xp = ((Math.pow(moblevel, 0.6))) * BaseXP.CREEPER;
					if (xp > 0) {
						player.addXp(xp);
					}

				} else if (e instanceof EntityZombie) {

					double xp = ((Math.pow(moblevel, 0.6))) * BaseXP.ZOMBIE;
					if (xp > 0) {
						player.addXp(xp);
					}

				} else if (e instanceof EntitySkeleton) {

					double xp = ((Math.pow(moblevel, 0.6))) * BaseXP.SKELETON;
					if (xp > 0) {
						player.addXp(xp);
					}

				}
			}

		}
	}
}
