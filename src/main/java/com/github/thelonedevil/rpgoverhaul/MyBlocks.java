package com.github.thelonedevil.rpgoverhaul;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import com.github.thelonedevil.rpgoverhaul.blocks.CustomChest;
import com.github.thelonedevil.rpgoverhaul.blocks.WeaponSmith;
import com.github.thelonedevil.rpgoverhaul.blocks.alloy_furnace.Alloy_Furnace;
import com.github.thelonedevil.rpgoverhaul.blocks.ores.Base_Ore;

import cpw.mods.fml.common.registry.GameRegistry;

public class MyBlocks {

	public static Block ore_xiatherium;
	public static Block ore_farunese;
	public static Block ore_orobalt;
	public static Block ore_kiritorium;
	public static Block ore_asunalt;
	public static Block ore_eruslalt;
	public static Block ore_ithasium;
	public static Block ore_ozestum;
	public static Block ore_emodralt;
	public static Block ore_evosum;
	public static Block ore_nautrenese;
	public static Block ore_axespium;
	public static Block ore_ketsuekium;
	public static Block ore_shikyolt;
	public static Block ore_sakuralt;
	public static Block ore_ayagrese;
	public static Block ore_tenshirium;
	public static Block ore_onecrum;

	public static Block AlloyFurnace;
	public static Block AlloyFurnaceActive;
	public static Block LootChest;
	public static Block WeaponSmithblock;

