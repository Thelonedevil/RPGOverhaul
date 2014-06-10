package com.github.thelonedevil.rpgoverhaul.proxy;

import net.minecraft.client.model.ModelBiped;

import com.github.thelonedevil.rpgoverhaul.mobs.Mob1;
import com.github.thelonedevil.rpgoverhaul.mobs.RenderTest;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	public int addArmor(String armor) {
		return RenderingRegistry.addNewArmourRendererPrefix(armor);

	}
	
	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(Mob1.class, new RenderTest(new ModelBiped(), 0.5F));

	}
}