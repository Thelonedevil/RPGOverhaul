package com.github.thelonedevil.rpgoverhaul;

import com.github.thelonedevil.rpgoverhaul.util.ArmourUtil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;

import com.github.thelonedevil.rpgoverhaul.armour.Belt;
import com.github.thelonedevil.rpgoverhaul.armour.Helmet;
import com.github.thelonedevil.rpgoverhaul.items.Crystal;
import com.github.thelonedevil.rpgoverhaul.items.QuestBook;

import cpw.mods.fml.common.registry.GameRegistry;

public class MyItems {

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

	public static Item crystal_crest_courage;
	public static Item crystal_crest_friendship;
	public static Item crystal_crest_love;
	public static Item crystal_crest_sincerity;
	public static Item crystal_crest_knowledge;
	public static Item crystal_crest_reliability;
	public static Item crystal_crest_hope;
	public static Item crystal_crest_light;
	public static Item crystal_crest_kindness;

	public static Item crystal_smelting;

	public static Item TestHelmet;
	public static Item TestPauldronL;
	public static Item TestPauldronR;
	public static Item TestCuirass;
	public static Item TestBracerL;
	public static Item TestBracerR;
	public static Item TestBelt;

	public static Item RawGoat;
	public static Item CookedGoat;
	public static Item RawGazelle;
	public static Item CookedGazelle;
	public static Item Parchment;
	public static Item goatSkin;
	public static Item foxFur;

	public static Item questBook;

	public static void init() {

		

		crystal_fire = new Crystal(0).setUnlocalizedName("crystal_fire").setTextureName(Ref.MODID + ":crystal_fire").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_water = new Crystal(1).setUnlocalizedName("crystal_water").setTextureName(Ref.MODID + ":crystal_water").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_air = new Crystal(2).setUnlocalizedName("crystal_air").setTextureName(Ref.MODID + ":crystal_air").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_earth = new Crystal(3).setUnlocalizedName("crystal_earth").setTextureName(Ref.MODID + ":crystal_earth").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_plasma = new Crystal(4).setUnlocalizedName("crystal_plasma").setTextureName(Ref.MODID + ":crystal_plasma").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_smelting = new Crystal(5).setUnlocalizedName("crystal_smelting").setTextureName(Ref.MODID + ":crystal_smelting").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_sun = new Crystal(6).setUnlocalizedName("crystal_sun").setTextureName(Ref.MODID + ":crystal_sun").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_moon = new Crystal(7).setUnlocalizedName("crystal_moon").setTextureName(Ref.MODID + ":crystal_moon").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);

