package com.github.thelonedevil.rpgoverhaul.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenCrystal extends WorldGenerator {
	private Block block;

	public WorldGenCrystal(Block p_i45451_1_) {
		this.block = p_i45451_1_;
	}

	public boolean generate(World world, Random random, int x, int y, int z) {
		Block block = world.getBlock(x, y, z);
		Block block1 = world.getBlock(x, y - 1, z);
		if (world.isAirBlock(x, y, z)) {
			if (!world.isAirBlock(x, y - 1, z)) {
				world.setBlock(x, y, z, this.block);
			}
		}

		return true;
	}
}