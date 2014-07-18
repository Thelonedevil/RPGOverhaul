package com.github.thelonedevil.rpgoverhaul.recipes;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;

import com.github.thelonedevil.rpgoverhaul.MyWeapons;

public class WeaponUtil {

	public static ItemStack makeBroadSword(InventoryCrafting par1InventoryCrafting) {
		ItemStack sword = new ItemStack(MyWeapons.broadSword);
		return sword;
	}

}
