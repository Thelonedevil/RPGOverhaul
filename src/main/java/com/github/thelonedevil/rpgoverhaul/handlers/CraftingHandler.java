package com.github.thelonedevil.rpgoverhaul.handlers;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import com.github.thelonedevil.rpgoverhaul.AlloyIngot;
import com.github.thelonedevil.rpgoverhaul.Hardness;
import com.github.thelonedevil.rpgoverhaul.MixedIngot;
import com.github.thelonedevil.rpgoverhaul.MyItems;
import com.github.thelonedevil.rpgoverhaul.MyWeapons;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class CraftingHandler {
	@SubscribeEvent
	public void onCraft(ItemCraftedEvent event) {
		ItemStack crafted = event.crafting;	
	}
}
