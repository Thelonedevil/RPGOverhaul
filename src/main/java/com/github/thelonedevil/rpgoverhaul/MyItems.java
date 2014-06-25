package com.github.thelonedevil.rpgoverhaul;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

import com.github.thelonedevil.rpgoverhaul.armour.Belt;
import com.github.thelonedevil.rpgoverhaul.armour.Helmet;
import com.github.thelonedevil.rpgoverhaul.weapons.swords.LegendarySword;

import cpw.mods.fml.common.registry.GameRegistry;

public class MyItems {

	public static Item ingot_xiatherium;
	public static Item ingot_farunese;
	public static Item ingot_orobalt;
	public static Item ingot_kiritorium;
	public static Item ingot_asunalt;
	public static Item ingot_eruslalt;
	public static Item ingot_ithasium;
	public static Item ingot_ozestum;
	public static Item ingot_emodralt;
	public static Item ingot_evosum;
	public static Item ingot_nautrenese;
	public static Item ingot_axespium;
	public static Item ingot_ketsuekium;
	public static Item ingot_shikyolt;
	public static Item ingot_sakuralt;
	public static Item ingot_ayagrese;
	public static Item ingot_tenshirium;
	public static Item ingot_onecrum;
	
	public static Item mixedIngot;
	
	public static Item alloyIngot;

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
	public static Item TestBelt;

	public static void init() {
		ingot_xiatherium = new Item().setUnlocalizedName("ingot_xiatherium").setTextureName(RPGOMain.MODID + ":ingot_xiatherium").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_farunese = new Item().setUnlocalizedName("ingot_farunese").setTextureName(RPGOMain.MODID + ":ingot_farunese").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_orobalt = new Item().setUnlocalizedName("ingot_orobalt").setTextureName(RPGOMain.MODID + ":ingot_orobalt").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_kiritorium = new Item().setUnlocalizedName("ingot_kiritorium").setTextureName(RPGOMain.MODID + ":ingot_kiritorium").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_asunalt = new Item().setUnlocalizedName("ingot_asunalt").setTextureName(RPGOMain.MODID + ":ingot_asunalt").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_eruslalt = new Item().setUnlocalizedName("ingot_eruslalt").setTextureName(RPGOMain.MODID + ":ingot_eruslalt").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_ithasium = new Item().setUnlocalizedName("ingot_ithasium").setTextureName(RPGOMain.MODID + ":ingot_ingot_ithasium").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_ozestum = new Item().setUnlocalizedName("ingot_ozestum").setTextureName(RPGOMain.MODID + ":ingot_ozestum").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_emodralt = new Item().setUnlocalizedName("ingot_emodralt").setTextureName(RPGOMain.MODID + ":ingot_emodralt").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_evosum = new Item().setUnlocalizedName("ingot_evosum").setTextureName(RPGOMain.MODID + ":ingot_evosum").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_nautrenese = new Item().setUnlocalizedName("ingot_nautrenese").setTextureName(RPGOMain.MODID + ":ingot_nautrenese").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_axespium = new Item().setUnlocalizedName("ingot_axespium").setTextureName(RPGOMain.MODID + ":ingot_axespium").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_ketsuekium = new Item().setUnlocalizedName("ingot_ketsuekium").setTextureName(RPGOMain.MODID + ":ingot_ketsuekium").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_shikyolt = new Item().setUnlocalizedName("ingot_shikyolt").setTextureName(RPGOMain.MODID + ":ingot_shikyolt").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_sakuralt = new Item().setUnlocalizedName("ingot_sakuralt").setTextureName(RPGOMain.MODID + ":ingot_sakuralt").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_ayagrese = new Item().setUnlocalizedName("ingot_ayagrese").setTextureName(RPGOMain.MODID + ":ingot_ayagrese").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_tenshirium = new Item().setUnlocalizedName("ingot_tenshirium").setTextureName(RPGOMain.MODID + ":tenshirium").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_onecrum = new Item().setUnlocalizedName("ingot_onecrum").setTextureName(RPGOMain.MODID + ":ingot_onecrum").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		
		
		mixedIngot = new MixedIngot().setUnlocalizedName("mixedIngot").setMaxStackSize(64);
		GameRegistry.registerItem(mixedIngot, "mixedIngot");
		
		alloyIngot = new AlloyIngot().setUnlocalizedName("alloyIngot").setMaxStackSize(64);
		GameRegistry.registerItem(alloyIngot, "alloyIngot");
		
		crystal_fire = new Item().setUnlocalizedName("crystal_fire").setTextureName(RPGOMain.MODID + ":crystal_fire").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_water = new Item().setUnlocalizedName("crystal_water").setTextureName(RPGOMain.MODID + ":crystal_water").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_air = new Item().setUnlocalizedName("crystal_air").setTextureName(RPGOMain.MODID + ":crystal_air").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_earth = new Item().setUnlocalizedName("crystal_earth").setTextureName(RPGOMain.MODID + ":crystal_earth").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_plasma = new Item().setUnlocalizedName("crystal_plasma").setTextureName(RPGOMain.MODID + ":crystal_plasma").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);

