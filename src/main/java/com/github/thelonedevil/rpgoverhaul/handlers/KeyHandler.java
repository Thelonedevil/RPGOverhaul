package com.github.thelonedevil.rpgoverhaul.handlers;

import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import com.github.thelonedevil.rpgoverhaul.RPGOMain;
import com.github.thelonedevil.rpgoverhaul.Ref;
import com.github.thelonedevil.rpgoverhaul.network.OpenGui;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;

public class KeyHandler {

	/** Key index for easy handling */
	public static final int CUSTOM_INV = 0;
	public static final int CRYSTAL_SWAP = 1;

	/** Key descriptions; use a language file to localize the description later */
	private static final String[] desc = { "key.armour_inv.desc", "key.crystal.desc" };
	/** Default key values */
	private static final int[] keyValues = { Keyboard.KEY_I, Keyboard.KEY_C };
	private final KeyBinding[] keys;

	public KeyHandler() {
		keys = new KeyBinding[desc.length];
		for (int i = 0; i < desc.length; ++i) {
			keys[i] = new KeyBinding(desc[i], keyValues[i], "key.rpgo.category");
			ClientRegistry.registerKeyBinding(keys[i]);
		}
	}

	/**
	 * KeyInputEvent is in the FML package, so we must register to the FML event
	 * bus
	 */
	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event) {

		if (!FMLClientHandler.instance().isGUIOpen(GuiChat.class) && FMLClientHandler.instance().getClient().inGameHasFocus) {
			if (keys[CUSTOM_INV].isPressed()) {
				RPGOMain.network.sendToServer(new OpenGui(Ref.Armour_Inventory_GUI));
				System.out.println("Open GUI packet sent to server");
			}else if(keys[CRYSTAL_SWAP].isPressed()){
				RPGOMain.network.sendToServer(new OpenGui(Ref.Armour_Inventory_GUI));
				System.out.println("Open GUI packet sent to server");
			}

		}
	}

}
