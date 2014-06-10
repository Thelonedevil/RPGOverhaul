package com.github.thelonedevil.rpgoverhaul;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class Util {
	public static ItemStack[] mergeItemStacks(ItemStack stack1, ItemStack stack2) {
		int size1 = stack1.stackSize;
		int size2 = stack2.stackSize;
		if (size1 < 64 && size2 < 64) {
			int fsize = size1 + size2;
			if (fsize > 64) {
				int size3 = fsize - 64;
				ItemStack stack3 = new ItemStack(stack1.getItem(), 64);
				ItemStack stack4 = new ItemStack(stack1.getItem(), size3);
				return new ItemStack[] { stack3, stack4 };
			} else
				return new ItemStack[] { new ItemStack(stack1.getItem(), fsize) };
		} else
			return new ItemStack[] { stack1, stack2 };
	}
	public static int findEmptySlot(IInventory inv){
		for (int i = 0; i < inv.getSizeInventory(); i++) {
			if(inv.getStackInSlot(i) == null){
				return i;
			}
		}
		return -1;
		
	}
}
