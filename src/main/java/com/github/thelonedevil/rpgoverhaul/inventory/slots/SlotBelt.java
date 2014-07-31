package com.github.thelonedevil.rpgoverhaul.inventory.slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.github.thelonedevil.rpgoverhaul.armour.Belt;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SlotBelt extends Slot {

	public final int slotID;

	public SlotBelt(IInventory par1iInventory, int par2, int par3, int par4) {
		super(par1iInventory, par2, par3, par4);
		this.slotID = par2;
	}

	@Override
	public int getSlotStackLimit() {
		return 1;
	}

	@Override
	public boolean isItemValid(ItemStack par1ItemStack) {
		Item item = (par1ItemStack == null ? null : par1ItemStack.getItem());
		return item != null && (item instanceof Belt) && ((Belt) item).canEquipItem(par1ItemStack, this.slotID);

	}

}
