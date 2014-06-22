package com.github.thelonedevil.rpgoverhaul.proxy;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.nbt.NBTTagCompound;

import com.github.thelonedevil.rpgoverhaul.RPGOMain;
import com.github.thelonedevil.rpgoverhaul.blocks.alloy_furnace.Alloy_Furnace_TileEntity;
import com.github.thelonedevil.rpgoverhaul.blocks.crystals.CrystalClusterTileEntity;
import com.github.thelonedevil.rpgoverhaul.handlers.GUIHandler;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {

	private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();

	public void registerRenderers() {
		// Nothing here as the server doesn't render graphics or entities!
	}

	public int addArmor(String string) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void registerTileEntities() {
		GameRegistry.registerTileEntity(Alloy_Furnace_TileEntity.class, "Alloy_Furnace_TileEntity");
		GameRegistry.registerTileEntity(CrystalClusterTileEntity.class, "CrystalClusterTileEntity");
	}

	public void registerNetworkStuff() {
		NetworkRegistry.INSTANCE.registerGuiHandler(RPGOMain.instance, new GUIHandler());
	}

	public void registerItemRenderers() {

	}

	public static void storeEntityData(String name, NBTTagCompound compound) {
		extendedEntityData.put(name, compound);
	}

	public static NBTTagCompound getEntityData(String name) {
		return extendedEntityData.remove(name);
	}

}