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
		Block block;

		do {
			block = world.getBlock(x, y, z);
			if (!(block.isLeaves(world, x, y, z) || block.isAir(world, x, y, z))) {
				break;
			}
			--y;
		} while (y > 0);

		for (int l = 0; l < 4; ++l) {
			int i1 = x + random.nextInt(8) - random.nextInt(8);
			int j1 = y + random.nextInt(4) - random.nextInt(4);
			int k1 = z + random.nextInt(8) - random.nextInt(8);

			if (world.isAirBlock(i1, j1, k1) && !world.isAirBlock(i1, j1 - 1, k1)) {
				world.setBlock(i1, j1, k1, this.block, 0, 2);
			}
		}

		return true;
	}
}