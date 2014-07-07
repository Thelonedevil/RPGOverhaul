package com.github.thelonedevil.rpgoverhaul.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.github.thelonedevil.rpgoverhaul.armour.Armour;
import com.github.thelonedevil.rpgoverhaul.inventory.slots.SlotBelt;
import com.github.thelonedevil.rpgoverhaul.inventory.slots.SlotBootL;
import com.github.thelonedevil.rpgoverhaul.inventory.slots.SlotBootR;
import com.github.thelonedevil.rpgoverhaul.inventory.slots.SlotBracerL;
import com.github.thelonedevil.rpgoverhaul.inventory.slots.SlotBracerR;
import com.github.thelonedevil.rpgoverhaul.inventory.slots.SlotCuirass;
import com.github.thelonedevil.rpgoverhaul.inventory.slots.SlotGauntletL;
import com.github.thelonedevil.rpgoverhaul.inventory.slots.SlotGauntletR;
import com.github.thelonedevil.rpgoverhaul.inventory.slots.SlotGreaves;
import com.github.thelonedevil.rpgoverhaul.inventory.slots.SlotHelmet;
import com.github.thelonedevil.rpgoverhaul.inventory.slots.SlotPauldronL;
import com.github.thelonedevil.rpgoverhaul.inventory.slots.SlotPauldronR;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmourContainer extends Container {
	private static final int HOTBARSTART = 0, HOTBAREND = HOTBARSTART + 9, INVSTART = HOTBAREND + 1, INVEND = INVSTART + 26, VARMSTART = INVEND + 1, VARMEND = VARMSTART + 3,
			CUSTOMARMSTART = 0, CUSTOMARMEND = CUSTOMARMSTART + 11;

	// hotbar 0-9
	// inv 10-36

	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		// TODO Auto-generated method stub
		return true;
	}

	public ArmourContainer(final EntityPlayer player, InventoryPlayer inventoryplayer, ArmourInventory inv) {

		this.addSlotToContainer(new Slot(inv, 0, 112, 8));
		this.addSlotToContainer(new SlotPauldronL(inv, 1, 80, 8));
		this.addSlotToContainer(new SlotPauldronR(inv, 2, 144, 8));
		this.addSlotToContainer(new SlotCuirass(inv, 3, 112, 26));
		this.addSlotToContainer(new SlotBracerL(inv, 4, 80, 26));
		this.addSlotToContainer(new SlotBracerR(inv, 5, 144, 26));
		this.addSlotToContainer(new SlotBelt(inv, 6, 112, 44));
		this.addSlotToContainer(new SlotGauntletL(inv, 7, 80, 44));
		this.addSlotToContainer(new SlotGauntletR(inv, 8, 144, 44));
		this.addSlotToContainer(new SlotGreaves(inv, 9, 112, 62));
		this.addSlotToContainer(new SlotBootL(inv, 10, 80, 62));
		this.addSlotToContainer(new SlotBootR(inv, 11, 144, 62));

		// Add vanilla PLAYER INVENTORY - just copied/pasted from vanilla
		// classes
		for (int i = 0; i < 4; ++i) {
			final int k = i;
			this.addSlotToContainer(new Slot(inventoryplayer, inventoryplayer.getSizeInventory() - 1 - i, 8, 8 + i * 18) {
				/**
				 * Returns the maximum stack size for a given slot (usually the
				 * same as getInventoryStackLimit(), but 1 in the case of armor
				 * slots)
				 */
				public int getSlotStackLimit() {
					return 1;
				}

				/**
				 * Check if the stack is a valid item for this slot. Always true
				 * beside for the armor slots.
				 */
				public boolean isItemValid(ItemStack par1ItemStack) {
					if (par1ItemStack == null)
						return false;
					return par1ItemStack.getItem().isValidArmor(par1ItemStack, k, player);
				}

				/**
				 * Returns the icon index on items.png that is used as
				 * background image of the slot.
				 */
				@SideOnly(Side.CLIENT)
				public IIcon getBackgroundIconIndex() {
					return ItemArmor.func_94602_b(k);
				}
			});
		}
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlotToContainer(new Slot(inventoryplayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		// Add ACTION BAR - just copied/pasted from vanilla classes
		for (int i = 0; i < 9; ++i) {
			this.addSlotToContainer(new Slot(inventoryplayer, i, 8 + i * 18, 142));
		}

	}

	public ItemStack transferStackInSlot(EntityPlayer player, int par2) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			// Either armor slot or custom item slot was clicked
			if (par2 > 36) {
				// try to place in player inventory / action bar
				if (!this.mergeItemStack(itemstack1, HOTBARSTART, INVEND + 1, true)) {
					return null;
				}

				slot.onSlotChange(itemstack1, itemstack);
			}
			// Item is in inventory / hotbar, try to place either in custom or
			// armor slots
			else {
				// if item is our custom item
				if (itemstack1.getItem() instanceof Armour) {
					int type = ((Armour) itemstack1.getItem()).type;
					if (!this.mergeItemStack(itemstack1, CUSTOMARMSTART + type, CUSTOMARMSTART + type + 1, false)) {
						return null;
					}
				}
				// if item is armor
				else if (itemstack1.getItem() instanceof ItemArmor) {
					int type = ((ItemArmor) itemstack1.getItem()).armorType;
					if (!this.mergeItemStack(itemstack1, VARMSTART + type, VARMSTART + type + 1, false)) {
						return null;
					}
				}
				// item in player's inventory, but not in action bar
				else if (par2 >= INVSTART && par2 < HOTBARSTART) {
					// place in action bar
					if (!this.mergeItemStack(itemstack1, HOTBARSTART, HOTBARSTART + 1, false)) {
						return null;
					}
				}
				// item in action bar - place in player inventory
				else if (par2 >= HOTBARSTART && par2 < HOTBAREND + 1) {
					if (!this.mergeItemStack(itemstack1, INVSTART, INVEND + 1, false)) {
						return null;
					}
				}
			}

			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize) {
				return null;
			}

			slot.onPickupFromSlot(player, itemstack1);
		}

		return itemstack;
	}
}
