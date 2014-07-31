package com.github.thelonedevil.rpgoverhaul.handlers;

import com.github.thelonedevil.rpgoverhaul.RPGOMain;
import com.github.thelonedevil.rpgoverhaul.mobs.ExtendedMob;
import com.github.thelonedevil.rpgoverhaul.network.SyncEEP;
import com.github.thelonedevil.rpgoverhaul.player.ExtendedPlayer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class EntityJoinWorldHandler {

    @SubscribeEvent
    public void onJoinWorld(EntityJoinWorldEvent event) {
        if (!event.entity.worldObj.isRemote) {
            if (event.entity instanceof EntityPlayer) {
                RPGOMain.network.sendTo(new SyncEEP((EntityPlayer) event.entity), (EntityPlayerMP) event.entity);

            }
            if (event.entity instanceof EntityMob) {
                ExtendedMob mob = ExtendedMob.get(event.entity);
                EntityPlayer player = event.entity.worldObj.getClosestPlayerToEntity(event.entity, 128D);
                if (player != null) {
                    int level = ExtendedPlayer.get(player).getLevel();
                    int level1 = level + 3;
                    mob.setLevel(level1);
                    double health = ((EntityMob) event.entity).getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue();
                    ((EntityMob) event.entity).getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((level1 * 0.8) * 3 + (health *0.8));
                    ((EntityMob) event.entity).setHealth((float) ((level1 * 0.8) * 3 + (health *0.8)));
                    double damage = ((EntityMob) event.entity).getEntityAttribute(SharedMonsterAttributes.attackDamage).getBaseValue();
                    ((EntityMob) event.entity).getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((level1 * 0.8) * 3 + damage);
                } else {
                    mob.setLevel(3);
                }
            }
            if (event.entity instanceof EntitySlime) {
                ExtendedMob mob = ExtendedMob.get(event.entity);
                EntityPlayer player = event.entity.worldObj.getClosestPlayerToEntity(event.entity, 128D);
                if (player != null) {
                    int level = ExtendedPlayer.get(player).getLevel();
                    int level1 = level + 3;
                    mob.setLevel(level1);
                    double health = ((EntitySlime) event.entity).getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue();
                    int size = ((EntitySlime) event.entity).getSlimeSize() * 6;
                    ((EntitySlime) event.entity).getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((level1 * 0.8) * 3 + (health *0.8));
                    ((EntitySlime) event.entity).setHealth((float) ((level1 * 0.8) * 3 + (health *0.8)));
                } else {
                    mob.setLevel(3);
                }
            }
            if (event.entity instanceof EntityGhast) {
                ExtendedMob mob = ExtendedMob.get(event.entity);
                EntityPlayer player = event.entity.worldObj.getClosestPlayerToEntity(event.entity, 128D);
                if (player != null) {
                    int level = ExtendedPlayer.get(player).getLevel();
                    int level1 = level + 3;
                    mob.setLevel(level1);
                    double health = ((EntityGhast) event.entity).getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue();
                    ((EntityGhast) event.entity).getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((level1 * 0.8) * 3 + (health *0.8));
                    ((EntityGhast) event.entity).setHealth((float) ((level1 * 0.8) * 3 + (health *0.8)));
                } else {
                    mob.setLevel(3);
                }
            }
            if(event.entity instanceof EntityDragon){
                ExtendedMob mob = ExtendedMob.get(event.entity);
                EntityPlayer player = event.entity.worldObj.getClosestPlayerToEntity(event.entity, 128D);
                if (player != null) {
                    int level = ExtendedPlayer.get(player).getLevel();
                    int level1 = level + 3;
                    mob.setLevel(level1);
                    double health = ((EntityDragon) event.entity).getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue();
                    ((EntityDragon) event.entity).getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((level1 * 0.8) * 3 + (health *0.8));
                    ((EntityDragon) event.entity).setHealth((float) ((level1 * 0.8) * 3 + (health * 0.8)));
                } else {
                    mob.setLevel(3);
                }
            }
        }
    }
}
