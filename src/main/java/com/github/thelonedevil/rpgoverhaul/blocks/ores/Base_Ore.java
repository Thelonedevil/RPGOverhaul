package com.github.thelonedevil.rpgoverhaul.blocks.ores;

import com.github.thelonedevil.rpgoverhaul.RPGOMain;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Base_Ore extends Block {

	public Base_Ore() {
		super(Material.rock);
		this.setCreativeTab(RPGOMain.myTab);
		this.setStepSound(Block.soundTypeStone);
		this.setHardness(10.0f);
		this.blockResistance= 10.0f;
	}

}
