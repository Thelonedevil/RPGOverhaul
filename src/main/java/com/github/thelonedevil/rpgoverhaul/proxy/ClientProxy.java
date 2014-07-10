package com.github.thelonedevil.rpgoverhaul.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

import com.github.thelonedevil.rpgoverhaul.MyItems;
import com.github.thelonedevil.rpgoverhaul.blocks.crystals.CrystalClusterTileEntity;
import com.github.thelonedevil.rpgoverhaul.blocks.crystals.MyCrystals;
import com.github.thelonedevil.rpgoverhaul.gui.XpGui;
import com.github.thelonedevil.rpgoverhaul.handlers.BBHandler;
import com.github.thelonedevil.rpgoverhaul.handlers.ClientTickHandler;
import com.github.thelonedevil.rpgoverhaul.handlers.KeyHandler;
import com.github.thelonedevil.rpgoverhaul.mobs.Mob1;
import com.github.thelonedevil.rpgoverhaul.mobs.RenderTest;
import com.github.thelonedevil.rpgoverhaul.mobs.passive.Goat;
import com.github.thelonedevil.rpgoverhaul.mobs.passive.RenderGoat;
import com.github.thelonedevil.rpgoverhaul.mobs.passive.modelGoat;
import com.github.thelonedevil.rpgoverhaul.renderer.RenderIds;
import com.github.thelonedevil.rpgoverhaul.renderer.Sword1Renderer;
import com.github.thelonedevil.rpgoverhaul.renderer.Sword2Renderer;
import com.github.thelonedevil.rpgoverhaul.renderer.block.TileEntityCrystalRenderer;
import com.github.thelonedevil.rpgoverhaul.renderer.item.ItemCrystalClusterRenderer;
import com.github.thelonedevil.rpgoverhaul.renderer.item.RenderQuestBook;
import com.github.thelonedevil.rpgoverhaul.renderer.item.ZangetsuRenderer;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy {

	public int addArmor(String armor) {
		return RenderingRegistry.addNewArmourRendererPrefix(armor);

	}
	
	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(Mob1.class, new RenderTest(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(Goat.class, new RenderGoat(new modelGoat(12, 0), 0.5F));
		MinecraftForge.EVENT_BUS.register(new XpGui(Minecraft.getMinecraft()));


	}
	
	public void registerKeys(){
		FMLCommonHandler.instance().bus().register(new KeyHandler());
		FMLCommonHandler.instance().bus().register(new ClientTickHandler());
		MinecraftForge.EVENT_BUS.register(new BBHandler());
	}
	
	public void registerItemRenderers(){
		
		RenderIds.CrystalCluster = RenderingRegistry.getNextAvailableRenderId();
		
		MinecraftForgeClient.registerItemRenderer(MyItems.Zangetsu, new ZangetsuRenderer());
		MinecraftForgeClient.registerItemRenderer(MyItems.Sword1, new Sword1Renderer());
		MinecraftForgeClient.registerItemRenderer(MyItems.Sword2, new Sword2Renderer());
		
		MinecraftForgeClient.registerItemRenderer(MyItems.questBook, new RenderQuestBook());
		
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MyCrystals.Fire_Crystal), new ItemCrystalClusterRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MyCrystals.Water_Crystal), new ItemCrystalClusterRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MyCrystals.Air_Crystal), new ItemCrystalClusterRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MyCrystals.Earth_Crystal), new ItemCrystalClusterRenderer());
		
		ClientRegistry.bindTileEntitySpecialRenderer(CrystalClusterTileEntity.class, new TileEntityCrystalRenderer());
	}
}