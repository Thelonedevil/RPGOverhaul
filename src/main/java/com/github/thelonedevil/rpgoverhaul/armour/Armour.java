package com.github.thelonedevil.rpgoverhaul.armour;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import org.lwjgl.input.Keyboard;

import com.github.thelonedevil.rpgoverhaul.Ref;

public class Armour extends Item implements IArmour {
	public int type;

	public Armour(int i) {
		this.type = i;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		// TODO Auto-generated method stub if(player.ticksExisted == 1)
		if (player.ticksExisted == 1) {
			onEquipped(itemstack, player);
		}

	}

	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		if (GuiScreen.isShiftKeyDown()) {
			addStringToTooltip(StatCollector.translateToLocal(Ref.MODID+".armour." + type), par3List);

			KeyBinding key = null;
			KeyBinding[] keys = Minecraft.getMinecraft().gameSettings.keyBindings;
			for (KeyBinding otherKey : keys)
				if (otherKey.getKeyDescription().equals("key.armour_inv.desc")) {
					key = otherKey;
					break;
				}

			if (key != null)
				addStringToTooltip(StatCollector.translateToLocal(Ref.MODID+".armourtooltip").replaceAll("%key%", Keyboard.getKeyName(key.getKeyCode())), par3List);
		} else
			addStringToTooltip(StatCollector.translateToLocal(Ref.MODID+".shiftinfo"), par3List);
	}

	private void addStringToTooltip(String s, List<String> tooltip) {
		tooltip.add(s.replaceAll("&", "\u00a7"));
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		// TODO Auto-generated method stub

	}

}
