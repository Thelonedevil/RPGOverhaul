package com.github.thelonedevil.rpgoverhaul.world;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import com.github.thelonedevil.rpgoverhaul.MyBlocks;

import cpw.mods.fml.common.IWorldGenerator;

public class CustomGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		world.setBlock(chunkX*16 + random.nextInt(16), 7, chunkZ*16 + random.nextInt(16), MyBlocks.ore_farunese);
		world.setBlock(chunkX*16 + random.nextInt(16), 7, chunkZ*16 + random.nextInt(16), MyBlocks.ore_orobalt);
		world.setBlock(chunkX*16 + random.nextInt(16), 7, chunkZ*16 + random.nextInt(16), MyBlocks.ore_xiatherium);
		world.setBlock(chunkX*16 + random.nextInt(16), 8, chunkZ*16 + random.nextInt(16), MyBlocks.ore_farunese);
		world.setBlock(chunkX*16 + random.nextInt(16), 8, chunkZ*16 + random.nextInt(16), MyBlocks.ore_orobalt);
		world.setBlock(chunkX*16 + random.nextInt(16), 8, chunkZ*16 + random.nextInt(16), MyBlocks.ore_xiatherium);
		world.setBlock(chunkX*16 + random.nextInt(16), 9, chunkZ*16 + random.nextInt(16), MyBlocks.ore_farunese);
		world.setBlock(chunkX*16 + random.nextInt(16), 9, chunkZ*16 + random.nextInt(16), MyBlocks.ore_orobalt);
		world.setBlock(chunkX*16 + random.nextInt(16), 9, chunkZ*16 + random.nextInt(16), MyBlocks.ore_xiatherium);
		world.setBlock(chunkX*16 + random.nextInt(16), 7, chunkZ*16 + random.nextInt(16), MyBlocks.ore_farunese);
		world.setBlock(chunkX*16 + random.nextInt(16), 7, chunkZ*16 + random.nextInt(16), MyBlocks.ore_orobalt);
		world.setBlock(chunkX*16 + random.nextInt(16), 7, chunkZ*16 + random.nextInt(16), MyBlocks.ore_xiatherium);
		world.setBlock(chunkX*16 + random.nextInt(16), 8, chunkZ*16 + random.nextInt(16), MyBlocks.ore_farunese);
		world.setBlock(chunkX*16 + random.nextInt(16), 8, chunkZ*16 + random.nextInt(16), MyBlocks.ore_orobalt);
		world.setBlock(chunkX*16 + random.nextInt(16), 8, chunkZ*16 + random.nextInt(16), MyBlocks.ore_xiatherium);
		world.setBlock(chunkX*16 + random.nextInt(16), 9, chunkZ*16 + random.nextInt(16), MyBlocks.ore_farunese);
		world.setBlock(chunkX*16 + random.nextInt(16), 9, chunkZ*16 + random.nextInt(16), MyBlocks.ore_orobalt);
		world.setBlock(chunkX*16 + random.nextInt(16), 9, chunkZ*16 + random.nextInt(16), MyBlocks.ore_xiatherium);
		world.setBlock(chunkX*16 + random.nextInt(16), 7, chunkZ*16 + random.nextInt(16), MyBlocks.ore_farunese);
		world.setBlock(chunkX*16 + random.nextInt(16), 7, chunkZ*16 + random.nextInt(16), MyBlocks.ore_orobalt);
		world.setBlock(chunkX*16 + random.nextInt(16), 7, chunkZ*16 + random.nextInt(16), MyBlocks.ore_xiatherium);
		world.setBlock(chunkX*16 + random.nextInt(16), 8, chunkZ*16 + random.nextInt(16), MyBlocks.ore_farunese);
		world.setBlock(chunkX*16 + random.nextInt(16), 8, chunkZ*16 + random.nextInt(16), MyBlocks.ore_orobalt);
		world.setBlock(chunkX*16 + random.nextInt(16), 8, chunkZ*16 + random.nextInt(16), MyBlocks.ore_xiatherium);
		world.setBlock(chunkX*16 + random.nextInt(16), 9, chunkZ*16 + random.nextInt(16), MyBlocks.ore_farunese);
		world.setBlock(chunkX*16 + random.nextInt(16), 9, chunkZ*16 + random.nextInt(16), MyBlocks.ore_orobalt);
		world.setBlock(chunkX*16 + random.nextInt(16), 9, chunkZ*16 + random.nextInt(16), MyBlocks.ore_xiatherium);

	}
}
