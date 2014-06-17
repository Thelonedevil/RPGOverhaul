package com.github.thelonedevil.rpgoverhaul.proxy;

import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.client.MinecraftForgeClient;

import com.github.thelonedevil.rpgoverhaul.MyItems;
import com.github.thelonedevil.rpgoverhaul.mobs.Mob1;
import com.github.thelonedevil.rpgoverhaul.mobs.RenderTest;
import com.github.thelonedevil.rpgoverhaul.render.Sword1Renderer;
import com.github.thelonedevil.rpgoverhaul.render.Sword2Renderer;
import com.github.thelonedevil.rpgoverhaul.render.SwordRenderer;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	public int addArmor(String armor) {
		return RenderingRegistry.addNewArmourRendererPrefix(armor);

	}
	
	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(Mob1.class, new RenderTest(new ModelBiped(), 0.5F));

	}
	
	public void registerItemRenderers(){
		MinecraftForgeClient.registerItemRenderer(MyItems.Zangetsu, new SwordRenderer());
		MinecraftForgeClient.registerItemRenderer(MyItems.Sword1, new Sword1Renderer());
		MinecraftForgeClient.registerItemRenderer(MyItems.Sword2, new Sword2Renderer());
	}
}