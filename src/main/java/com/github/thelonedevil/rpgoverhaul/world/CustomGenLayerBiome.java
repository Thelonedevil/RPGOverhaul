package com.github.thelonedevil.rpgoverhaul.world;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.WeightedRandom;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;

public class CustomGenLayerBiome extends GenLayer {
	private List<BiomeEntry> desertBiomes = new ArrayList<BiomeEntry>();
	protected static final BiomeGenBase.Height height_Oceans = new BiomeGenBase.Height(-2.0F, 0.1F);

	public CustomGenLayerBiome(long par1, GenLayer par3GenLayer, WorldType par4WorldType) {
		super(par1);

		this.parent = par3GenLayer;

		this.desertBiomes.addAll(BiomeManager.desertBiomes);

		desertBiomes.add(new BiomeEntry(BiomeGenBase.desert, 30));
		desertBiomes.add(new BiomeEntry(BiomeGenBase.savanna, 20));
		desertBiomes.add(new BiomeEntry(BiomeGenBase.mesa, 50));

	}

	/**
	 * Returns a list of integer values generated by this layer. These may be
	 * interpreted as temperatures, rainfall amounts, or biomeList[] indices
	 * based on the particular GenLayer subclass.
	 */
	public int[] getInts(int par1, int par2, int par3, int par4) {
		int[] aint = this.parent.getInts(par1, par2, par3, par4);
		int[] aint1 = IntCache.getIntCache(par3 * par4);

		for (int i1 = 0; i1 < par4; ++i1) {
			for (int j1 = 0; j1 < par3; ++j1) {
				this.initChunkSeed((long) (j1 + par1), (long) (i1 + par2));
				int k1 = aint[j1 + i1 * par3];
				int l1 = (k1 & 3840) >> 8;
				k1 &= -3841;

				if (isBiomeOceanic(k1)) {
					aint1[j1 + i1 * par3] = k1;
				} else if (k1 == BiomeGenBase.mesa.biomeID) {
					aint1[j1 + i1 * par3] = k1;
				} else if (k1 == 1) {
					if (l1 > 0) {
						if (this.nextInt(3) == 0) {
							aint1[j1 + i1 * par3] = BiomeGenBase.mesaPlateau.biomeID;
						} else {
							aint1[j1 + i1 * par3] = BiomeGenBase.mesaPlateau_F.biomeID;
						}
					} else {
						aint1[j1 + i1 * par3] = ((BiomeEntry) WeightedRandom.getItem(this.desertBiomes, (int) (this.nextLong(WeightedRandom.getTotalWeight(this.desertBiomes) / 10) * 10))).biome.biomeID;
					}
				} else if (k1 == 2) {
					if (l1 > 0) {
						aint1[j1 + i1 * par3] = BiomeGenBase.mesa.biomeID;
					} else {
						aint1[j1 + i1 * par3] = ((BiomeEntry) WeightedRandom.getItem(this.desertBiomes, (int) (this.nextLong(WeightedRandom.getTotalWeight(this.desertBiomes) / 10) * 10))).biome.biomeID;
					}
				} else if (k1 == 3) {
					if (l1 > 0) {
						aint1[j1 + i1 * par3] = BiomeGenBase.mesa.biomeID;
					} else {
						aint1[j1 + i1 * par3] = ((BiomeEntry) WeightedRandom.getItem(this.desertBiomes, (int) (this.nextLong(WeightedRandom.getTotalWeight(this.desertBiomes) / 10) * 10))).biome.biomeID;
					}
				} else if (k1 == 4) {
					aint1[j1 + i1 * par3] = ((BiomeEntry) WeightedRandom.getItem(this.desertBiomes, (int) (this.nextLong(WeightedRandom.getTotalWeight(this.desertBiomes) / 10) * 10))).biome.biomeID;
				} else {
					aint1[j1 + i1 * par3] = BiomeGenBase.mesa.biomeID;
				}
			}
		}

		return aint1;
	}

}