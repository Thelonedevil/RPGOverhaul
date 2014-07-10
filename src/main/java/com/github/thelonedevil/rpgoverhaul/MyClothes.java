package com.github.thelonedevil.rpgoverhaul;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.github.thelonedevil.rpgoverhaul.items.clothes.FoxHat;
import com.github.thelonedevil.rpgoverhaul.items.clothes.FoxLeggings;
import com.github.thelonedevil.rpgoverhaul.items.clothes.FoxSocks;
import com.github.thelonedevil.rpgoverhaul.items.clothes.FoxTunic;

import cpw.mods.fml.common.registry.GameRegistry;

public class MyClothes {
	
	public static ArmorMaterial cloth = EnumHelper.addArmorMaterial("Fabric", 66, new int[]{0,0,0,0}, 0);
	public static Item FoxHat;
	public static Item FoxTunic;
	public static Item FoxLeggings;
	public static Item FoxSocks;
	public static void init(){
		int render = RPGOMain.proxy.addArmor("Fabric");
		FoxHat = new FoxHat(cloth, render, 0).setCreativeTab(RPGOMain.myTab).setUnlocalizedName("FoxHat");
		FoxTunic = new FoxTunic(cloth, render, 1).setCreativeTab(RPGOMain.myTab).setUnlocalizedName("FoxTunic");
		FoxLeggings = new FoxLeggings(cloth, render, 2).setCreativeTab(RPGOMain.myTab).setUnlocalizedName("FoxLeggings");
		FoxSocks = new FoxSocks(cloth, render, 3).setCreativeTab(RPGOMain.myTab).setUnlocalizedName("FoxSocks");
		GameRegistry.registerItem(FoxHat, "foxHat");
		GameRegistry.registerItem(FoxTunic, "foxTunic");
		GameRegistry.registerItem(FoxLeggings, "foxLeggings");
		GameRegistry.registerItem(FoxSocks, "foxSocks");
	}
}
