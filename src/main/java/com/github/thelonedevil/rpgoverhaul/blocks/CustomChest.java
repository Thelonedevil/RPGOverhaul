package com.github.thelonedevil.rpgoverhaul.blocks;

import java.util.Random;

import net.minecraft.block.BlockChest;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.github.thelonedevil.rpgoverhaul.RPGOMain;
import com.github.thelonedevil.rpgoverhaul.tileentities.CustomChestTileEntity;

public class CustomChest extends BlockChest {

	private int age = 0;
	private int lifespan = 1;

	public CustomChest(int p_i45397_1_) {
		super(p_i45397_1_);
		this.setCreativeTab(RPGOMain.myTab);
		this.setTickRandomly(true);
	}

	private void remove(World world, int x, int y, int z) {
		world.setBlockToAir(x, y, z);

	}

	public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
		age++;
		if (age >= lifespan) {
			remove(p_149674_1_, p_149674_4_, p_149674_4_, p_149674_4_);
		}
	}

	public int tickRate(World world) {
		return 1;
	}


}
