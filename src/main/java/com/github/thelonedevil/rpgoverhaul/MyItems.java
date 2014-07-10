package com.github.thelonedevil.rpgoverhaul;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;

import com.github.thelonedevil.rpgoverhaul.armour.Belt;
import com.github.thelonedevil.rpgoverhaul.armour.Helmet;
import com.github.thelonedevil.rpgoverhaul.items.AlloyIngot;
import com.github.thelonedevil.rpgoverhaul.items.MixedIngot;
import com.github.thelonedevil.rpgoverhaul.items.QuestBook;
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
	public static Item Parchment;
	public static Item goatSkin;
	public static Item foxFur;		
	
	//dummy items
	public static Item MIXABLE;
	public static Item questBook;
	

	public static void init() {
		
		MIXABLE = new Item();
		
		ingot_xiatherium = new Item().setUnlocalizedName("ingot_xiatherium").setTextureName(Ref.MODID + ":ingot_xiatherium").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_farunese = new Item().setUnlocalizedName("ingot_farunese").setTextureName(Ref.MODID + ":ingot_farunese").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_orobalt = new Item().setUnlocalizedName("ingot_orobalt").setTextureName(Ref.MODID + ":ingot_orobalt").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_kiritorium = new Item().setUnlocalizedName("ingot_kiritorium").setTextureName(Ref.MODID + ":ingot_kiritorium").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_asunalt = new Item().setUnlocalizedName("ingot_asunalt").setTextureName(Ref.MODID + ":ingot_asunalt").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_eruslalt = new Item().setUnlocalizedName("ingot_eruslalt").setTextureName(Ref.MODID + ":ingot_eruslalt").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_ithasium = new Item().setUnlocalizedName("ingot_ithasium").setTextureName(Ref.MODID + ":ingot_ithasium").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_ozestum = new Item().setUnlocalizedName("ingot_ozestum").setTextureName(Ref.MODID + ":ingot_ozestum").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_emodralt = new Item().setUnlocalizedName("ingot_emodralt").setTextureName(Ref.MODID + ":ingot_emodralt").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_evosum = new Item().setUnlocalizedName("ingot_evosum").setTextureName(Ref.MODID + ":ingot_evosum").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_nautrenese = new Item().setUnlocalizedName("ingot_nautrenese").setTextureName(Ref.MODID + ":ingot_nautrenese").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_axespium = new Item().setUnlocalizedName("ingot_axespium").setTextureName(Ref.MODID + ":ingot_axespium").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_ketsuekium = new Item().setUnlocalizedName("ingot_ketsuekium").setTextureName(Ref.MODID + ":ingot_ketsuekium").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_shikyolt = new Item().setUnlocalizedName("ingot_shikyolt").setTextureName(Ref.MODID + ":ingot_shikyolt").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_sakuralt = new Item().setUnlocalizedName("ingot_sakuralt").setTextureName(Ref.MODID + ":ingot_sakuralt").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_ayagrese = new Item().setUnlocalizedName("ingot_ayagrese").setTextureName(Ref.MODID + ":ingot_ayagrese").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_tenshirium = new Item().setUnlocalizedName("ingot_tenshirium").setTextureName(Ref.MODID + ":ingot_tenshirium").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);
		ingot_onecrum = new Item().setUnlocalizedName("ingot_onecrum").setTextureName(Ref.MODID + ":ingot_onecrum").setCreativeTab(RPGOMain.myTab).setMaxStackSize(64);

		mixedIngot = new MixedIngot().setUnlocalizedName("mixedIngot").setMaxStackSize(1).setCreativeTab(RPGOMain.myTab);
		GameRegistry.registerItem(mixedIngot, "mixedIngot");

		alloyIngot = new AlloyIngot().setUnlocalizedName("alloyIngot").setMaxStackSize(1).setCreativeTab(RPGOMain.myTab);
		GameRegistry.registerItem(alloyIngot, "alloyIngot");

		crystal_fire = new Item().setUnlocalizedName("crystal_fire").setTextureName(Ref.MODID + ":crystal_fire").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_water = new Item().setUnlocalizedName("crystal_water").setTextureName(Ref.MODID + ":crystal_water").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_air = new Item().setUnlocalizedName("crystal_air").setTextureName(Ref.MODID + ":crystal_air").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_earth = new Item().setUnlocalizedName("crystal_earth").setTextureName(Ref.MODID + ":crystal_earth").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_plasma = new Item().setUnlocalizedName("crystal_plasma").setTextureName(Ref.MODID + ":crystal_plasma").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_smelting = new Item().setUnlocalizedName("crystal_smelting").setTextureName(Ref.MODID + ":crystal_smelting").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_sun = new Item().setUnlocalizedName("crystal_sun").setTextureName(Ref.MODID + ":crystal_sun").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_moon = new Item().setUnlocalizedName("crystal_moon").setTextureName(Ref.MODID + ":crystal_moon").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);

		crystal_aries = new Item().setUnlocalizedName("crystal_aries").setTextureName(Ref.MODID + ":crystal_aires").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_taurus = new Item().setUnlocalizedName("crystal_taurus").setTextureName(Ref.MODID + ":crystal_taurus").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_gemini = new Item().setUnlocalizedName("crystal_gemini").setTextureName(Ref.MODID + ":crystal_gemini").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_cancer = new Item().setUnlocalizedName("crystal_cancer").setTextureName(Ref.MODID + ":crystal_cancer").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_leo = new Item().setUnlocalizedName("crystal_leo").setTextureName(Ref.MODID + ":crystal_leo").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_virgo = new Item().setUnlocalizedName("crystal_virgo").setTextureName(Ref.MODID + ":crystal_virgo").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_libra = new Item().setUnlocalizedName("crystal_libra").setTextureName(Ref.MODID + ":crystal_libra").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_scorpio = new Item().setUnlocalizedName("crystal_scorpio").setTextureName(Ref.MODID + ":crystal_scorpio").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_sagittarius = new Item().setUnlocalizedName("crystal_sagittarius").setTextureName(Ref.MODID + ":crystal_sagittarius").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_capricorn = new Item().setUnlocalizedName("crystal_capricorn").setTextureName(Ref.MODID + ":crystal_capricorn").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_aquarius = new Item().setUnlocalizedName("crystal_aquarius").setTextureName(Ref.MODID + ":crystal_aquarius").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_pisces = new Item().setUnlocalizedName("crystal_pisces").setTextureName(Ref.MODID + ":crystal_pisces").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);

		crystal_dragon_fire = new Item().setUnlocalizedName("crystal_dragon_fire").setTextureName(Ref.MODID + ":crystal_dragon_fire").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_dragon_sky = new Item().setUnlocalizedName("crystal_dragon_sky").setTextureName(Ref.MODID + ":crystal_dragon_sky").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_dragon_iron = new Item().setUnlocalizedName("crystal_dragon_iron").setTextureName(Ref.MODID + ":crystal_dragon_iron").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_dragon_lightning = new Item().setUnlocalizedName("crystal_dragon_lightning").setTextureName(Ref.MODID + ":crystal_").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_dragon_shadow = new Item().setUnlocalizedName("crystal_dragon_shadow").setTextureName(Ref.MODID + ":crystal_dragon_shadow").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_dragon_light = new Item().setUnlocalizedName("crystal_dragon_light").setTextureName(Ref.MODID + ":crystal_dragon_light").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);

		crystal_crest_courage = new Item().setUnlocalizedName("crystal_crest_courage").setTextureName(Ref.MODID + ":crystal_crest_courage").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_crest_friendship = new Item().setUnlocalizedName("crystal_crest_friendship").setTextureName(Ref.MODID + ":crystal_crest_friendship").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_crest_love = new Item().setUnlocalizedName("crystal_crest_love").setTextureName(Ref.MODID + ":crystal_crest_love").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_crest_sincerity = new Item().setUnlocalizedName("crystal_crest_sincerity").setTextureName(Ref.MODID + ":crystal_crest_sincerity").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_crest_knowledge = new Item().setUnlocalizedName("crystal_crest_knowledge").setTextureName(Ref.MODID + ":crystal_crest_knowledge").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_crest_reliability = new Item().setUnlocalizedName("crystal_crest_reliability").setTextureName(Ref.MODID + ":crystal_crest_reliability").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_crest_hope = new Item().setUnlocalizedName("crystal_crest_hope").setTextureName(Ref.MODID + ":crystal_crest_hope").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_crest_light = new Item().setUnlocalizedName("crystal_crest_light").setTextureName(Ref.MODID + ":crystal_crest_light").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
		crystal_crest_kindness = new Item().setUnlocalizedName("crystal_crest_kindness").setTextureName(Ref.MODID + ":crystal_crest_kindness").setCreativeTab(RPGOMain.myTab).setMaxStackSize(8);
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
		
		RawGoat = new ItemFood(3, 0.3F, true).setTextureName(Ref.MODID+":goatRaw").setUnlocalizedName("rawGoat");
		GameRegistry.registerItem(RawGoat, "rawgoat");
		CookedGoat = new ItemFood(8, 0.8F, true).setTextureName(Ref.MODID+":goatCooked").setUnlocalizedName("cookedGoat");
		GameRegistry.registerItem(CookedGoat, "cookedgoat");
		Parchment = new Item().setUnlocalizedName("parchment").setTextureName(Ref.MODID + ":parchment").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(Parchment, "parchment");
		OreDictionary.registerOre("materialPaper", Parchment);
		OreDictionary.registerOre("materialPaper", Items.paper);
		goatSkin = new Item().setUnlocalizedName("goatSkin").setTextureName(Ref.MODID + ":goatSkin").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(goatSkin, "goatSkin");
		
		foxFur = new Item().setUnlocalizedName("foxFur").setTextureName(Ref.MODID + ":foxFur").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(foxFur, "foxFur");
		
		questBook = new QuestBook().setCreativeTab(RPGOMain.myTab);
		GameRegistry.registerItem(questBook, "questBook");
		
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

		GameRegistry.registerItem(crystal_fire, "Fire Crystal");
		GameRegistry.registerItem(crystal_water, "Water Crystal");
		GameRegistry.registerItem(crystal_air, "Air Crystal");
		GameRegistry.registerItem(crystal_earth, "Earth Crystal");
		GameRegistry.registerItem(crystal_plasma, "Plasma Crystal");
		GameRegistry.registerItem(crystal_smelting, "Smelting Crystal");
		GameRegistry.registerItem( crystal_sun,"Sun Crystal");
		GameRegistry.registerItem( crystal_moon,"Moon Crystal");

		GameRegistry.registerItem( crystal_aries,"Aries Crystal");
		GameRegistry.registerItem( crystal_taurus,"Taurus Crystal");
		GameRegistry.registerItem( crystal_gemini,"Gemini Crystal");
		GameRegistry.registerItem( crystal_cancer,"Cancer Crystal");
		GameRegistry.registerItem( crystal_leo,"Leo Crystal");
		GameRegistry.registerItem( crystal_virgo,"Virgo Crystal");
		GameRegistry.registerItem( crystal_libra,"Libra Crystal");
		GameRegistry.registerItem( crystal_scorpio,"Scorpio Crystal");
		GameRegistry.registerItem( crystal_sagittarius,"Sagittarius Crystal");
		GameRegistry.registerItem( crystal_capricorn,"Capricorn Crystal");
		GameRegistry.registerItem( crystal_aquarius,"Aquarius Crystal");
		GameRegistry.registerItem( crystal_pisces,"Pisces Crystal");

		GameRegistry.registerItem( crystal_dragon_fire,"Fire Dragon Crystal");
		GameRegistry.registerItem( crystal_dragon_sky,"Sky Dragon Crystal");
		GameRegistry.registerItem( crystal_dragon_iron,"Iron Dragon Crystal");
		GameRegistry.registerItem( crystal_dragon_lightning,"Lightning Dragon Crystal");
		GameRegistry.registerItem( crystal_dragon_shadow,"Shadow Dragon Crystal");
		GameRegistry.registerItem( crystal_dragon_light,"Light Dragon Crystal");

		GameRegistry.registerItem( crystal_crest_courage,"Crest Courage Crystal");
		GameRegistry.registerItem( crystal_crest_friendship,"Crest Friendship Crystal");
		GameRegistry.registerItem( crystal_crest_love,"Crest Love Crystal");
		GameRegistry.registerItem( crystal_crest_sincerity,"Crest Sincerity Crystal");
		GameRegistry.registerItem( crystal_crest_knowledge,"Crest Knowledge Crystal");
		GameRegistry.registerItem( crystal_crest_reliability,"Crest Reliability Crystal");
		GameRegistry.registerItem( crystal_crest_hope,"Crest Hope Crystal");
		GameRegistry.registerItem( crystal_crest_light,"Crest Light Crystal");
		GameRegistry.registerItem( crystal_crest_kindness,"Crest Kindness Crystal");

	}

}