		crystal_aries = new Crystal(8).setUnlocalizedName("crystal_aries").setTextureName(Ref.MODID + ":crystal_aires").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_taurus = new Crystal(9).setUnlocalizedName("crystal_taurus").setTextureName(Ref.MODID + ":crystal_taurus").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_gemini = new Crystal(10).setUnlocalizedName("crystal_gemini").setTextureName(Ref.MODID + ":crystal_gemini").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_cancer = new Crystal(11).setUnlocalizedName("crystal_cancer").setTextureName(Ref.MODID + ":crystal_cancer").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_leo = new Crystal(12).setUnlocalizedName("crystal_leo").setTextureName(Ref.MODID + ":crystal_leo").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_virgo = new Crystal(13).setUnlocalizedName("crystal_virgo").setTextureName(Ref.MODID + ":crystal_virgo").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_libra = new Crystal(14).setUnlocalizedName("crystal_libra").setTextureName(Ref.MODID + ":crystal_libra").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_scorpio = new Crystal(15).setUnlocalizedName("crystal_scorpio").setTextureName(Ref.MODID + ":crystal_scorpio").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_sagittarius = new Crystal(16).setUnlocalizedName("crystal_sagittarius").setTextureName(Ref.MODID + ":crystal_sagittarius").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_capricorn = new Crystal(17).setUnlocalizedName("crystal_capricorn").setTextureName(Ref.MODID + ":crystal_capricorn").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_aquarius = new Crystal(18).setUnlocalizedName("crystal_aquarius").setTextureName(Ref.MODID + ":crystal_aquarius").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_pisces = new Crystal(19).setUnlocalizedName("crystal_pisces").setTextureName(Ref.MODID + ":crystal_pisces").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);

		crystal_dragon_fire = new Crystal(20).setUnlocalizedName("crystal_dragon_fire").setTextureName(Ref.MODID + ":crystal_dragon_fire").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_dragon_sky = new Crystal(21).setUnlocalizedName("crystal_dragon_sky").setTextureName(Ref.MODID + ":crystal_dragon_sky").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_dragon_iron = new Crystal(22).setUnlocalizedName("crystal_dragon_iron").setTextureName(Ref.MODID + ":crystal_dragon_iron").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_dragon_lightning = new Crystal(23).setUnlocalizedName("crystal_dragon_lightning").setTextureName(Ref.MODID + ":crystal_").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_dragon_shadow = new Crystal(24).setUnlocalizedName("crystal_dragon_shadow").setTextureName(Ref.MODID + ":crystal_dragon_shadow").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_dragon_light = new Crystal(25).setUnlocalizedName("crystal_dragon_light").setTextureName(Ref.MODID + ":crystal_dragon_light").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);

		crystal_crest_courage = new Crystal(26).setUnlocalizedName("crystal_crest_courage").setTextureName(Ref.MODID + ":crystal_crest_courage").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_crest_friendship = new Crystal(27).setUnlocalizedName("crystal_crest_friendship").setTextureName(Ref.MODID + ":crystal_crest_friendship").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_crest_love = new Crystal(28).setUnlocalizedName("crystal_crest_love").setTextureName(Ref.MODID + ":crystal_crest_love").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_crest_sincerity = new Crystal(29).setUnlocalizedName("crystal_crest_sincerity").setTextureName(Ref.MODID + ":crystal_crest_sincerity").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_crest_knowledge = new Crystal(30).setUnlocalizedName("crystal_crest_knowledge").setTextureName(Ref.MODID + ":crystal_crest_knowledge").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_crest_reliability = new Crystal(31).setUnlocalizedName("crystal_crest_reliability").setTextureName(Ref.MODID + ":crystal_crest_reliability").setCreativeTab(RPGOMain.CrystalTab)
				.setMaxStackSize(8);
		crystal_crest_hope = new Crystal(32).setUnlocalizedName("crystal_crest_hope").setTextureName(Ref.MODID + ":crystal_crest_hope").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_crest_light = new Crystal(33).setUnlocalizedName("crystal_crest_light").setTextureName(Ref.MODID + ":crystal_crest_light").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);
		crystal_crest_kindness = new Crystal(34).setUnlocalizedName("crystal_crest_kindness").setTextureName(Ref.MODID + ":crystal_crest_kindness").setCreativeTab(RPGOMain.CrystalTab).setMaxStackSize(8);

		TestHelmet = new Helmet().setCreativeTab(RPGOMain.myTab).setUnlocalizedName(ArmourUtil.HELMET);
		GameRegistry.registerItem(TestHelmet, "testhelmet");
		TestBelt = new Belt(0.3D, 1, 20, 10D, 0, 0).setCreativeTab(RPGOMain.myTab).setUnlocalizedName("testbelt");
		GameRegistry.registerItem(TestBelt, "testbelt");

		RawGoat = new ItemFood(3, 0.3F, true).setTextureName(Ref.MODID + ":goatRaw").setUnlocalizedName("rawGoat");
		GameRegistry.registerItem(RawGoat, "rawgoat");
		CookedGoat = new ItemFood(8, 0.8F, true).setTextureName(Ref.MODID + ":goatCooked").setUnlocalizedName("cookedGoat");
		GameRegistry.registerItem(CookedGoat, "cookedgoat");
		RawGazelle = new ItemFood(3, 0.3F, true).setTextureName(Ref.MODID + ":gazelleRaw").setUnlocalizedName("rawGazelle");
		GameRegistry.registerItem(RawGazelle, "rawgazelle");
		CookedGazelle = new ItemFood(8, 0.8F, true).setTextureName(Ref.MODID + ":gazelleCooked").setUnlocalizedName("cookedGazelle");
		GameRegistry.registerItem(CookedGazelle, "cookedgazelle");
		Parchment = new Item().setUnlocalizedName("parchment").setTextureName(Ref.MODID + ":parchment").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(Parchment, "parchment");
		OreDictionary.registerOre("materialPaper", Parchment);
		OreDictionary.registerOre("materialPaper", Items.paper);
		goatSkin = new Item().setUnlocalizedName("goatSkin").setTextureName(Ref.MODID + ":goatSkin").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(goatSkin, "goatSkin");

		foxFur = new Item().setUnlocalizedName("foxFur").setTextureName(Ref.MODID + ":foxFur").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(foxFur, "foxFur");

		questBook = new QuestBook().setCreativeTab(RPGOMain.myTab).setTextureName(Ref.MODID + ":questbook");
		GameRegistry.registerItem(questBook, "questBook");

		

		GameRegistry.registerItem(crystal_fire, "Fire Crystal");
		GameRegistry.registerItem(crystal_water, "Water Crystal");
		GameRegistry.registerItem(crystal_air, "Air Crystal");
		GameRegistry.registerItem(crystal_earth, "Earth Crystal");
		GameRegistry.registerItem(crystal_plasma, "Plasma Crystal");
		GameRegistry.registerItem(crystal_smelting, "Smelting Crystal");
		GameRegistry.registerItem(crystal_sun, "Sun Crystal");
		GameRegistry.registerItem(crystal_moon, "Moon Crystal");

		GameRegistry.registerItem(crystal_aries, "Aries Crystal");
		GameRegistry.registerItem(crystal_taurus, "Taurus Crystal");
		GameRegistry.registerItem(crystal_gemini, "Gemini Crystal");
		GameRegistry.registerItem(crystal_cancer, "Cancer Crystal");
		GameRegistry.registerItem(crystal_leo, "Leo Crystal");
		GameRegistry.registerItem(crystal_virgo, "Virgo Crystal");
		GameRegistry.registerItem(crystal_libra, "Libra Crystal");
		GameRegistry.registerItem(crystal_scorpio, "Scorpio Crystal");
		GameRegistry.registerItem(crystal_sagittarius, "Sagittarius Crystal");
		GameRegistry.registerItem(crystal_capricorn, "Capricorn Crystal");
		GameRegistry.registerItem(crystal_aquarius, "Aquarius Crystal");
		GameRegistry.registerItem(crystal_pisces, "Pisces Crystal");

		GameRegistry.registerItem(crystal_dragon_fire, "Fire Dragon Crystal");
		GameRegistry.registerItem(crystal_dragon_sky, "Sky Dragon Crystal");
		GameRegistry.registerItem(crystal_dragon_iron, "Iron Dragon Crystal");
		GameRegistry.registerItem(crystal_dragon_lightning, "Lightning Dragon Crystal");
		GameRegistry.registerItem(crystal_dragon_shadow, "Shadow Dragon Crystal");
		GameRegistry.registerItem(crystal_dragon_light, "Light Dragon Crystal");

		GameRegistry.registerItem(crystal_crest_courage, "Crest Courage Crystal");
		GameRegistry.registerItem(crystal_crest_friendship, "Crest Friendship Crystal");
		GameRegistry.registerItem(crystal_crest_love, "Crest Love Crystal");
		GameRegistry.registerItem(crystal_crest_sincerity, "Crest Sincerity Crystal");
		GameRegistry.registerItem(crystal_crest_knowledge, "Crest Knowledge Crystal");
		GameRegistry.registerItem(crystal_crest_reliability, "Crest Reliability Crystal");
		GameRegistry.registerItem(crystal_crest_hope, "Crest Hope Crystal");
		GameRegistry.registerItem(crystal_crest_light, "Crest Light Crystal");
		GameRegistry.registerItem(crystal_crest_kindness, "Crest Kindness Crystal");

	}

}
