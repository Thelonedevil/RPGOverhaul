package com.github.thelonedevil.rpgoverhaul.armour;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.github.thelonedevil.rpgoverhaul.inventory.ArmourInventory;
import com.github.thelonedevil.rpgoverhaul.player.ExtendedPlayer;

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
		super.onWornTick(itemstack, player);
		if (player instanceof EntityPlayer) {
			EntityPlayer player1 = (EntityPlayer) player;
			if ((player.onGround || player1.capabilities.isFlying) && player.moveForward > 0F)
				player.moveFlying(0F, 1F, player1.capabilities.isFlying ? 0.035F : 0.07F);

			if (player.isSneaking())
				player.stepHeight = 0.50001F; // Not 0.5F because that is the
												// default
			else if (player.stepHeight == 0.50001F)
				player.stepHeight = 1F;
		}
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
		player.stepHeight = 1F;

	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		player.stepHeight = 0.5F;

	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if (!par2World.isRemote) {
			ArmourInventory armour = ExtendedPlayer.get(par3EntityPlayer).armour;
			for (int i = 0; i < 12; i++)
				if (armour.getStackInSlot(i) == null && armour.isItemValidForSlot(i, par1ItemStack)) {
					armour.setInventorySlotContents(i, par1ItemStack.copy());
					if (!par3EntityPlayer.capabilities.isCreativeMode) {
						par3EntityPlayer.inventory.setInventorySlotContents(par3EntityPlayer.inventory.currentItem, null);
					}
					onEquipped(par1ItemStack, par3EntityPlayer);
					break;
				}
		}

		return par1ItemStack;
	}
}
