package com.github.thelonedevil.rpgoverhaul;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;

import com.github.thelonedevil.rpgoverhaul.blocks.crystals.MyCrystals;
import com.github.thelonedevil.rpgoverhaul.handlers.AttackHandler;
import com.github.thelonedevil.rpgoverhaul.handlers.BBHandler;
import com.github.thelonedevil.rpgoverhaul.handlers.CraftingHandler;
import com.github.thelonedevil.rpgoverhaul.handlers.DeathHandler;
import com.github.thelonedevil.rpgoverhaul.handlers.EntityConstructionHandler;
import com.github.thelonedevil.rpgoverhaul.handlers.EntityJoinWorldHandler;
import com.github.thelonedevil.rpgoverhaul.handlers.KeyHandler;
import com.github.thelonedevil.rpgoverhaul.handlers.PlayerConnectHandler;
import com.github.thelonedevil.rpgoverhaul.handlers.PlayerKillHandler;
import com.github.thelonedevil.rpgoverhaul.handlers.PlayerTickHandler;
import com.github.thelonedevil.rpgoverhaul.items.RecipeRemoval;
import com.github.thelonedevil.rpgoverhaul.mobs.Mob1;
import com.github.thelonedevil.rpgoverhaul.network.OpenGui;
import com.github.thelonedevil.rpgoverhaul.network.SyncPlayerProps;
import com.github.thelonedevil.rpgoverhaul.proxy.CommonProxy;
import com.github.thelonedevil.rpgoverhaul.recipes.MyRecipes;
import com.github.thelonedevil.rpgoverhaul.util.LogHelper;
import com.github.thelonedevil.rpgoverhaul.util.Util;
import com.github.thelonedevil.rpgoverhaul.world.CustomGenerator;
import com.github.thelonedevil.rpgoverhaul.world.WorldTypeCustom;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = Ref.MODID, version = Ref.VERSION, name = Ref.NAME)
public class RPGOMain {


	
	@Instance(value = Ref.MODID)
	public static RPGOMain instance;
	public static DeathHandler deathHandler = new DeathHandler();
	public static AttackHandler attackHandler = new AttackHandler();
	public static EntityConstructionHandler entityCHandler = new EntityConstructionHandler();
	public static PlayerConnectHandler connectHandler = new PlayerConnectHandler();
	public static PlayerTickHandler tickHandler = new PlayerTickHandler();
	public static PlayerKillHandler killHandler = new PlayerKillHandler();
	public static EntityJoinWorldHandler entityjoin = new EntityJoinWorldHandler();
	public static CraftingHandler craft = new CraftingHandler();


	public static HashMap<String,BufferedImage> textures;
	public static CreativeTabs myTab = new CreativeTabs("RPG Overhaul") {
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Blocks.dirt);
		}
	};

	@SidedProxy(clientSide = "com.github.thelonedevil.rpgoverhaul.proxy.ClientProxy", serverSide = "com.github.thelonedevil.rpgoverhaul.proxy.CommonProxy")
	public static CommonProxy proxy;

	public static CustomGenerator worldgen = new CustomGenerator();
	public static SimpleNetworkWrapper network;

	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		registerEntity(Mob1.class, "Unknown");
		//File file1 = new File(Ref.modsfolder, "rpgo/textures");
		//textures = Util.getImages(file1);
		MyBlocks.init();
		MyItems.init();
		MyWeapons.init();
		MyCrystals.init();
		MyRecipes.init();
		RecipeRemoval.init();
		network = NetworkRegistry.INSTANCE.newSimpleChannel("RPGO");
		network.registerMessage(SyncPlayerProps.Handler.class, SyncPlayerProps.class, 0, Side.SERVER);
		network.registerMessage(OpenGui.Handler.class, OpenGui.class, 0, Side.SERVER);

		GameRegistry.registerWorldGenerator(worldgen, 9);
		proxy.registerItemRenderers();
		LogHelper.info("Pre Initialization Complete");

	}

	@EventHandler
	public static void load(FMLInitializationEvent event) {
		proxy.registerNetworkStuff();
		MinecraftForge.EVENT_BUS.register(deathHandler);
		MinecraftForge.EVENT_BUS.register(attackHandler);
		MinecraftForge.EVENT_BUS.register(entityCHandler);
		MinecraftForge.EVENT_BUS.register(tickHandler);
		MinecraftForge.EVENT_BUS.register(killHandler);
		MinecraftForge.EVENT_BUS.register(entityjoin);
		
		FMLCommonHandler.instance().bus().register(craft);
		proxy.registerKeys();
		FMLCommonHandler.instance().bus().register(connectHandler);
		proxy.registerTileEntities();
		removeArmourFromChests();
		LogHelper.info("Initialization Complete");

	}

	@EventHandler
	public static void post(FMLPostInitializationEvent event) {
		WorldTypeCustom custom = new WorldTypeCustom();
		LogHelper.info("Post Initialization Complete");

	}

	@SuppressWarnings("unchecked")
	public static void registerEntity(Class entityClass, String name) {
		int entityID = EntityRegistry.findGlobalUniqueEntityId();
		long seed = name.hashCode();
		Random rand = new Random(seed);
		int primaryColor = rand.nextInt() * 16777215;
		int secondaryColor = rand.nextInt() * 16777215;

		EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
		EntityRegistry.registerModEntity(entityClass, name, entityID, instance, 64, 1, true);
		EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, primaryColor, secondaryColor));

		proxy.registerRenderers();
	}

	@SuppressWarnings("unchecked")
	public static void registerEntity(Class entityClass, String name, int primaryColor, int secondaryColor) {
		int entityID = EntityRegistry.findGlobalUniqueEntityId();
		long seed = name.hashCode();
		Random rand = new Random(seed);

		EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
		EntityRegistry.registerModEntity(entityClass, name, entityID, instance, 64, 1, true);
		EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, primaryColor, secondaryColor));

		proxy.registerRenderers();
	}

	private static void removeArmourFromChests() {
		ItemStack ironHat = new ItemStack(Items.iron_helmet, 1, -1);
		ItemStack ironChest = new ItemStack(Items.iron_chestplate, 1, -1);
		ItemStack ironLegs = new ItemStack(Items.iron_leggings, 1, -1);
		ItemStack ironBoots = new ItemStack(Items.iron_boots, 1, -1);
		ItemStack ironSword = new ItemStack(Items.iron_sword, 1, -1);

		ItemStack goldSword = new ItemStack(Items.golden_sword, 1, -1);
		ItemStack goldChest = new ItemStack(Items.golden_chestplate, 1, -1);

		ChestGenHooks.removeItem(ChestGenHooks.VILLAGE_BLACKSMITH, ironHat);
		ChestGenHooks.removeItem(ChestGenHooks.VILLAGE_BLACKSMITH, ironChest);
		ChestGenHooks.removeItem(ChestGenHooks.VILLAGE_BLACKSMITH, ironLegs);
		ChestGenHooks.removeItem(ChestGenHooks.VILLAGE_BLACKSMITH, ironBoots);
		ChestGenHooks.removeItem(ChestGenHooks.VILLAGE_BLACKSMITH, ironSword);

	}
}
