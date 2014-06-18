package com.github.thelonedevil.rpgoverhaul.armour;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.github.thelonedevil.rpgoverhaul.inventory.ArmourInventory;
import com.github.thelonedevil.rpgoverhaul.player.ExtendedPlayer;

public class Armour extends Item implements IArmour {
	public int type;

	public Armour(int i) {
		this.type = i;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		// TODO Auto-generated method stub

	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if (!par2World.isRemote) {
			ArmourInventory armour = ExtendedPlayer.get(par3EntityPlayer).customInventory;
			for (int i = 41; i < armour.getSizeInventory(); i++)
				if (armour.getStackInSlot(i) == null && armour.isItemValidForSlot(i, par1ItemStack)) {
					armour.setInventorySlotContents(i, par1ItemStack.copy());
					if (!par3EntityPlayer.capabilities.isCreativeMode)
						par3EntityPlayer.inventory.setInventorySlotContents(par3EntityPlayer.inventory.currentItem, null);

					onEquipped(par1ItemStack, par3EntityPlayer);
					break;
				}
		}

		return par1ItemStack;
	}

}
