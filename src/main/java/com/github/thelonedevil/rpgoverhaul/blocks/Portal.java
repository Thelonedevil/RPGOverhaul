package com.github.thelonedevil.rpgoverhaul.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.github.thelonedevil.rpgoverhaul.tileentities.PortalTileEntity;

public class Portal extends Block implements ITileEntityProvider{

	protected Portal() {
		super(Material.anvil);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new PortalTileEntity();
	}

}
