package com.github.thelonedevil.rpgoverhaul.proxy;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.github.thelonedevil.rpgoverhaul.MyItems;
import com.github.thelonedevil.rpgoverhaul.blocks.crystals.CrystalClusterTileEntity;
import com.github.thelonedevil.rpgoverhaul.blocks.crystals.MyCrystals;
import com.github.thelonedevil.rpgoverhaul.mobs.Mob1;
import com.github.thelonedevil.rpgoverhaul.mobs.RenderTest;
import com.github.thelonedevil.rpgoverhaul.renderer.RenderIds;
import com.github.thelonedevil.rpgoverhaul.renderer.Sword1Renderer;
import com.github.thelonedevil.rpgoverhaul.renderer.Sword2Renderer;
import com.github.thelonedevil.rpgoverhaul.renderer.block.TileEntityCrystalRenderer;
import com.github.thelonedevil.rpgoverhaul.renderer.item.ItemCrystalClusterRenderer;
import com.github.thelonedevil.rpgoverhaul.renderer.item.ZangetsuRenderer;

import cpw.mods.fml.client.registry.ClientRegistry;
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
		
		RenderIds.CrystalCluster = RenderingRegistry.getNextAvailableRenderId();
		
		MinecraftForgeClient.registerItemRenderer(MyItems.Zangetsu, new ZangetsuRenderer());
		MinecraftForgeClient.registerItemRenderer(MyItems.Sword1, new Sword1Renderer());
		MinecraftForgeClient.registerItemRenderer(MyItems.Sword2, new Sword2Renderer());
		
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MyCrystals.Fire_Crystal), new ItemCrystalClusterRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MyCrystals.Water_Crystal), new ItemCrystalClusterRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MyCrystals.Air_Crystal), new ItemCrystalClusterRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MyCrystals.Earth_Crystal), new ItemCrystalClusterRenderer());
		
		ClientRegistry.bindTileEntitySpecialRenderer(CrystalClusterTileEntity.class, new TileEntityCrystalRenderer());
	}
}