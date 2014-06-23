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
				int playerlevel = player.getLevel();
				if (e instanceof EntityCreeper) {
					if (playerlevel > 0) {
						double xp = ((moblevel) / playerlevel) * BaseXP.CREEPER;
						if (xp > 0) {
							player.addXp(xp);
						}
					} else {
						double xp = ((moblevel)) * BaseXP.CREEPER;
						if (xp > 0) {
							player.addXp(xp);
						}
					}
				} else if (e instanceof EntityZombie) {
					if (playerlevel > 0) {
						double xp = ((moblevel) / playerlevel) * BaseXP.ZOMBIE;
						if (xp > 0) {
							player.addXp(xp);
						}
					} else {

						double xp = ((moblevel)) * BaseXP.ZOMBIE;
						if (xp > 0) {
							player.addXp(xp);
						}
					}
				} else if (e instanceof EntitySkeleton) {
					if (playerlevel > 0) {
						double xp = ((moblevel) / playerlevel) * BaseXP.SKELETON;
						if (xp > 0) {
							player.addXp(xp);
						}
					} else {
						double xp = ((moblevel)) * BaseXP.SKELETON;
						if (xp > 0) {
							player.addXp(xp);
						}
					}
				}
			}

		}
	}
}
