package com.github.thelonedevil.rpgoverhaul.armour;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;

public class Belt extends Armour {

	int stepheight, attack, regen, defense;
	double health, speed;

	public boolean canEquipItem(ItemStack par1ItemStack, int slotID) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * 
	 * @param speed
	 * @param stepheight
	 * @param attack
	 * @param health
	 * @param regen
	 * @param defense
	 */

	public Belt(double speed, int stepheight, int attack, double health, int regen, int defense) {
		super(2);
		this.speed = speed;
		this.stepheight = stepheight;
		this.attack = attack;
		this.health = health;
		this.regen = regen;
		this.defense = defense;

	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		if (player.ticksExisted == 1)
			onEquipped(itemstack, player);

	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
		player.stepHeight = stepheight;
		double oldHealth = player.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue();
		player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(oldHealth + health);
		double oldspeed = player.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue();
		player.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(oldspeed + speed);
		double oldAttack =player.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
		player.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(oldAttack + attack);

	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		/*
		 * player.stepHeight = player.stepHeight-stepheight;
		 * player.getEntityAttribute
		 * (SharedMonsterAttributes.maxHealth).setBaseValue
		 * (player.getEntityAttribute
		 * (SharedMonsterAttributes.maxHealth).getBaseValue()-health);
		 * player.getEntityAttribute
		 * (SharedMonsterAttributes.movementSpeed).setBaseValue
		 * (player.getEntityAttribute
		 * (SharedMonsterAttributes.movementSpeed).getBaseValue()-speed);
		 * player.
		 * getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue
		 * (player.getEntityAttribute(SharedMonsterAttributes.attackDamage).
		 * getBaseValue()-attack);
		 */
	}
}
