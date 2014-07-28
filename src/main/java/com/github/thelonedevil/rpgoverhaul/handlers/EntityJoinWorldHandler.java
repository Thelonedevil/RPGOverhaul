package com.github.thelonedevil.rpgoverhaul.handlers;

import com.github.thelonedevil.rpgoverhaul.mobs.ExtendedMob;
import com.github.thelonedevil.rpgoverhaul.player.ExtendedPlayer;
import com.github.thelonedevil.rpgoverhaul.util.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class EntityJoinWorldHandler {

    @SubscribeEvent
    public void onJoinWorld(EntityJoinWorldEvent event) {
        if (!event.entity.worldObj.isRemote) {
            if (event.entity instanceof EntityMob) {
                ExtendedMob mob = ExtendedMob.get((EntityMob) event.entity);
                EntityPlayer player = ((EntityMob) event.entity).worldObj.getClosestPlayerToEntity(event.entity, 128D);
                if (player != null) {
                    int level = ExtendedPlayer.get(player).getLevel();
                    int level1 = level + 3;
                    mob.setLevel(level1);
                   double health = ((EntityMob)event.entity).getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue();
                    ((EntityMob)event.entity).getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((level1*0.8)*3 + health);
                    ((EntityMob)event.entity).setHealth((float)((level1*0.8)*3 + health));


                } else {
                    mob.setLevel(3);
                }
            }
        }
    }
}
