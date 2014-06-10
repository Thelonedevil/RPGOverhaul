package com.github.thelonedevil.rpgoverhaul.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class CustomGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		Chunk chunk = world.getChunkFromChunkCoords(chunkX, chunkZ);
		for (int a = 1; a <= 14; a++) {
			for (int b = 32; b <= 256; b++) {
				for (int c = 1; c <= 14; c++) {
					Block block = chunk.getBlock(a, b, c);
					Block block1 = chunk.getBlock(a + 1, b, c);

					Block block3 = chunk.getBlock(a - 1, b, c);

					Block block5 = chunk.getBlock(a, b, c + 1);
					Block block6 = chunk.getBlock(a, b, c - 1);

					if (block == Blocks.water) {
						world.setBlockToAir(a, b, c);
					}
					if (block1 == Blocks.water) {
						world.setBlockToAir(a + 1, b, c);

					}
					if (block3 == Blocks.water) {
						world.setBlockToAir(a - 1, b, c);

					}
					if (block5 == Blocks.water) {
						world.setBlockToAir(a, b, c + 1);
					}
					if (block6 == Blocks.water) {
						world.setBlockToAir(a, b, c - 1);

					}
				}
			}
		}

	}
}
