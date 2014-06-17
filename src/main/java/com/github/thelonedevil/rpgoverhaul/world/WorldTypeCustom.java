package com.github.thelonedevil.rpgoverhaul.world;

import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerBiome;
import net.minecraft.world.gen.layer.GenLayerBiomeEdge;
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
}