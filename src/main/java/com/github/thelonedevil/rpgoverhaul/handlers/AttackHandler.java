package com.github.thelonedevil.rpgoverhaul.handlers;

import com.github.thelonedevil.rpgoverhaul.weapons.fist.Fist;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

import com.github.thelonedevil.rpgoverhaul.weapons.swords.Sword;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class AttackHandler {

	@SubscribeEvent
	public void onPlayerAttack(AttackEntityEvent event) {
		ItemStack stack = event.entityPlayer.getHeldItem();
		if (stack != null) {
			Item item = stack.getItem();
			if (item instanceof Sword) {
				Sword sword = (Sword) item;
				if (event.target instanceof EntityLivingBase) {
					EntityLivingBase target = (EntityLivingBase) event.target;
					int damage;
					NBTTagCompound tag = stack.getTagCompound();
					if(tag != null){
						damage = tag.getInteger("damage");
					}else{
						damage = 6;
					}
					target.attackEntityFrom(new EntityDamageSource(sword.getItemStackDisplayName(event.entityPlayer.getHeldItem()), event.entityPlayer), damage);
				}

			}if (item instanceof Fist){
                Fist fist = (Fist) item;
                if (event.target instanceof EntityLivingBase) {
                    EntityLivingBase target = (EntityLivingBase) event.target;
                    int damage;
                    NBTTagCompound tag = stack.getTagCompound();
                    if(tag != null){
                        damage = tag.getInteger("damage");
                    }else{
                        damage = 6;
                    }
                    target.attackEntityFrom(new EntityDamageSource(fist.getItemStackDisplayName(event.entityPlayer.getHeldItem()), event.entityPlayer), damage);
                }

            }
		}

	}
}
