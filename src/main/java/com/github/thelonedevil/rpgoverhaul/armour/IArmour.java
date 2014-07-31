package com.github.thelonedevil.rpgoverhaul.armour;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ISpecialArmor;

public interface IArmour{
	/**
	 * This method is called once per tick if the armour is being worn by a
	 * player
	 */
	public void onWornTick(ItemStack itemstack, EntityLivingBase player);

	/**
	 * This method is called when the armour is equipped by a player
	 */
	public void onEquipped(ItemStack itemstack, EntityLivingBase player);

	/**
	 * This method is called when the armour is unequipped by a player
	 */
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player);

}
