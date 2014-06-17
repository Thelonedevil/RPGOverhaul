package com.github.thelonedevil.rpgoverhaul.blocks.crystals;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BaseCrystal extends Block{
	
	Item drop;

	public BaseCrystal(Material material, Item item) {
		super(material);
		drop = item;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune) {
		return drop;
	}

}