		Zangetsu = new LegendarySword("Zangetsu", "The Slaying Moon", new int[] { 20, 20, 4 });
		GameRegistry.registerItem(Zangetsu, "Zangetsu");

		Sword1 = new LegendarySword("Sword1", "test Sword", new int[] { 20, 20, 4 });
		GameRegistry.registerItem(Sword1, "sword1");

		Sword2 = new LegendarySword("Sword2", "test Sword", new int[] { 20, 20, 4 });
		GameRegistry.registerItem(Sword2, "sword2");

		TestHelmet = new Helmet().setCreativeTab(RPGOMain.myTab).setUnlocalizedName("testhelmet");
		GameRegistry.registerItem(TestHelmet, "testhelmet");
		TestBelt = new Belt(0.3D, 1, 20, 10D, 0, 0).setCreativeTab(RPGOMain.myTab).setUnlocalizedName("testbelt");
		GameRegistry.registerItem(TestBelt, "testbelt");

		GameRegistry.registerItem(ingot_xiatherium, "Xiatherium Ingot");
		GameRegistry.registerItem(ingot_farunese, "Farunese Ingot");
		GameRegistry.registerItem(ingot_orobalt, "Orobalt Ingot");
		GameRegistry.registerItem(ingot_kiritorium, "Kiritorium Ingot");
		GameRegistry.registerItem(ingot_asunalt, "Asunalt Ingot");
		GameRegistry.registerItem(ingot_eruslalt, "Eruslalt Ingot");
		GameRegistry.registerItem(ingot_ithasium, "Ithasium Ingot");
		GameRegistry.registerItem(ingot_ozestum, "Ozestum Ingot");
		GameRegistry.registerItem(ingot_emodralt, "Emodralt Ingot");
		GameRegistry.registerItem(ingot_evosum, "Evosum Ingot");
		GameRegistry.registerItem(ingot_nautrenese, "Nautrenese Ingot");
		GameRegistry.registerItem(ingot_axespium, "Axespium Ingot");
		GameRegistry.registerItem(ingot_ketsuekium, "Ketsuekium Ingot");
		GameRegistry.registerItem(ingot_shikyolt, "Shikyolt Ingot");
		GameRegistry.registerItem(ingot_sakuralt, "Sakuralt Ingot");
		GameRegistry.registerItem(ingot_ayagrese, "Ayagrese Ingot");
		GameRegistry.registerItem(ingot_tenshirium, "Tenshirium Ingot");
		GameRegistry.registerItem(ingot_onecrum, "Onecrum Ingot");
		OreDictionary.registerOre("mixedIngot", ingot_xiatherium);
		OreDictionary.registerOre("mixedIngot", ingot_farunese);
		OreDictionary.registerOre("mixedIngot", ingot_orobalt);
		OreDictionary.registerOre("mixedIngot", ingot_kiritorium);
		OreDictionary.registerOre("mixedIngot", ingot_asunalt);
		OreDictionary.registerOre("mixedIngot", ingot_eruslalt);
		OreDictionary.registerOre("mixedIngot", ingot_ithasium);
		OreDictionary.registerOre("mixedIngot", ingot_ozestum);
		OreDictionary.registerOre("mixedIngot", ingot_evosum);
		OreDictionary.registerOre("mixedIngot", ingot_emodralt);
		OreDictionary.registerOre("mixedIngot", ingot_nautrenese);
		OreDictionary.registerOre("mixedIngot", ingot_axespium);
		OreDictionary.registerOre("mixedIngot", ingot_ketsuekium);
		OreDictionary.registerOre("mixedIngot", ingot_shikyolt);
		OreDictionary.registerOre("mixedIngot", ingot_sakuralt);
		OreDictionary.registerOre("mixedIngot", ingot_ayagrese);
		OreDictionary.registerOre("mixedIngot", ingot_tenshirium);
		OreDictionary.registerOre("mixedIngot", ingot_onecrum);
		OreDictionary.registerOre("mixedIngot", Items.gold_ingot);
		OreDictionary.registerOre("mixedIngot", Items.iron_ingot);

		GameRegistry.registerItem(crystal_fire, "Fire Crystal");
		GameRegistry.registerItem(crystal_water, "Water Crystal");
		GameRegistry.registerItem(crystal_air, "Air Crystal");
		GameRegistry.registerItem(crystal_earth, "Earth Crystal");
		GameRegistry.registerItem(crystal_plasma, "Plasma Crystal");
	}

}
