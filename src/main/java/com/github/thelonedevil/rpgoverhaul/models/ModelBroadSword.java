package com.github.thelonedevil.rpgoverhaul.models;

import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelBroadSword {
	private static IModelCustom model;

	public ModelBroadSword() {
		model = AdvancedModelLoader.loadModel(Models.BROADSWORD);
	}

	public static void render() {
		model.renderAll();
	}

}
