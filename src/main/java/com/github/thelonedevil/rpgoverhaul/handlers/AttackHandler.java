package com.github.thelonedevil.rpgoverhaul.handlers;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
					target.attackEntityFrom(new EntityDamageSource(sword.getItemStackDisplayName(event.entityPlayer.getHeldItem()), event.entityPlayer), sword.getAttackDamage());
				}

			}
		}

	}
}
