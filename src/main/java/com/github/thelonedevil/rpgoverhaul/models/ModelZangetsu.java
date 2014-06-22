package com.github.thelonedevil.rpgoverhaul.models;

import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelZangetsu
{
    private static IModelCustom model;

    public ModelZangetsu()
    {
        model = AdvancedModelLoader.loadModel(Models.ZANGETSU);
    }

	public static void render() {
		 model.renderAll();
	}

}
