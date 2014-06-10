package com.github.thelonedevil.rpgoverhaul.blocks.ores;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BaseOre extends Block {
	Item drop;

	public BaseOre(Material material, Item item) {
		super(material);
		drop = item;
	}

	public BaseOre(Material material) {
		super(material);
		
	}
}
