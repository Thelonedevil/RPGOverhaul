package com.github.thelonedevil.rpgoverhaul;

import net.minecraft.item.Item;

import com.github.thelonedevil.rpgoverhaul.armour.Helmet;
import com.github.thelonedevil.rpgoverhaul.weapons.swords.LegendarySword;

import cpw.mods.fml.common.registry.GameRegistry;

public class MyItems {
	
	public static Item ingot_xiatherium;
	public static Item ingot_farunese;
	public static Item ingot_orobalt;
	public static Item ingot_kiritorium;
	public static Item ingot_asunalt;
	
	public static Item Zangetsu;
	public static Item Sword1;
	public static Item Sword2;
	
	public static Item crystal_fire;
	public static Item crystal_water;
	public static Item crystal_earth;
	public static Item crystal_air;
	public static Item crystal_plasma;
	public static Item crystal_sun;
	public static Item crystal_moon;
	public static Item crystal_aries;
	public static Item crystal_taurus;
	public static Item crystal_gemini;
	public static Item crystal_cancer;
	public static Item crystal_leo;
	public static Item crystal_virgo;
	public static Item crystal_libra;
	public static Item crystal_scorpio;
	public static Item crystal_sagittarius;
	public static Item crystal_capricorn;
	public static Item crystal_aquarius;
	public static Item crystal_pisces;
	public static Item crystal_dragon_fire;
	public static Item crystal_dragon_sky;
	public static Item crystal_dragon_iron;
	public static Item crystal_dragon_lightning;
	public static Item crystal_dragon_shadow;
	public static Item crystal_dragon_light;
	
	public static Item TestHelmet;
	public static Item TestPauldronL;
	public static Item TestPauldronR;
	public static Item TestCuirass;
	public static Item TestBracerL;
	public static Item TestBracerR;

	
	public static void init(){
		ingot_xiatherium = new Item().setUnlocalizedName("ingot_xiatherium").setTextureName(RPGOMain.MODID+":ingot_xiatherium").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_farunese = new Item().setUnlocalizedName("ingot_farunese").setTextureName(RPGOMain.MODID+":ingot_farunese").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_orobalt = new Item().setUnlocalizedName("ingot_orobalt").setTextureName(RPGOMain.MODID+":ingot_orobalt").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_kiritorium = new Item().setUnlocalizedName("ingot_kiritorium").setTextureName(RPGOMain.MODID+":ingot_kiritorium").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_asunalt = new Item().setUnlocalizedName("ingot_asunalt").setTextureName(RPGOMain.MODID+":ingot_asunalt").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		
		crystal_fire = new Item().setUnlocalizedName("crystal_fire").setTextureName(RPGOMain.MODID+":crystal_fire").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_water = new Item().setUnlocalizedName("crystal_water").setTextureName(RPGOMain.MODID+":crystal_water").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_air = new Item().setUnlocalizedName("crystal_air").setTextureName(RPGOMain.MODID+":crystal_air").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_earth = new Item().setUnlocalizedName("crystal_earth").setTextureName(RPGOMain.MODID+":crystal_earth").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_plasma = new Item().setUnlocalizedName("crystal_plasma").setTextureName(RPGOMain.MODID+":crystal_plasma").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		
		Zangetsu = new LegendarySword("Zangetsu", "The Slaying Moon", new int[] {20,20,4});
		GameRegistry.registerItem(Zangetsu, "Zangetsu");
		
		Sword1 = new LegendarySword("Sword1", "test Sword", new int[] {20,20,4});
		GameRegistry.registerItem(Sword1, "sword1");
		
		Sword2 = new LegendarySword("Sword2", "test Sword", new int[] {20,20,4});
		GameRegistry.registerItem(Sword2, "sword2");
		
		TestHelmet = new Helmet().setCreativeTab(RPGOMain.myTab).setUnlocalizedName("testhelmet");
		GameRegistry.registerItem(TestHelmet, "testhelmet");
		
		GameRegistry.registerItem(ingot_xiatherium, "Xiatherium Ingot");
		GameRegistry.registerItem(ingot_farunese, "Farunese Ingot");
		GameRegistry.registerItem(ingot_orobalt, "Orobalt Ingot");
		GameRegistry.registerItem(ingot_kiritorium, "Kiritorium Ingot");
		GameRegistry.registerItem(ingot_asunalt, "Asunalt Ingot");
		
		GameRegistry.registerItem(crystal_fire, "Fire Crystal");
		GameRegistry.registerItem(crystal_water, "Water Crystal");
		GameRegistry.registerItem(crystal_air, "Air Crystal");
		GameRegistry.registerItem(crystal_earth, "Earth Crystal");
		GameRegistry.registerItem(crystal_plasma, "Plasma Crystal");
	}

}
