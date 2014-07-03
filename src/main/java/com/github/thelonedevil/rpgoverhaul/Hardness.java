package com.github.thelonedevil.rpgoverhaul;

import net.minecraft.item.ItemStack;

public class Hardness {

	public static final String HARD = "HARD";
	public static final String SOFT = "SOFT";

	public static String getAlloyHardness(ItemStack item) {
		String name = item.stackTagCompound.getString("metal1") +" "+ item.stackTagCompound.getString("metal2");
		switch(name){
		case AlloyReferrence.Alloy1:
			return HARD;
		default:
			return HARD;
		}
	}

	public static String getMetalHardness(ItemStack slot1) {
		String name = slot1.getItem().getUnlocalizedName();
		switch(name){
		case "ingot_xiatherium":
			return HARD;
		case "ingot_gold":
			return SOFT;
		default:
			return HARD;
		}
	}
	
	

}
