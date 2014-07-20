package com.github.thelonedevil.rpgoverhaul.handlers;

import java.util.UUID;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import com.github.thelonedevil.rpgoverhaul.RPGOMain;
import com.github.thelonedevil.rpgoverhaul.mobs.BaseXP;
import com.github.thelonedevil.rpgoverhaul.mobs.ExtendedMob;
import com.github.thelonedevil.rpgoverhaul.network.UpdateXpPacket;
import com.github.thelonedevil.rpgoverhaul.player.ExtendedPlayer;
import com.github.thelonedevil.rpgoverhaul.util.Util;

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
				System.out.println("mob level=" + moblevel);
				double xp = 0.0;
				if (e instanceof EntityCreeper) {
					 xp = ((Math.pow(moblevel, 0.6))) * BaseXP.CREEPER;
				} else if (e instanceof EntityZombie) {
					 xp = ((Math.pow(moblevel, 0.6))) * BaseXP.ZOMBIE;
				} else if (e instanceof EntitySkeleton) {
					xp = ((Math.pow(moblevel, 0.6))) * BaseXP.SKELETON;
				}
				if (xp > 0) {
					if (!source.getSourceOfDamage().worldObj.isRemote) {
						UUID uuid = source.getSourceOfDamage().getUniqueID();
						EntityPlayerMP epmp = Util.getPlayerFromUUID(uuid);
						RPGOMain.network.sendTo(new UpdateXpPacket(xp), epmp);
					}

				}
			}

		}
	}
}
