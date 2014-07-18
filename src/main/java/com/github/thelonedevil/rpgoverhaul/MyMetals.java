package com.github.thelonedevil.rpgoverhaul;

import com.github.thelonedevil.rpgoverhaul.items.AlloyIngot;
import com.github.thelonedevil.rpgoverhaul.items.MixedIngot;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class MyMetals {
	public static final String XIATHERIUM = "ingot_xiatherium";
	public static final String FARUNESE = "ingot_farunese";
	public static final String OROBALT = "ingot_orobalt";
	public static final String KIRITORIUM = "ingot_kiritorium";
	public static final String ASUNALT = "ingot_asunalt";
	public static final String ERUSLALT = "ingot_eruslalt";
	public static final String ITHASIUM = "ingot_ithasium";
	public static final String OZESTUM = "ingot_ozestum";
	public static final String EMODRALT = "ingot_emodralt";
	public static final String EVOSUM = "ingot_evosum";
	public static final String NAUTRENESE = "ingot_nautrenese";
	public static final String AXESPIUM = "ingot_axespium";
	public static final String KETSUEKIUM = "ingot_ketsuekium";
	public static final String SHIKYOLT = "ingot_shikyolt";
	public static final String SAKURALT = "ingot_sakuralt";
	public static final String AYAGRESE = "ingot_ayagrese";
	public static final String TENSHIRIUM = "ingot_tenshirium";
	public static final String ONECRUM = "ingot_onecrum";

	public static final Item ingot_xiatherium = new Item().setUnlocalizedName(XIATHERIUM).setTextureName(Ref.MODID + ":" + XIATHERIUM).setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
	public static final Item ingot_farunese = new Item().setUnlocalizedName(FARUNESE).setTextureName(Ref.MODID + ":" + FARUNESE).setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
	public static final Item ingot_orobalt = new Item().setUnlocalizedName(OROBALT).setTextureName(Ref.MODID + ":"+OROBALT).setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
	public static final Item ingot_kiritorium = new Item().setUnlocalizedName(KIRITORIUM).setTextureName(Ref.MODID + ":"+KIRITORIUM).setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
	public static final Item ingot_asunalt = new Item().setUnlocalizedName(ASUNALT).setTextureName(Ref.MODID + ":"+ASUNALT).setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
	public static final Item ingot_eruslalt = new Item().setUnlocalizedName(ERUSLALT).setTextureName(Ref.MODID + ":"+ERUSLALT).setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
	public static final Item ingot_ithasium = new Item().setUnlocalizedName(ITHASIUM).setTextureName(Ref.MODID + ":"+ITHASIUM).setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
	public static final Item ingot_ozestum = new Item().setUnlocalizedName(OZESTUM).setTextureName(Ref.MODID + ":"+OZESTUM).setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
	public static final Item ingot_emodralt = new Item().setUnlocalizedName(EMODRALT).setTextureName(Ref.MODID + ":"+EMODRALT).setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
	public static final Item ingot_evosum = new Item().setUnlocalizedName(EVOSUM).setTextureName(Ref.MODID + ":"+EVOSUM).setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
	public static final Item ingot_nautrenese = new Item().setUnlocalizedName(NAUTRENESE).setTextureName(Ref.MODID + ":"+NAUTRENESE).setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
	public static final Item ingot_axespium = new Item().setUnlocalizedName(AXESPIUM).setTextureName(Ref.MODID + ":"+AXESPIUM).setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
	public static final Item ingot_ketsuekium = new Item().setUnlocalizedName(KETSUEKIUM).setTextureName(Ref.MODID + ":"+KETSUEKIUM).setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
	public static final Item ingot_shikyolt = new Item().setUnlocalizedName(SHIKYOLT).setTextureName(Ref.MODID + ":"+SHIKYOLT).setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
	public static final Item ingot_sakuralt = new Item().setUnlocalizedName(SAKURALT).setTextureName(Ref.MODID + ":"+SAKURALT).setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
	public static final Item ingot_ayagrese = new Item().setUnlocalizedName(AYAGRESE).setTextureName(Ref.MODID + ":"+AYAGRESE).setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
	public static final Item ingot_tenshirium = new Item().setUnlocalizedName(TENSHIRIUM).setTextureName(Ref.MODID + ":"+TENSHIRIUM).setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
	public static final Item ingot_onecrum = new Item().setUnlocalizedName(ONECRUM).setTextureName(Ref.MODID + ":"+ONECRUM).setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);

	public static final Item mixedIngot = new MixedIngot().setUnlocalizedName("mixedIngot").setMaxStackSize(1).setCreativeTab(RPGOMain.myTab);

	public static final Item alloyIngot = new AlloyIngot().setUnlocalizedName("alloyIngot").setMaxStackSize(1).setCreativeTab(RPGOMain.myTab);

	public static void init() {
		GameRegistry.registerItem(mixedIngot, "mixedIngot");
		GameRegistry.registerItem(alloyIngot, "alloyIngot");

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
