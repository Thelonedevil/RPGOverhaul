package com.github.thelonedevil.rpgoverhaul;

import com.github.thelonedevil.rpgoverhaul.items.BroadSwordBottom;
import com.github.thelonedevil.rpgoverhaul.weapons.swords.Sword;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class MyWeapons {
	public static Item broadsword;
	public static Item broadsword_bottom;
	public static Item broadsword_top;
	
	public static void init(){
		broadsword = new Sword("BroadSword", new int[] { 20, 20, 4 });
		broadsword_bottom = new BroadSwordBottom().setCreativeTab(RPGOMain.myTab).setUnlocalizedName("BSB");
		broadsword_top = new Item().setCreativeTab(RPGOMain.myTab).setUnlocalizedName("BST");
		
		GameRegistry.registerItem(broadsword, "broadsword");
		GameRegistry.registerItem(broadsword_bottom, "broadsword_bottom");
		GameRegistry.registerItem(broadsword_top, "broadsword_top");
	}
}
