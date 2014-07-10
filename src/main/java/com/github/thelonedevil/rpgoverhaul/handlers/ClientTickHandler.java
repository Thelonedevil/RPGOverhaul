package com.github.thelonedevil.rpgoverhaul.handlers;

import java.util.ArrayList;
import java.util.List;

import com.github.thelonedevil.rpgoverhaul.gui.GuiQuestBook;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.Type;

public class ClientTickHandler {

	public static int ticksWithLexicaOpen = 0;
	public static int pageFlipTicks = 0;
	public static int ticksInGame = 0;

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
		}
	}

	public static void notifyPageChange() {
		if (pageFlipTicks == 0)
			pageFlipTicks = 5;
	}

}