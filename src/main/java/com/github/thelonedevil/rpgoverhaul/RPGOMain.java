package com.github.thelonedevil.rpgoverhaul;

import java.util.Random;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

import com.github.thelonedevil.rpgoverhaul.blocks.crystals.MyCrystals;
import com.github.thelonedevil.rpgoverhaul.handlers.AttackHandler;
import com.github.thelonedevil.rpgoverhaul.handlers.DeathHandler;
import com.github.thelonedevil.rpgoverhaul.handlers.EntityConstructionHandler;
import com.github.thelonedevil.rpgoverhaul.handlers.KeyHandler;
import com.github.thelonedevil.rpgoverhaul.handlers.PlayerConnectHandler;
import com.github.thelonedevil.rpgoverhaul.handlers.PlayerTickHandler;
import com.github.thelonedevil.rpgoverhaul.mobs.Mob1;
import com.github.thelonedevil.rpgoverhaul.network.OpenGui;
import com.github.thelonedevil.rpgoverhaul.network.SyncPlayerProps;
import com.github.thelonedevil.rpgoverhaul.proxy.CommonProxy;
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

@Mod(modid = RPGOMain.MODID, version = RPGOMain.VERSION, name = RPGOMain.NAME)
public class RPGOMain {

	public static final String MODID = "rpgo";
	public static final String VERSION = "1.0";
	public static final String NAME = "RPG Overhaul";
	@Instance(value = "rpgo")
	public static RPGOMain instance;
	public static DeathHandler deathHandler = new DeathHandler();
	public static AttackHandler attackHandler = new AttackHandler();
	public static KeyHandler keyHandler = new KeyHandler();
	public static EntityConstructionHandler entityCHandler = new EntityConstructionHandler();
	public static PlayerConnectHandler connectHandler = new PlayerConnectHandler();
	public static PlayerTickHandler tickHandler =new PlayerTickHandler();
	public static final int Alloy_furnace_GUI = 0;
	public static final int Armour_Inventory_GUI = 1;
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
		MyBlocks.init();
		MyItems.init();
		MyRecipes.init();
		MyCrystals.init();
		ItemRemoval.init();
		network = NetworkRegistry.INSTANCE.newSimpleChannel("RPGO");
	    network.registerMessage(SyncPlayerProps.Handler.class, SyncPlayerProps.class, 0, Side.SERVER);
		network.registerMessage(OpenGui.Handler.class, OpenGui.class, 0, Side.SERVER);

		GameRegistry.registerWorldGenerator(worldgen, 9);
		proxy.registerItemRenderers();

	}

	@EventHandler
	public static void load(FMLInitializationEvent event) {
		proxy.registerNetworkStuff();
		MinecraftForge.EVENT_BUS.register(deathHandler);
		MinecraftForge.EVENT_BUS.register(attackHandler);
		MinecraftForge.EVENT_BUS.register(entityCHandler);
		MinecraftForge.EVENT_BUS.register(tickHandler);
		FMLCommonHandler.instance().bus().register(keyHandler);
		FMLCommonHandler.instance().bus().register(connectHandler);
		proxy.registerTileEntities();

	}

	@EventHandler
	public static void post(FMLPostInitializationEvent event) {
		WorldTypeCustom custom = new WorldTypeCustom();
		
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

}
