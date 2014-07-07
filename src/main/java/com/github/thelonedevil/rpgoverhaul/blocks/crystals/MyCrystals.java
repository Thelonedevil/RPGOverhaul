package com.github.thelonedevil.rpgoverhaul.blocks.crystals;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.github.thelonedevil.rpgoverhaul.MyItems;
import com.github.thelonedevil.rpgoverhaul.RPGOMain;
import com.github.thelonedevil.rpgoverhaul.Ref;

import cpw.mods.fml.common.registry.GameRegistry;

public class MyCrystals {
	
	public static Block Fire_Crystal;
	public static Block Water_Crystal;
	public static Block Earth_Crystal;
	public static Block Air_Crystal;

	
	public static void init(){
		Fire_Crystal  = new CrystalCluster(Material.rock,MyItems.crystal_fire,0 ).setBlockName("Fire_Crystal_Cluster").setHardness(10.0F).setStepSound(Block.soundTypeStone).setCreativeTab(RPGOMain.myTab);
		Fire_Crystal.setHarvestLevel("pickaxe", 0);
		
		Water_Crystal  = new CrystalCluster(Material.rock,MyItems.crystal_water,1).setBlockName("Water_Crystal_Cluster").setBlockTextureName(Ref.MODID+"Water_Crystal_Cluster").setHardness(10.0F).setStepSound(Block.soundTypeStone).setCreativeTab(RPGOMain.myTab);
		Water_Crystal.setHarvestLevel("pickaxe", 0);
		
		Air_Crystal  = new CrystalCluster(Material.rock,MyItems.crystal_air,2).setBlockName("Air_Crystal_Cluster").setBlockTextureName(Ref.MODID+"Air_Crystal_Cluster").setHardness(10.0F).setStepSound(Block.soundTypeStone).setCreativeTab(RPGOMain.myTab);
		Air_Crystal.setHarvestLevel("pickaxe", 0);
		
		Earth_Crystal  = new CrystalCluster(Material.rock,MyItems.crystal_earth,3).setBlockName("Earth_Crystal_Cluster").setBlockTextureName(Ref.MODID+"Earth_Crystal_Cluster").setHardness(10.0F).setStepSound(Block.soundTypeStone).setCreativeTab(RPGOMain.myTab);
		Earth_Crystal.setHarvestLevel("pickaxe", 0);
		

		
		GameRegistry.registerBlock(Fire_Crystal, "Fire Crystal Cluster");
		GameRegistry.registerBlock(Water_Crystal, "Water Crystal Cluster");
		GameRegistry.registerBlock(Air_Crystal, "Air Crystal Cluster");
		GameRegistry.registerBlock(Earth_Crystal, "Earth Crystal Cluster");
	}
}
