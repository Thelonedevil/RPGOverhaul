package com.github.thelonedevil.rpgoverhaul;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Random;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;

import com.github.thelonedevil.rpgoverhaul.blocks.crystals.MyCrystals;
import com.github.thelonedevil.rpgoverhaul.handlers.AttackHandler;
import com.github.thelonedevil.rpgoverhaul.handlers.CraftingHandler;
import com.github.thelonedevil.rpgoverhaul.handlers.DeathHandler;
import com.github.thelonedevil.rpgoverhaul.handlers.EntityConstructionHandler;
import com.github.thelonedevil.rpgoverhaul.handlers.EntityJoinWorldHandler;
import com.github.thelonedevil.rpgoverhaul.handlers.PlayerConnectHandler;
import com.github.thelonedevil.rpgoverhaul.handlers.PlayerKillHandler;
import com.github.thelonedevil.rpgoverhaul.handlers.PlayerTickHandler;
import com.github.thelonedevil.rpgoverhaul.mobs.Mob1;
import com.github.thelonedevil.rpgoverhaul.mobs.passive.Fox;
import com.github.thelonedevil.rpgoverhaul.mobs.passive.Gazelle;
import com.github.thelonedevil.rpgoverhaul.mobs.passive.Goat;
import com.github.thelonedevil.rpgoverhaul.network.OpenGui;
import com.github.thelonedevil.rpgoverhaul.network.SyncPlayerProps;
import com.github.thelonedevil.rpgoverhaul.network.UpdateXpPacket;
import com.github.thelonedevil.rpgoverhaul.proxy.CommonProxy;
import com.github.thelonedevil.rpgoverhaul.quests.QuestBookData;
import com.github.thelonedevil.rpgoverhaul.recipes.MyRecipes;
import com.github.thelonedevil.rpgoverhaul.recipes.RecipeRemoval;
import com.github.thelonedevil.rpgoverhaul.util.LogHelper;
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

	public static HashMap<String, BufferedImage> textures;
	public static CreativeTabs myTab = new CreativeTabs("rpgo") {
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Blocks.dirt);
		}
	};
	public static CreativeTabs MetalTab = new CreativeTabs("rpgo.metals") {
		public Item getTabIconItem() {
			return MyMetals.ingot_ketsuekium;
		}
	};
	public static CreativeTabs WeaponTab = new CreativeTabs("rpgo.weapons") {
		public Item getTabIconItem() {
			return Items.diamond_sword;
		}
	};

	@SidedProxy(clientSide = "com.github.thelonedevil.rpgoverhaul.proxy.ClientProxy", serverSide = "com.github.thelonedevil.rpgoverhaul.proxy.CommonProxy")
	public static CommonProxy proxy;

	public static CustomGenerator worldgen = new CustomGenerator();
	public static SimpleNetworkWrapper network;

	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		registerEntity(Mob1.class, "Unknown");
		registerEntity(Goat.class, "Goat",0x3f201d,0x707070);
		registerEntity(Fox.class, "Fox",0xcfc6a4,0x7b6e41);
		registerEntity(Gazelle.class, "Gazelle",0xcfc6a4,0x333333);
		EntityRegistry.addSpawn(Goat.class, 100, 1, 20, EnumCreatureType.creature, BiomeGenBase.savanna);
		EntityRegistry.addSpawn(Goat.class, 100, 1, 20, EnumCreatureType.creature, BiomeGenBase.savannaPlateau);
		EntityRegistry.addSpawn(Fox.class, 200,2, 8,  EnumCreatureType.creature, BiomeGenBase.desert);
		EntityRegistry.addSpawn(Fox.class, 200,2, 8,  EnumCreatureType.creature, BiomeGenBase.desertHills);
		EntityRegistry.addSpawn(Gazelle.class, 100, 1, 20, EnumCreatureType.creature, BiomeGenBase.savanna);
		EntityRegistry.addSpawn(Gazelle.class, 100, 1, 20, EnumCreatureType.creature, BiomeGenBase.savannaPlateau);
		EntityRegistry.addSpawn(Gazelle.class, 100,1, 20,  EnumCreatureType.creature, BiomeGenBase.desert);
		EntityRegistry.addSpawn(Gazelle.class, 100,1, 20,  EnumCreatureType.creature, BiomeGenBase.desertHills);
		// File file1 = new File(Ref.modsfolder, "rpgo/textures");
		// textures = Util.getImages(file1);
		MyBlocks.init();
		MyItems.init();
		MyClothes.init();
		MyWeapons.init();
		MyCrystals.init();
		MyMetals.init();


		network = NetworkRegistry.INSTANCE.newSimpleChannel("RPGO");
		network.registerMessage(SyncPlayerProps.Handler.class, SyncPlayerProps.class, 0, Side.SERVER);
		network.registerMessage(OpenGui.Handler.class, OpenGui.class, 0, Side.SERVER);
		//network.registerMessage(UpdateXpPacket.Handler.class, UpdateXpPacket.class, 0, Side.CLIENT);
		QuestBookData.init();
		GameRegistry.registerWorldGenerator(worldgen, 9);
		proxy.registerItemRenderers();
		LogHelper.info("Pre Initialization Complete");

	}

	@EventHandler
	public static void load(FMLInitializationEvent event) {
		MyRecipes.init();
		proxy.registerNetworkStuff();
		MinecraftForge.EVENT_BUS.register(deathHandler);
		FMLCommonHandler.instance().bus().register(deathHandler);
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
		RecipeRemoval.init();
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
