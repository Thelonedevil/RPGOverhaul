package com.github.thelonedevil.rpgoverhaul;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class AlloyIngot extends Item {

	public boolean crafted;

	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		if (crafted) {
			String s = itemstack.getTagCompound().getString("metal1");
			String s1 = itemstack.getTagCompound().getString("metal2");
			String s2 = "Made from " + s + " and " + s1;
			addStringToTooltip(StatCollector.translateToLocal(s2), par3List);
			this.setTextureName(RPGOMain.MODID+ ":alloyIngot_"+s+"_"+s1);
		}else{
			this.setTextureName(RPGOMain.MODID+"alloyIngot_blank");
		}
	}

	private void addStringToTooltip(String s, List<String> tooltip) {
		tooltip.add(s.replaceAll("&", "\u00a7"));
	}

}
