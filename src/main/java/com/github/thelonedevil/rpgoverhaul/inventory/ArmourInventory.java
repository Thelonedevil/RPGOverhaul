package com.github.thelonedevil.rpgoverhaul.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import com.github.thelonedevil.rpgoverhaul.armour.Belt;
import com.github.thelonedevil.rpgoverhaul.armour.BootL;
import com.github.thelonedevil.rpgoverhaul.armour.BootR;
import com.github.thelonedevil.rpgoverhaul.armour.BracerL;
import com.github.thelonedevil.rpgoverhaul.armour.BracerR;
import com.github.thelonedevil.rpgoverhaul.armour.Cuirass;
import com.github.thelonedevil.rpgoverhaul.armour.GauntletL;
import com.github.thelonedevil.rpgoverhaul.armour.GauntletR;
import com.github.thelonedevil.rpgoverhaul.armour.Greaves;
import com.github.thelonedevil.rpgoverhaul.armour.Helmet;
import com.github.thelonedevil.rpgoverhaul.armour.PauldronL;
import com.github.thelonedevil.rpgoverhaul.armour.PauldronR;

public class ArmourInventory implements IInventory {
	/**
	 * The name your custom inventory will display in the GUI, possibly just
	 * "Inventory"
	 */
	private final String name = "Custom Inventory";

	/** The key used to store and retrieve the inventory from NBT */
	private final String tagName = "CustomInvTag";

	/** Define the inventory size here for easy reference */
	// This is also the place to define which slot is which if you have
	// different types,
	// for example SLOT_SHIELD = 0, SLOT_AMULET = 1;
	public static final int INV_SIZE = 53;
	public static final int helmet = 41;
	public static final int pauldronl = 42;
	public static final int pauldronr = 43;
	public static final int chest = 44;
	public static final int bracerl = 45;
	public static final int bracerr = 46;
	public static final int belt = 47;
	public static final int glovel = 48;
	public static final int glover = 49;
	public static final int legs = 50;
	public static final int bootl = 51;
	public static final int bootr = 52;

	/**
	 * Inventory's size must be same as number of slots you add to the Container
	 * class
	 */
	private ItemStack[] inventory = new ItemStack[INV_SIZE];

	public ArmourInventory() {
		// don't need anything here!
	}

	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return inventory[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		ItemStack stack = getStackInSlot(slot);
		if (stack != null) {
			if (stack.stackSize > amount) {
				stack = stack.splitStack(amount);
				if (stack.stackSize == 0) {
					setInventorySlotContents(slot, null);
				}
			} else {
				setInventorySlotContents(slot, null);
			}

			this.markDirty();
		}
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack stack = getStackInSlot(slot);
		if (stack != null) {
			setInventorySlotContents(slot, null);
		}
		return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack) {
		this.inventory[slot] = itemstack;

		if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
			itemstack.stackSize = this.getInventoryStackLimit();
		}

		this.markDirty();
	}

	@Override
	public String getInventoryName() {
		return name;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return name.length() > 0;
	}

	/**
	 * Our custom slots are similar to armor - only one item per slot
	 */
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void markDirty() {
		for (int i = 0; i < this.getSizeInventory(); i++) {
			if (this.getStackInSlot(i) != null && this.getStackInSlot(i).stackSize == 0)
				this.setInventorySlotContents(i, null);
		}
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return true;
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}

	/**
	 * This method doesn't seem to do what it claims to do, as items can still
	 * be left-clicked and placed in the inventory even when this returns false
	 */
	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		// If you have different kinds of slots, then check them here:
		// if (slot == SLOT_SHIELD && itemstack.getItem() instanceof ItemShield)
		// return true;

		// For now, only ItemUseMana items can be stored in these slots

		switch (slot) {
		case helmet:
			if(itemstack.getItem() instanceof Helmet){
				return true;
			}else return false;
		case pauldronl:
			if(itemstack.getItem() instanceof PauldronL){
				return true;
			}else return false;
		case pauldronr:
			if(itemstack.getItem() instanceof PauldronR){
				return true;
			}else return false;
		case chest:
			if(itemstack.getItem() instanceof Cuirass){
				return true;
			}else return false;
		case bracerl:
			if(itemstack.getItem() instanceof BracerL){
				return true;
			}else return false;
		case bracerr:
			if(itemstack.getItem() instanceof BracerR){
				return true;
			}else return false;
		case belt:
			if(itemstack.getItem() instanceof Belt){
				return true;
			}else return false;
		case glovel:
			if(itemstack.getItem() instanceof GauntletL){
				return true;
			}else return false;
		case glover:
			if(itemstack.getItem() instanceof GauntletR){
				return true;
			}else return false;
		case legs:
			if(itemstack.getItem() instanceof Greaves){
				return true;
			}else return false;
		case bootl:
			if(itemstack.getItem() instanceof BootL){
				return true;
			}else return false;
		case bootr:
			if(itemstack.getItem() instanceof BootR){
				return true;
			}else return false;
		default:
			return false;
		}
	}

	public void writeToNBT(NBTTagCompound compound) {
		NBTTagList items = new NBTTagList();

		for (int i = 0; i < getSizeInventory(); ++i) {
			if (getStackInSlot(i) != null) {
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("Slot", (byte) i);
				getStackInSlot(i).writeToNBT(item);
				items.appendTag(item);
			}
		}

		// We're storing our items in a custom tag list using our 'tagName' from
		// above
		// to prevent potential conflicts
		compound.setTag(tagName, items);
	}

	public void readFromNBT(NBTTagCompound compound) {
		NBTTagList items = compound.getTagList(tagName, compound.getId());
		for (int i = 0; i < items.tagCount(); ++i) {
			NBTTagCompound item = items.getCompoundTagAt(i);
			byte slot = item.getByte("Slot");
			if (slot >= 0 && slot < getSizeInventory()) {
				inventory[slot] = ItemStack.loadItemStackFromNBT(item);
			}
		}
	}

}
