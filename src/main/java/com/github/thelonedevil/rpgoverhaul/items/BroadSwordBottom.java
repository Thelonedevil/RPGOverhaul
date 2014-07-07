package com.github.thelonedevil.rpgoverhaul.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class BroadSwordBottom extends WeaponPart{
	
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {

			String s = itemstack.getTagCompound().getString("metals1");
			String s1 = itemstack.getTagCompound().getString("metals2");
			String s2 = itemstack.getTagCompound().getString("metals3");
			String s3 = itemstack.getTagCompound().getString("metals4");
			String s4 = itemstack.getTagCompound().getString("metals5");
			String s5 = itemstack.getTagCompound().getString("metals6");
			String s6 = itemstack.getTagCompound().getString("metals7");
			String s7 = itemstack.getTagCompound().getString("metals8");
			String s8 = "Made from " + s + ", " + s1+ ", " + s2+ ", " + s3+ ", " + s4+ ", " + s5+ ", " + s6+ ", " + s7;
			addStringToTooltip(StatCollector.translateToLocal(s8), par3List);

	}

	private void addStringToTooltip(String s, List<String> tooltip) {
		tooltip.add(s.replaceAll("&", "\u00a7"));
	}

}
