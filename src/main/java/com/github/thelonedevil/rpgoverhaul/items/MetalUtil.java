package com.github.thelonedevil.rpgoverhaul.items;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class MetalUtil {

	public static String getMetals(ItemStack stack) {
		if(stack.getTagCompound() != null){
			//alloys
			NBTTagCompound tag = stack.getTagCompound();
			String i=tag.getString("metal1");
			String j=tag.getString("metal2");
			return i+" "+j;
		}else{
			//base
			return stack.getUnlocalizedName().substring(11);
		}
	}

}
