package com.github.thelonedevil.rpgoverhaul.blocks.crystals;

import com.github.thelonedevil.rpgoverhaul.MyItems;
import com.github.thelonedevil.rpgoverhaul.RPGOMain;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MyCrystals {
	
	public static Block Fire_Crystal;
	public static Block Water_Crystal;
	public static Block Earth_Crystal;
	public static Block Air_Crystal;

	
	public static void init(){
		Fire_Crystal  = new BaseCrystal(Material.rock,MyItems.crystal_fire).setBlockName("Fire_Crystal_Cluster").setBlockTextureName(RPGOMain.MODID+"Fire_Crystal_Cluster").setHardness(10.0F).setStepSound(Block.soundTypeStone).setCreativeTab(RPGOMain.myTab);
		Fire_Crystal.setHarvestLevel("pickaxe", 0);
		
		Water_Crystal  = new BaseCrystal(Material.rock,MyItems.crystal_water).setBlockName("Water_Crystal_Cluster").setBlockTextureName(RPGOMain.MODID+"Water_Crystal_Cluster").setHardness(10.0F).setStepSound(Block.soundTypeStone).setCreativeTab(RPGOMain.myTab);
		Water_Crystal.setHarvestLevel("pickaxe", 0);
		
		Air_Crystal  = new BaseCrystal(Material.rock,MyItems.crystal_air).setBlockName("Air_Crystal_Cluster").setBlockTextureName(RPGOMain.MODID+"Air_Crystal_Cluster").setHardness(10.0F).setStepSound(Block.soundTypeStone).setCreativeTab(RPGOMain.myTab);
		Air_Crystal.setHarvestLevel("pickaxe", 0);
		
		Earth_Crystal  = new BaseCrystal(Material.rock,MyItems.crystal_earth).setBlockName("Earth_Crystal_Cluster").setBlockTextureName(RPGOMain.MODID+"Earth_Crystal_Cluster").setHardness(10.0F).setStepSound(Block.soundTypeStone).setCreativeTab(RPGOMain.myTab);
		Earth_Crystal.setHarvestLevel("pickaxe", 0);
		

		
		GameRegistry.registerBlock(Fire_Crystal, "Fire Crystal Cluster");
		GameRegistry.registerBlock(Water_Crystal, "Water Crystal Cluster");
		GameRegistry.registerBlock(Air_Crystal, "Air Crystal Cluster");
		GameRegistry.registerBlock(Earth_Crystal, "Earth Crystal Cluster");
	}
}
