package com.github.thelonedevil.rpgoverhaul.tileentities;

import net.minecraft.tileentity.TileEntity;

public class CrystalClusterTileEntity extends TileEntity {

	public int Type;

	public CrystalClusterTileEntity() {
		this.Type = 0;
	}

	public CrystalClusterTileEntity(int type) {
		this.Type = type;
	}

}
