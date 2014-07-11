package com.github.thelonedevil.rpgoverhaul.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import com.github.thelonedevil.rpgoverhaul.player.ExtendedPlayer;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class XpGui extends Gui {
	private Minecraft mc;

	public XpGui(Minecraft mc) {
		super();
		// We need this to invoke the render engine.
		this.mc = mc;
	}

	//
	// This event is called by GuiIngameForge during each frame by
	// GuiIngameForge.pre() and GuiIngameForce.post().
	//
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRender(RenderGameOverlayEvent event) {
		ExtendedPlayer props = ExtendedPlayer.get(this.mc.thePlayer);
		int xPos = 10;
		int yPos = 10;
		mc.fontRenderer.drawString("Level: " + props.getLevel(), xPos, yPos, 4210752);
		mc.fontRenderer.drawString("XP: " + props.getXp(), xPos, yPos + 10, 4210752);

	}
}
