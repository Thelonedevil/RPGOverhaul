package com.github.thelonedevil.rpgoverhaul.blocks.ores;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;

import com.github.thelonedevil.rpgoverhaul.RPGOMain;

public class Base_Ore extends BlockOre {

	public Base_Ore() {
		super();
		this.setCreativeTab(RPGOMain.MetalTab);
		this.setStepSound(Block.soundTypeStone);
		this.setHardness(10.0f);
		this.blockResistance = 10.0f;
	}

}
