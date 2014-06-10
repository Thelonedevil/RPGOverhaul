package com.github.thelonedevil.rpgoverhaul;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class MyItems {
	
	public static Item ingot_xiatherium;
	public static Item ingot_farunese;
	public static Item ingot_orobalt;
	public static Item ingot_kiritorium;
	public static Item ingot_asunalt;
	
	public static void init(){
		ingot_xiatherium = new Item().setUnlocalizedName("ingot_xiatherium").setTextureName(RPGOMain.MODID+":ingot_xiatherium").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_farunese = new Item().setUnlocalizedName("ingot_farunese").setTextureName(RPGOMain.MODID+":ingot_farunese").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_orobalt = new Item().setUnlocalizedName("ingot_orobalt").setTextureName(RPGOMain.MODID+":ingot_orobalt").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_kiritorium = new Item().setUnlocalizedName("ingot_kiritiorium").setTextureName(RPGOMain.MODID+":ingot_kiritorium").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_asunalt = new Item().setUnlocalizedName("ingot_asunalt").setTextureName(RPGOMain.MODID+":ingot_asunalt").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		
		GameRegistry.registerItem(ingot_xiatherium, "Xiatherium Ingot");
		GameRegistry.registerItem(ingot_farunese, "Farunese Ingot");
		GameRegistry.registerItem(ingot_orobalt, "Orobalt Ingot");
		GameRegistry.registerItem(ingot_kiritorium, "Kiritorium Ingot");
		GameRegistry.registerItem(ingot_asunalt, "Asunalt Ingot");
	}

}
