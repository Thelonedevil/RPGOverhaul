package com.github.thelonedevil.rpgoverhaul.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.github.thelonedevil.rpgoverhaul.blocks.alloy_furnace.AlloyContainer;
import com.github.thelonedevil.rpgoverhaul.blocks.alloy_furnace.Alloy_Furnace_GUI;
import com.github.thelonedevil.rpgoverhaul.blocks.alloy_furnace.Alloy_Furnace_TileEntity;

import cpw.mods.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == 0){
			Alloy_Furnace_TileEntity tileEntityFurnace = (Alloy_Furnace_TileEntity) world.getTileEntity(x, y, z);
			return new AlloyContainer(player.inventory, tileEntityFurnace);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == 0){
			Alloy_Furnace_TileEntity tileEntityTestContainer = (Alloy_Furnace_TileEntity) world.getTileEntity(x, y, z);
			return new Alloy_Furnace_GUI(player.inventory, tileEntityTestContainer);
		}
		return null;
	}

}
