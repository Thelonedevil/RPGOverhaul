package com.github.thelonedevil.rpgoverhaul.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.github.thelonedevil.rpgoverhaul.MyBlocks;

import cpw.mods.fml.common.IWorldGenerator;

public class CustomGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		/*
		 * int y = random.nextInt(24); world.setBlock(chunkX * 16 +
		 * random.nextInt(16), y + 1 + random.nextInt(5), chunkZ * 16 +
		 * random.nextInt(16), MyBlocks.ore_farunese); world.setBlock(chunkX *
		 * 16 + random.nextInt(16), y + 1 + random.nextInt(5), chunkZ * 16 +
		 * random.nextInt(16), MyBlocks.ore_orobalt); world.setBlock(chunkX * 16
		 * + random.nextInt(16), y + 1 + random.nextInt(5), chunkZ * 16 +
		 * random.nextInt(16), MyBlocks.ore_xiatherium); world.setBlock(chunkX *
		 * 16 + random.nextInt(16), y + 1 + random.nextInt(5), chunkZ * 16 +
		 * random.nextInt(16), MyBlocks.ore_asunalt); world.setBlock(chunkX * 16
		 * + random.nextInt(16), y + 1 + random.nextInt(5), chunkZ * 16 +
		 * random.nextInt(16), MyBlocks.ore_axespium); world.setBlock(chunkX *
		 * 16 + random.nextInt(16), y + 1 + random.nextInt(5), chunkZ * 16 +
		 * random.nextInt(16), MyBlocks.ore_ayagrese); world.setBlock(chunkX *
		 * 16 + random.nextInt(16), y + 1 + random.nextInt(5), chunkZ * 16 +
		 * random.nextInt(16), MyBlocks.ore_emodralt); world.setBlock(chunkX *
		 * 16 + random.nextInt(16), y + 1 + random.nextInt(5), chunkZ * 16 +
		 * random.nextInt(16), MyBlocks.ore_eruslalt); world.setBlock(chunkX *
		 * 16 + random.nextInt(16), y + 1 + random.nextInt(5), chunkZ * 16 +
		 * random.nextInt(16), MyBlocks.ore_evosum); world.setBlock(chunkX * 16
		 * + random.nextInt(16), y + 1 + random.nextInt(5), chunkZ * 16 +
		 * random.nextInt(16), MyBlocks.ore_ithasium); world.setBlock(chunkX *
		 * 16 + random.nextInt(16), y + 1 + random.nextInt(5), chunkZ * 16 +
		 * random.nextInt(16), MyBlocks.ore_ketsuekium); world.setBlock(chunkX *
		 * 16 + random.nextInt(16), y + 1 + random.nextInt(5), chunkZ * 16 +
		 * random.nextInt(16), MyBlocks.ore_nautrenese); world.setBlock(chunkX *
		 * 16 + random.nextInt(16), y + 1 + random.nextInt(5), chunkZ * 16 +
		 * random.nextInt(16), MyBlocks.ore_onecrum); world.setBlock(chunkX * 16
		 * + random.nextInt(16), y + 1 + random.nextInt(5), chunkZ * 16 +
		 * random.nextInt(16), MyBlocks.ore_ozestum); world.setBlock(chunkX * 16
		 * + random.nextInt(16), y + 1 + random.nextInt(5), chunkZ * 16 +
		 * random.nextInt(16), MyBlocks.ore_sakuralt); world.setBlock(chunkX *
		 * 16 + random.nextInt(16), y + 1 + random.nextInt(5), chunkZ * 16 +
		 * random.nextInt(16), MyBlocks.ore_shikyolt); world.setBlock(chunkX *
		 * 16 + random.nextInt(16), y + 1 + random.nextInt(5), chunkZ * 16 +
		 * random.nextInt(16), MyBlocks.ore_tenshirium);
		 */

		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateEnd(World world, Random random, int x, int z) {

	}

	private void generateSurface(World world, Random random, int x, int z) {
		this.addOreSpawn(MyBlocks.ore_asunalt, world, random, x, z, 16, 16, 4 + random.nextInt(3), 5, 15, 50);
		this.addOreSpawn(MyBlocks.ore_axespium, world, random, x, z, 16, 16, 4 + random.nextInt(3), 5, 15, 50);
		this.addOreSpawn(MyBlocks.ore_ayagrese, world, random, x, z, 16, 16, 4 + random.nextInt(3), 5, 15, 50);
		this.addOreSpawn(MyBlocks.ore_emodralt, world, random, x, z, 16, 16, 4 + random.nextInt(3), 5, 15, 50);
		this.addOreSpawn(MyBlocks.ore_eruslalt, world, random, x, z, 16, 16, 4 + random.nextInt(3), 5, 15, 50);
		this.addOreSpawn(MyBlocks.ore_evosum, world, random, x, z, 16, 16, 4 + random.nextInt(3), 5, 15, 50);
		this.addOreSpawn(MyBlocks.ore_farunese, world, random, x, z, 16, 16, 4 + random.nextInt(3), 5, 15, 50);
		this.addOreSpawn(MyBlocks.ore_ithasium, world, random, x, z, 16, 16, 4 + random.nextInt(3), 5, 15, 50);
		this.addOreSpawn(MyBlocks.ore_ketsuekium, world, random, x, z, 16, 16, 4 + random.nextInt(3), 5, 15, 50);
		this.addOreSpawn(MyBlocks.ore_kiritorium, world, random, x, z, 16, 16, 4 + random.nextInt(3), 5, 15, 50);
		this.addOreSpawn(MyBlocks.ore_nautrenese, world, random, x, z, 16, 16, 4 + random.nextInt(3), 5, 15, 50);
		this.addOreSpawn(MyBlocks.ore_onecrum, world, random, x, z, 16, 16, 4 + random.nextInt(3), 5, 15, 50);
		this.addOreSpawn(MyBlocks.ore_orobalt, world, random, x, z, 16, 16, 4 + random.nextInt(3), 5, 15, 50);
		this.addOreSpawn(MyBlocks.ore_ozestum, world, random, x, z, 16, 16, 4 + random.nextInt(3), 5, 15, 50);
		this.addOreSpawn(MyBlocks.ore_sakuralt, world, random, x, z, 16, 16, 4 + random.nextInt(3), 5, 15, 50);
		this.addOreSpawn(MyBlocks.ore_shikyolt, world, random, x, z, 16, 16, 4 + random.nextInt(3), 5, 15, 50);
		this.addOreSpawn(MyBlocks.ore_tenshirium, world, random, x, z, 16, 16, 4 + random.nextInt(3), 5, 15, 50);
		this.addOreSpawn(MyBlocks.ore_xiatherium, world, random, x, z, 16, 16, 4 + random.nextInt(3), 5, 15, 50);
	}

	private void generateNether(World world, Random random, int x, int z) {

	}

	public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY) {
		assert maxY > minY : "The maximum Y must be greater than the Minimum Y";
		assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
		assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";
		assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
		assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

		int diffBtwnMinMaxY = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			(new WorldGenMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
		}
	}

}
