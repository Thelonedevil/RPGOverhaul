package com.github.thelonedevil.rpgoverhaul.armour;

import java.util.UUID;

import com.github.thelonedevil.rpgoverhaul.inventory.ArmourInventory;
import com.github.thelonedevil.rpgoverhaul.player.ExtendedPlayer;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

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
		if (player instanceof EntityPlayer) {
			if (!ExtendedPlayer.get((EntityPlayer)player).equippedModifiers.get(this.type)) {
				onEquipped(itemstack, player);
			}
			System.out.println("StepHeioght = " + player.stepHeight);
			System.out.println("MaxHealth = " + player.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue());
			System.out.println("Speed = " + player.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue());
			EntityPlayer player1 = (EntityPlayer)player;
			System.out.println("Speed1 = "+player1.getAIMoveSpeed());
			System.out.println("Attack = " + player.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue());
		}
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
		EntityPlayer player1 = (EntityPlayer)player;
		player.stepHeight = player.stepHeight + stepheight;
		System.out.println(player.stepHeight);
		
		double oldHealth = player.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue();
		player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(oldHealth + health);
		System.out.println(player.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue());
		
		double oldspeed = player.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue();
		
		player1.setAIMoveSpeed((float) (player1.getAIMoveSpeed()+ speed));
		//player.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(speed);
		System.out.println(player.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue());
		
		double oldAttack = player.getEntityAttribute(SharedMonsterAttributes.attackDamage).getBaseValue();
		player.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(oldAttack + attack);
		System.out.println(player.getEntityAttribute(SharedMonsterAttributes.attackDamage).getBaseValue());
		
		ExtendedPlayer.get((EntityPlayer)player).equippedModifiers.set(this.type, true);
	}


	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {

		//player.stepHeight = player.stepHeight - stepheight;
		//player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(player.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() - health);
		//player.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(player.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue() - speed);
		//player.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(player.getEntityAttribute(SharedMonsterAttributes.attackDamage).getBaseValue() - attack);

	}
}
