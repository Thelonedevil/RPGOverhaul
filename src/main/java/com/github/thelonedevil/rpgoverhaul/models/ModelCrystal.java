package com.github.thelonedevil.rpgoverhaul.models;

import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ModelCrystal {
	private static IModelCustom model;

	public ModelCrystal() {
		model = AdvancedModelLoader.loadModel(Models.CRYSTAL);
	}

	public static void render() {
		model.renderAll();
	}
}
