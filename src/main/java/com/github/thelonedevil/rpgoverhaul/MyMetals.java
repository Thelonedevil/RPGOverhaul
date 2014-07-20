package com.github.thelonedevil.rpgoverhaul;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

import com.github.thelonedevil.rpgoverhaul.items.AlloyIngot;
import com.github.thelonedevil.rpgoverhaul.items.MixedIngot;

import cpw.mods.fml.common.registry.GameRegistry;

public class MyMetals {
	public static final String XIATHERIUM = "ingotXiatherium";
	public static final String FARUNESE = "ingotFarunese";
	public static final String OROBALT = "ingotOrobalt";
	public static final String KIRITORIUM = "ingotKiritorium";
	public static final String ASUNALT = "ingotAsunalt";
	public static final String ERUSLALT = "ingotEruslalt";
	public static final String ITHASIUM = "ingotIthasium";
	public static final String OZESTUM = "ingotOzestum";
	public static final String EMODRALT = "ingotEmodralt";
	public static final String EVOSUM = "ingotEvosum";
	public static final String NAUTRENESE = "ingotNautrenese";
	public static final String AXESPIUM = "ingotAxespium";
	public static final String KETSUEKIUM = "ingotKetsuekium";
	public static final String SHIKYOLT = "ingotShikyolt";
	public static final String SAKURALT = "ingotSakuralt";
	public static final String AYAGRESE = "ingotAyagrese";
	public static final String TENSHIRIUM = "ingotTenshirium";
	public static final String ONECRUM = "ingotOnecrum";
	public static final String IRON = "ingotIron";
	public static final String GOLD = "ingotGold";

	public static final Item ingot_xiatherium = new Item().setUnlocalizedName(XIATHERIUM).setTextureName(Ref.MODID + ":" + XIATHERIUM).setCreativeTab(RPGOMain.MetalTab).setMaxStackSize(64);
	public static final Item ingot_farunese = new Item().setUnlocalizedName(FARUNESE).setTextureName(Ref.MODID + ":" + FARUNESE).setCreativeTab(RPGOMain.MetalTab).setMaxStackSize(64);
	public static final Item ingot_orobalt = new Item().setUnlocalizedName(OROBALT).setTextureName(Ref.MODID + ":"+OROBALT).setCreativeTab(RPGOMain.MetalTab).setMaxStackSize(64);
	public static final Item ingot_kiritorium = new Item().setUnlocalizedName(KIRITORIUM).setTextureName(Ref.MODID + ":"+KIRITORIUM).setCreativeTab(RPGOMain.MetalTab).setMaxStackSize(64);
	public static final Item ingot_asunalt = new Item().setUnlocalizedName(ASUNALT).setTextureName(Ref.MODID + ":"+ASUNALT).setCreativeTab(RPGOMain.MetalTab).setMaxStackSize(64);
	public static final Item ingot_eruslalt = new Item().setUnlocalizedName(ERUSLALT).setTextureName(Ref.MODID + ":"+ERUSLALT).setCreativeTab(RPGOMain.MetalTab).setMaxStackSize(64);
	public static final Item ingot_ithasium = new Item().setUnlocalizedName(ITHASIUM).setTextureName(Ref.MODID + ":"+ITHASIUM).setCreativeTab(RPGOMain.MetalTab).setMaxStackSize(64);
	public static final Item ingot_ozestum = new Item().setUnlocalizedName(OZESTUM).setTextureName(Ref.MODID + ":"+OZESTUM).setCreativeTab(RPGOMain.MetalTab).setMaxStackSize(64);
	public static final Item ingot_emodralt = new Item().setUnlocalizedName(EMODRALT).setTextureName(Ref.MODID + ":"+EMODRALT).setCreativeTab(RPGOMain.MetalTab).setMaxStackSize(64);
	public static final Item ingot_evosum = new Item().setUnlocalizedName(EVOSUM).setTextureName(Ref.MODID + ":"+EVOSUM).setCreativeTab(RPGOMain.MetalTab).setMaxStackSize(64);
	public static final Item ingot_nautrenese = new Item().setUnlocalizedName(NAUTRENESE).setTextureName(Ref.MODID + ":"+NAUTRENESE).setCreativeTab(RPGOMain.MetalTab).setMaxStackSize(64);
	public static final Item ingot_axespium = new Item().setUnlocalizedName(AXESPIUM).setTextureName(Ref.MODID + ":"+AXESPIUM).setCreativeTab(RPGOMain.MetalTab).setMaxStackSize(64);
	public static final Item ingot_ketsuekium = new Item().setUnlocalizedName(KETSUEKIUM).setTextureName(Ref.MODID + ":"+KETSUEKIUM).setCreativeTab(RPGOMain.MetalTab).setMaxStackSize(64);
	public static final Item ingot_shikyolt = new Item().setUnlocalizedName(SHIKYOLT).setTextureName(Ref.MODID + ":"+SHIKYOLT).setCreativeTab(RPGOMain.MetalTab).setMaxStackSize(64);
	public static final Item ingot_sakuralt = new Item().setUnlocalizedName(SAKURALT).setTextureName(Ref.MODID + ":"+SAKURALT).setCreativeTab(RPGOMain.MetalTab).setMaxStackSize(64);
	public static final Item ingot_ayagrese = new Item().setUnlocalizedName(AYAGRESE).setTextureName(Ref.MODID + ":"+AYAGRESE).setCreativeTab(RPGOMain.MetalTab).setMaxStackSize(64);
	public static final Item ingot_tenshirium = new Item().setUnlocalizedName(TENSHIRIUM).setTextureName(Ref.MODID + ":"+TENSHIRIUM).setCreativeTab(RPGOMain.MetalTab).setMaxStackSize(64);
	public static final Item ingot_onecrum = new Item().setUnlocalizedName(ONECRUM).setTextureName(Ref.MODID + ":"+ONECRUM).setCreativeTab(RPGOMain.MetalTab).setMaxStackSize(64);

