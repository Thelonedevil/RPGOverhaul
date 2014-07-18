package com.github.thelonedevil.rpgoverhaul.items;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import com.github.thelonedevil.rpgoverhaul.MyMetals;

public class MetalUtil {

	public static String getMetals(ItemStack stack) {
		if (stack.getTagCompound() != null) {
			// alloys
			NBTTagCompound tag = stack.getTagCompound();
			String i = tag.getString("metal1");
			String j = tag.getString("metal2");
			return i + " " + j;
		} else {
			// base
			return stack.getUnlocalizedName().substring(11);
		}
	}
	
	public static ItemStack makeMixedIngot(ItemStack itemstack, ItemStack itemstack1){
		ItemStack stack = new ItemStack(MyMetals.mixedIngot);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setString("metal1", itemstack.getUnlocalizedName().substring(11));
		tag.setString("metal2", itemstack1.getUnlocalizedName().substring(11));
		stack.setTagCompound(tag);
		return stack;
	}

}
