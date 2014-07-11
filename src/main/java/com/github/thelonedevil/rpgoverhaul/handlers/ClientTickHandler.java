package com.github.thelonedevil.rpgoverhaul.handlers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;

import com.github.thelonedevil.rpgoverhaul.gui.GuiQuestBook;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;

public class ClientTickHandler {

	public static int ticksWithLexicaOpen = 0;
	public static int pageFlipTicks = 0;
	public static int ticksInGame = 0;
	public static int pageFlipTicks1 = 0;

	@SubscribeEvent
	public void tickEnd(ClientTickEvent event) {

		GuiScreen gui = Minecraft.getMinecraft().currentScreen;
		if (gui == null || !gui.doesGuiPauseGame()) {
			ticksInGame++;

			EntityPlayer player = Minecraft.getMinecraft().thePlayer;

			int ticksToOpen = 10;
			if (gui instanceof GuiQuestBook) {
				if (ticksWithLexicaOpen < 0)
					ticksWithLexicaOpen = 0;
				if (ticksWithLexicaOpen < ticksToOpen)
					ticksWithLexicaOpen++;
				if (pageFlipTicks > 0)
					pageFlipTicks--;
			} else {
				pageFlipTicks = 0;
				if (ticksWithLexicaOpen > 0) {
					if (ticksWithLexicaOpen > ticksToOpen)
						ticksWithLexicaOpen = ticksToOpen;
					ticksWithLexicaOpen--;
				}
			}
		} else {
			pageFlipTicks1++;
			if (pageFlipTicks1 == 20)
				pageFlipTicks1 = 0;

		}
	}

	public static void notifyPageChange() {
		if (pageFlipTicks == 0)
			pageFlipTicks = 5;
	}

}