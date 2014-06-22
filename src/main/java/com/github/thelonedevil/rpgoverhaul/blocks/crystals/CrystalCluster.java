package com.github.thelonedevil.rpgoverhaul.blocks.crystals;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.github.thelonedevil.rpgoverhaul.renderer.RenderIds;

public class CrystalCluster extends Block implements ITileEntityProvider{
	
	Item drop;
	public static int type;

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
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    @Override
    public int getRenderType()
    {
        return RenderIds.CrystalCluster;
    }
}
