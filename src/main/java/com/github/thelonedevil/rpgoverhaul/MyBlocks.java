package com.github.thelonedevil.rpgoverhaul;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.github.thelonedevil.rpgoverhaul.blocks.CustomChest;
import com.github.thelonedevil.rpgoverhaul.blocks.alloy_furnace.Alloy_Furnace;
import com.github.thelonedevil.rpgoverhaul.blocks.ores.Asunalt_ore;
import com.github.thelonedevil.rpgoverhaul.blocks.ores.Farunese_ore;
import com.github.thelonedevil.rpgoverhaul.blocks.ores.Kiritorium_ore;
import com.github.thelonedevil.rpgoverhaul.blocks.ores.Orobalt_ore;
import com.github.thelonedevil.rpgoverhaul.blocks.ores.Xiatherium_ore;

import cpw.mods.fml.common.registry.GameRegistry;

public class MyBlocks {

	public static Block ore_xiatherium;
	public static Block ore_farunese;
	public static Block ore_orobalt;
	public static Block ore_kiritorium;
	public static Block ore_asunalt;
	public static Block AlloyFurnace;
	public static Block AlloyFurnaceActive;
	public static Block LootChest;

	public static void init() {
		ore_xiatherium = new Xiatherium_ore(Material.ground).setBlockTextureName(RPGOMain.MODID + ":xiatherium_ore").setCreativeTab(RPGOMain.myTab).setStepSound(Block.soundTypeStone)
				.setBlockName("xiatherium_ore");
		ore_farunese = new Farunese_ore(Material.ground).setBlockTextureName(RPGOMain.MODID + ":farunese_ore").setCreativeTab(RPGOMain.myTab).setStepSound(Block.soundTypeStone)
				.setBlockName("farunese_ore");
		ore_orobalt = new Orobalt_ore(Material.ground).setBlockTextureName(RPGOMain.MODID + ":orbalt_ore").setCreativeTab(RPGOMain.myTab).setStepSound(Block.soundTypeStone)
				.setBlockName("orobalt_ore");
		ore_kiritorium = new Kiritorium_ore(Material.ground).setBlockTextureName(RPGOMain.MODID + ":kiritorium_ore").setCreativeTab(RPGOMain.myTab).setStepSound(Block.soundTypeStone)
				.setBlockName("kiritorium_ore");
		ore_asunalt = new Asunalt_ore(Material.ground).setBlockTextureName(RPGOMain.MODID + ":asunalt_ore").setCreativeTab(RPGOMain.myTab).setStepSound(Block.soundTypeStone)
				.setBlockName("asunalt_ore");
		
		ore_xiatherium.setHarvestLevel("pickaxe", 2);
		ore_farunese.setHarvestLevel("pickaxe", 2);
		ore_orobalt.setHarvestLevel("pickaxe", 2);
		ore_kiritorium.setHarvestLevel("pickaxe", 2);
		ore_asunalt.setHarvestLevel("pickaxe", 2);
		
		AlloyFurnace = new Alloy_Furnace(false).setBlockName("alloyfurnace").setCreativeTab(RPGOMain.myTab);
		AlloyFurnaceActive = new Alloy_Furnace(true).setBlockName("alloyfurnaceactive");
		
		LootChest = new CustomChest(0).setBlockName("lootChest").setCreativeTab(RPGOMain.myTab).setHardness(-1.0f);
		
		GameRegistry.registerBlock(ore_xiatherium, "Xiatherium_ore");
		GameRegistry.registerBlock(ore_farunese, "Farunese_ore");
		GameRegistry.registerBlock(ore_orobalt, "Orobalt_ore");
		GameRegistry.registerBlock(ore_kiritorium, "Kiritorium_ore");
		GameRegistry.registerBlock(ore_asunalt, "Asunalt_ore");
		GameRegistry.registerBlock(AlloyFurnace, "Alloy_Furnace");
		GameRegistry.registerBlock(AlloyFurnaceActive, "Alloy_Furnace_active");
		GameRegistry.registerBlock(LootChest, "LootChest");
	}

}
