package com.github.thelonedevil.rpgoverhaul.armour;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.github.thelonedevil.rpgoverhaul.Ref;

public class Helmet extends Armour {

	public static IIcon EmptySlotIcon;

	public boolean canEquipItem(ItemStack par1ItemStack, int slotID) {
		// TODO Auto-generated method stub
		return true;
	}

	public Helmet() {
		super(0);
	}

	public void registerIcons(IIconRegister par1IconRegister) {
		super.registerIcons(par1IconRegister);
		this.EmptySlotIcon = par1IconRegister.registerIcon(Ref.MODID + ":emptyhelmet");
	}

}
