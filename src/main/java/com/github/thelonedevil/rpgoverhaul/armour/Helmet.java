package com.github.thelonedevil.rpgoverhaul.armour;

import com.github.thelonedevil.rpgoverhaul.RPGOMain;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class Helmet extends Armour {

	public static IIcon EmptySlotIcon;

	public boolean canEquipItem(ItemStack par1ItemStack, int slotID) {
		// TODO Auto-generated method stub
		return true;
	}
	public Helmet(){
		super(0);
	}
	public void registerIcons(IIconRegister par1IconRegister)
    {
        super.registerIcons(par1IconRegister);
        this.EmptySlotIcon = par1IconRegister.registerIcon(RPGOMain.MODID+":emptyhelmet");
    }

}