	public static final Item mixedIngot = new MixedIngot().setUnlocalizedName("mixedIngot").setMaxStackSize(1).setCreativeTab(RPGOMain.MetalTab);

	public static final Item alloyIngot = new AlloyIngot().setUnlocalizedName("alloyIngot").setMaxStackSize(1).setCreativeTab(RPGOMain.MetalTab);
	

	public static void init() {
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
		
		GameRegistry.registerItem(mixedIngot, "mixedIngot");
		GameRegistry.registerItem(alloyIngot, "alloyIngot");

		OreDictionary.registerOre("ingotMetal", ingot_xiatherium);
		OreDictionary.registerOre("ingotMetal", ingot_farunese);
		OreDictionary.registerOre("ingotMetal", ingot_orobalt);
		OreDictionary.registerOre("ingotMetal", ingot_kiritorium);
		OreDictionary.registerOre("ingotMetal", ingot_asunalt);
		OreDictionary.registerOre("ingotMetal", ingot_eruslalt);
		OreDictionary.registerOre("ingotMetal", ingot_ithasium);
		OreDictionary.registerOre("ingotMetal", ingot_ozestum);
		OreDictionary.registerOre("ingotMetal", ingot_evosum);
		OreDictionary.registerOre("ingotMetal", ingot_emodralt);
		OreDictionary.registerOre("ingotMetal", ingot_nautrenese);
		OreDictionary.registerOre("ingotMetal", ingot_axespium);
		OreDictionary.registerOre("ingotMetal", ingot_ketsuekium);
		OreDictionary.registerOre("ingotMetal", ingot_shikyolt);
		OreDictionary.registerOre("ingotMetal", ingot_sakuralt);
		OreDictionary.registerOre("ingotMetal", ingot_ayagrese);
		OreDictionary.registerOre("ingotMetal", ingot_tenshirium);
		OreDictionary.registerOre("ingotMetal", ingot_onecrum);
		OreDictionary.registerOre("ingotMetal", Items.gold_ingot);
		OreDictionary.registerOre("ingotMetal", Items.iron_ingot);

		OreDictionary.registerOre("ingotMetal", alloyIngot);

		OreDictionary.registerOre("ingotBase", ingot_xiatherium);
		OreDictionary.registerOre("ingotBase", ingot_farunese);
		OreDictionary.registerOre("ingotBase", ingot_orobalt);
		OreDictionary.registerOre("ingotBase", ingot_kiritorium);
		OreDictionary.registerOre("ingotBase", ingot_asunalt);
		OreDictionary.registerOre("ingotBase", ingot_eruslalt);
		OreDictionary.registerOre("ingotBase", ingot_ithasium);
		OreDictionary.registerOre("ingotBase", ingot_ozestum);
		OreDictionary.registerOre("ingotBase", ingot_evosum);
		OreDictionary.registerOre("ingotBase", ingot_emodralt);
		OreDictionary.registerOre("ingotBase", ingot_nautrenese);
		OreDictionary.registerOre("ingotBase", ingot_axespium);
		OreDictionary.registerOre("ingotBase", ingot_ketsuekium);
		OreDictionary.registerOre("ingotBase", ingot_shikyolt);
		OreDictionary.registerOre("ingotBase", ingot_sakuralt);
		OreDictionary.registerOre("ingotBase", ingot_ayagrese);
		OreDictionary.registerOre("ingotBase", ingot_tenshirium);
		OreDictionary.registerOre("ingotBase", ingot_onecrum);
		OreDictionary.registerOre("ingotBase", Items.gold_ingot);
		OreDictionary.registerOre("ingotBase", Items.iron_ingot);
	}
}
