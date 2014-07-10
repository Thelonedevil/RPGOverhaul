package com.github.thelonedevil.rpgoverhaul.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.github.thelonedevil.rpgoverhaul.Ref;
import com.github.thelonedevil.rpgoverhaul.blocks.WeaponSmithContainer;
import com.github.thelonedevil.rpgoverhaul.blocks.WeaponSmithGUI;
import com.github.thelonedevil.rpgoverhaul.blocks.alloy_furnace.AlloyContainer;
import com.github.thelonedevil.rpgoverhaul.blocks.alloy_furnace.Alloy_Furnace_GUI;
import com.github.thelonedevil.rpgoverhaul.blocks.alloy_furnace.Alloy_Furnace_TileEntity;
import com.github.thelonedevil.rpgoverhaul.gui.GuiQuestBook;
import com.github.thelonedevil.rpgoverhaul.inventory.ArmourContainer;
import com.github.thelonedevil.rpgoverhaul.inventory.ArmourInventoryGUI;
import com.github.thelonedevil.rpgoverhaul.player.ExtendedPlayer;

import cpw.mods.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Ref.Alloy_furnace_GUI){
			Alloy_Furnace_TileEntity tileEntityFurnace = (Alloy_Furnace_TileEntity) world.getTileEntity(x, y, z);
			return new AlloyContainer(player.inventory, tileEntityFurnace);
		}
		if(ID== Ref.Armour_Inventory_GUI){
			return new ArmourContainer(player, player.inventory, ExtendedPlayer.get(player).customInventory);
		}
		if(ID == Ref.WEAPON_SMITH_GUI){
			return new WeaponSmithContainer(player.inventory, world, x, y, z);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Ref.Alloy_furnace_GUI){
			Alloy_Furnace_TileEntity tileEntityTestContainer = (Alloy_Furnace_TileEntity) world.getTileEntity(x, y, z);
			return new Alloy_Furnace_GUI(player.inventory, tileEntityTestContainer);
		}
		if(ID== Ref.Armour_Inventory_GUI){
			return new ArmourInventoryGUI(player, player.inventory, ExtendedPlayer.get(player).customInventory);
		}
		if(ID == Ref.WEAPON_SMITH_GUI){
			return new WeaponSmithGUI(player.inventory, world, x, y, z);
			
		} if(ID == Ref.QUESTBOOK_GUI){
			return new GuiQuestBook();
		}
		return null;
	}

}
