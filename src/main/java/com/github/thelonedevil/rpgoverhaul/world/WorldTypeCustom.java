package com.github.thelonedevil.rpgoverhaul.world;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerZoom;
import net.minecraftforge.common.DimensionManager;

public class WorldTypeCustom extends WorldType {
	public WorldTypeCustom() {
		super("RPGO");

		DimensionManager.unregisterProviderType(0);
		DimensionManager.registerProviderType(0, CustomWorldProvider.class, false);

	}

	@Override
	public GenLayer getBiomeLayer(long worldSeed, GenLayer parentLayer) {
		GenLayer ret = new CustomGenLayerBiome(200L, parentLayer, this);

		ret = GenLayerZoom.magnify(1000L, ret, 2);
		return ret;
	}

	@Override
	public WorldChunkManager getChunkManager(World world) {
		WorldChunkManager wcm = new WorldChunkManager(world);
		return wcm;
	}

	@Override
	public double getHorizon(World world) {
		return 35.0D;
	}

	public IChunkProvider getChunkGenerator(World world, String generatorOptions) {
		return new CustomChunkProvider(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled());
	}
}