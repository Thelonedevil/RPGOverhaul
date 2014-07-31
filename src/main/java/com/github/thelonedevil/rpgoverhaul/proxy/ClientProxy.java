package com.github.thelonedevil.rpgoverhaul.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

import com.github.thelonedevil.rpgoverhaul.MyItems;
import com.github.thelonedevil.rpgoverhaul.MyWeapons;
import com.github.thelonedevil.rpgoverhaul.blocks.crystals.MyCrystals;
import com.github.thelonedevil.rpgoverhaul.gui.XpGui;
import com.github.thelonedevil.rpgoverhaul.handlers.BBHandler;
import com.github.thelonedevil.rpgoverhaul.handlers.ClientTickHandler;
import com.github.thelonedevil.rpgoverhaul.handlers.KeyHandler;
import com.github.thelonedevil.rpgoverhaul.mobs.Mob1;
import com.github.thelonedevil.rpgoverhaul.mobs.RenderTest;
import com.github.thelonedevil.rpgoverhaul.mobs.passive.Fox;
import com.github.thelonedevil.rpgoverhaul.mobs.passive.Gazelle;
import com.github.thelonedevil.rpgoverhaul.mobs.passive.Goat;
import com.github.thelonedevil.rpgoverhaul.mobs.passive.RenderFox;
import com.github.thelonedevil.rpgoverhaul.mobs.passive.RenderGazelle;
import com.github.thelonedevil.rpgoverhaul.mobs.passive.RenderGoat;
import com.github.thelonedevil.rpgoverhaul.mobs.passive.modelFox;
import com.github.thelonedevil.rpgoverhaul.mobs.passive.modelGazelle;
import com.github.thelonedevil.rpgoverhaul.mobs.passive.modelGoat;
import com.github.thelonedevil.rpgoverhaul.renderer.RenderIds;
import com.github.thelonedevil.rpgoverhaul.renderer.block.TileEntityCrystalRenderer;
import com.github.thelonedevil.rpgoverhaul.renderer.block.TileEntityPortalRenderer;
import com.github.thelonedevil.rpgoverhaul.renderer.item.BroadSwordRenderer;
import com.github.thelonedevil.rpgoverhaul.renderer.item.CrystalRenderer;
import com.github.thelonedevil.rpgoverhaul.renderer.item.FistRenderer;
import com.github.thelonedevil.rpgoverhaul.renderer.item.ItemCrystalClusterRenderer;
import com.github.thelonedevil.rpgoverhaul.renderer.item.LongSwordRenderer;
import com.github.thelonedevil.rpgoverhaul.renderer.item.RenderQuestBook;
import com.github.thelonedevil.rpgoverhaul.renderer.item.ZangetsuRenderer;
import com.github.thelonedevil.rpgoverhaul.tileentities.CrystalClusterTileEntity;
import com.github.thelonedevil.rpgoverhaul.tileentities.PortalTileEntity;

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
		RenderingRegistry.registerEntityRenderingHandler(Fox.class, new RenderFox (new modelFox(),0.5f));
		RenderingRegistry.registerEntityRenderingHandler(Gazelle.class, new RenderGazelle (new modelGazelle(),0.5f));
		MinecraftForge.EVENT_BUS.register(new XpGui(Minecraft.getMinecraft()));

	}

	public void registerKeys() {
		FMLCommonHandler.instance().bus().register(new KeyHandler());
		FMLCommonHandler.instance().bus().register(new ClientTickHandler());
		MinecraftForge.EVENT_BUS.register(new BBHandler());
	}

	public void registerItemRenderers() {

		RenderIds.CrystalCluster = RenderingRegistry.getNextAvailableRenderId();

		MinecraftForgeClient.registerItemRenderer(MyWeapons.Zangetsu, new ZangetsuRenderer());
		
		MinecraftForgeClient.registerItemRenderer(MyItems.questBook, new RenderQuestBook());
		
		MinecraftForgeClient.registerItemRenderer(MyWeapons.broadSword, new BroadSwordRenderer());
		MinecraftForgeClient.registerItemRenderer(MyWeapons.longSword, new LongSwordRenderer());
		MinecraftForgeClient.registerItemRenderer(MyWeapons.fist, new FistRenderer());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MyCrystals.Fire_Crystal), new ItemCrystalClusterRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MyCrystals.Water_Crystal), new ItemCrystalClusterRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MyCrystals.Air_Crystal), new ItemCrystalClusterRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MyCrystals.Earth_Crystal), new ItemCrystalClusterRenderer());
		MinecraftForgeClient.registerItemRenderer(MyItems.crystal_fire, new CrystalRenderer());
		MinecraftForgeClient.registerItemRenderer(MyItems.crystal_air, new CrystalRenderer());
		MinecraftForgeClient.registerItemRenderer(MyItems.crystal_water, new CrystalRenderer());
		MinecraftForgeClient.registerItemRenderer(MyItems.crystal_earth, new CrystalRenderer());

		ClientRegistry.bindTileEntitySpecialRenderer(CrystalClusterTileEntity.class, new TileEntityCrystalRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(PortalTileEntity.class, new TileEntityPortalRenderer());
	}
}