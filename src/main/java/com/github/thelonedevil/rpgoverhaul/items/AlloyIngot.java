package com.github.thelonedevil.rpgoverhaul.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import com.github.thelonedevil.rpgoverhaul.Ref;

public class AlloyIngot extends Item {

	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		if(itemstack.getTagCompound() != null){
			String s = itemstack.getTagCompound().getString("metal1");
			String s1 = itemstack.getTagCompound().getString("metal2");
			String s2 = "Made from " + s + " and " + s1;
			addStringToTooltip(StatCollector.translateToLocal(s2), par3List);
			this.setTextureName(Ref.MODID+ ":alloyIngot_"+s+"_"+s1);
		}
	}

	private void addStringToTooltip(String s, List<String> tooltip) {
		tooltip.add(s.replaceAll("&", "\u00a7"));
	}

}
