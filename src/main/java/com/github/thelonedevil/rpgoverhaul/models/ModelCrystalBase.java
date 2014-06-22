package com.github.thelonedevil.rpgoverhaul.models;

import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ModelCrystalBase {
	private static IModelCustom model;

    public ModelCrystalBase()
    {
        model = AdvancedModelLoader.loadModel(Models.CRYSTALBASE);
    }

	public static void render() {
		 model.renderAll();
	}
}
