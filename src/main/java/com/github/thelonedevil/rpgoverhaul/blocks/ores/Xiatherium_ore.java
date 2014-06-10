package com.github.thelonedevil.rpgoverhaul.blocks.ores;

import com.github.thelonedevil.rpgoverhaul.MyBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class Xiatherium_ore extends BaseOre {

	public Xiatherium_ore(Material material) {
		super(material);
		drop = Item.getItemFromBlock(MyBlocks.ore_xiatherium);
		// TODO Auto-generated constructor stub
	}

}
