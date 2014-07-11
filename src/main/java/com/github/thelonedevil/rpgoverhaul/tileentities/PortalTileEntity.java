package com.github.thelonedevil.rpgoverhaul.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import com.github.thelonedevil.rpgoverhaul.MyItems;

public class PortalTileEntity extends TileEntity implements ISidedInventory {
	private static final int[] slotsTop = new int[] { 1 };
	private static final int[] slotsBottom = new int[] { 1 };
	private static final int[] slotsSides = new int[] { 1 };
	private ItemStack[] slots = new ItemStack[2];
	public boolean book;

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		// TODO Auto-generated method stub
		return slots[slot];
	}

	@Override
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		slots[slot] = stack;

	}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openInventory() {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub

	}

	public void readFromNBT(NBTTagCompound p_145839_1_) {
		super.readFromNBT(p_145839_1_);
		book = p_145839_1_.getBoolean("book");
	}

	public void writeToNBT(NBTTagCompound p_145841_1_) {
		p_145841_1_.setBoolean("book", book);
		super.writeToNBT(p_145841_1_);
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack item) {
		switch (slot) {
		case 0:
			return item.getItem() == MyItems.questBook;
		case 1:
			return true;
		default:
			return false;
		}

	}

	@Override
	public int[] getAccessibleSlotsFromSide(int par1) {
		return par1 == 0 ? slotsBottom : (par1 == 1 ? slotsTop : slotsSides);
	}

	@Override
	public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
		// TODO Auto-generated method stub
		return false;
	}

}
