package com.github.thelonedevil.rpgoverhaul.blocks.crystals;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.github.thelonedevil.rpgoverhaul.renderer.RenderIds;
import com.github.thelonedevil.rpgoverhaul.tileentities.CrystalClusterTileEntity;

public class CrystalCluster extends Block implements ITileEntityProvider {

	final Item drop;
	public final int type;

	public CrystalCluster(Material material, Item item, int type) {
		super(material);
		drop = item;
		this.type = type;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Item getItemDropped(int metadata, Random random, int fortune) {
		return drop;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new CrystalClusterTileEntity(this.type);
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
		this.setBlockBoundsBasedOnState(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
		return super.getCollisionBoundingBoxFromPool(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
	}

	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB mask, List list, Entity collidingentity) {

		super.addCollisionBoxesToList(world, x, y, z, mask, list, collidingentity);
		super.addCollisionBoxesToList(world, x, y, z, mask, list, collidingentity);

		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);

	}

	@Override
	public int getRenderType() {
		return RenderIds.CrystalCluster;
	}
}