	public static void init() {
		ore_xiatherium = new Base_Ore().setBlockTextureName(RPGOMain.MODID + ":xiatherium_ore").setBlockName("xiatherium_ore");
		ore_farunese = new Base_Ore().setBlockTextureName(RPGOMain.MODID + ":farunese_ore").setBlockName("farunese_ore");
		ore_orobalt = new Base_Ore().setBlockTextureName(RPGOMain.MODID + ":orobalt_ore").setBlockName("orobalt_ore");
		ore_kiritorium = new Base_Ore().setBlockTextureName(RPGOMain.MODID + ":kiritorium_ore").setBlockName("kiritorium_ore");
		ore_asunalt = new Base_Ore().setBlockTextureName(RPGOMain.MODID + ":asunalt_ore").setBlockName("asunalt_ore");
		ore_eruslalt = new Base_Ore().setBlockTextureName(RPGOMain.MODID + ":eruslalt_ore").setBlockName("eruslalt_ore");
		ore_ithasium = new Base_Ore().setBlockTextureName(RPGOMain.MODID + ":ithasium_ore").setBlockName("ithasium_ore");
		ore_ozestum = new Base_Ore().setBlockTextureName(RPGOMain.MODID + ":ozestum_ore").setBlockName("ozestum_ore");
		ore_emodralt = new Base_Ore().setBlockTextureName(RPGOMain.MODID + ":emodralt_ore").setBlockName("emodralt_ore");
		ore_evosum = new Base_Ore().setBlockTextureName(RPGOMain.MODID + ":evosum_ore").setBlockName("evosum_ore");
		ore_nautrenese = new Base_Ore().setBlockTextureName(RPGOMain.MODID + ":nautrenese_ore").setBlockName("nautrenese_ore");
		ore_axespium = new Base_Ore().setBlockTextureName(RPGOMain.MODID + ":axespium_ore").setBlockName("axespium_ore");
		ore_ketsuekium = new Base_Ore().setBlockTextureName(RPGOMain.MODID + ":ketsuekium_ore").setBlockName("ketsuekium_ore");
		ore_shikyolt = new Base_Ore().setBlockTextureName(RPGOMain.MODID + ":shikyolt_ore").setBlockName("shikyolt_ore");
		ore_sakuralt = new Base_Ore().setBlockTextureName(RPGOMain.MODID + ":sakuralt_ore").setBlockName("sakuralt_ore");
		ore_ayagrese = new Base_Ore().setBlockTextureName(RPGOMain.MODID + ":ayagrese_ore").setBlockName("ayagrese_ore");
		ore_tenshirium = new Base_Ore().setBlockTextureName(RPGOMain.MODID + ":tenshirium_ore").setBlockName("tenshirium_ore");
		ore_onecrum = new Base_Ore().setBlockTextureName(RPGOMain.MODID + ":onecrum_ore").setBlockName("onecrum_ore");

		ore_xiatherium.setHarvestLevel("pickaxe", 2);
		ore_farunese.setHarvestLevel("pickaxe", 2);
		ore_orobalt.setHarvestLevel("pickaxe", 2);
		ore_kiritorium.setHarvestLevel("pickaxe", 2);
		ore_asunalt.setHarvestLevel("pickaxe", 2);
		ore_eruslalt.setHarvestLevel("pickaxe", 2);
		ore_ithasium.setHarvestLevel("pickaxe", 2);
		ore_ozestum.setHarvestLevel("pickaxe", 2);
		ore_emodralt.setHarvestLevel("pickaxe", 2);
		ore_evosum.setHarvestLevel("pickaxe", 2);
		ore_nautrenese.setHarvestLevel("pickaxe", 2);
		ore_axespium.setHarvestLevel("pickaxe", 2);
		ore_ketsuekium.setHarvestLevel("pickaxe", 2);
		ore_shikyolt.setHarvestLevel("pickaxe", 2);
		ore_sakuralt.setHarvestLevel("pickaxe", 2);
		ore_ayagrese.setHarvestLevel("pickaxe", 2);
		ore_tenshirium.setHarvestLevel("pickaxe", 2);
		ore_onecrum.setHarvestLevel("pickaxe", 2);

		//AlloyFurnace = new Alloy_Furnace(false).setBlockName("alloyfurnace").setCreativeTab(RPGOMain.myTab);
		//AlloyFurnaceActive = new Alloy_Furnace(true).setBlockName("alloyfurnaceactive");

		LootChest = new CustomChest(0).setBlockName("lootChest").setCreativeTab(RPGOMain.myTab).setBlockUnbreakable().setResistance(2000000.0f);
		WeaponSmithblock = new WeaponSmith().setBlockName("weaponsmith").setCreativeTab(RPGOMain.myTab);
		GameRegistry.registerBlock(ore_xiatherium, "Xiatherium_ore");
		GameRegistry.registerBlock(ore_farunese, "Farunese_ore");
		GameRegistry.registerBlock(ore_orobalt, "Orobalt_ore");
		GameRegistry.registerBlock(ore_kiritorium, "Kiritorium_ore");
		GameRegistry.registerBlock(ore_asunalt, "Asunalt_ore");
		GameRegistry.registerBlock(ore_eruslalt, "Eruslalt_ore");
		GameRegistry.registerBlock(ore_ithasium, "Ithasium_ore");
		GameRegistry.registerBlock(ore_ozestum, "Ozestum_ore");
		GameRegistry.registerBlock(ore_emodralt, "Emodralt_ore");
		GameRegistry.registerBlock(ore_evosum, "Evosum_ore");
		GameRegistry.registerBlock(ore_nautrenese, "Nautrenese_ore");
		GameRegistry.registerBlock(ore_axespium, "Axespium_ore");
		GameRegistry.registerBlock(ore_ketsuekium, "Ketsuekium_ore");
		GameRegistry.registerBlock(ore_shikyolt, "Shikyolt_ore");
		GameRegistry.registerBlock(ore_sakuralt, "Sakuralt_ore");
		GameRegistry.registerBlock(ore_ayagrese, "Ayagrese_ore");
		GameRegistry.registerBlock(ore_tenshirium, "Tenshirium_ore");
		GameRegistry.registerBlock(ore_onecrum, "Onecrum_ore");

		//GameRegistry.registerBlock(AlloyFurnace, "Alloy_Furnace");
		//GameRegistry.registerBlock(AlloyFurnaceActive, "Alloy_Furnace_active");
		GameRegistry.registerBlock(LootChest, "LootChest");
		GameRegistry.registerBlock(WeaponSmithblock, "WeaponSmith");
	}

}
