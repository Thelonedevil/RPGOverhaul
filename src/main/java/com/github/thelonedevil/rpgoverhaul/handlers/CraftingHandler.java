package com.github.thelonedevil.rpgoverhaul.handlers;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import com.github.thelonedevil.rpgoverhaul.MyItems;
import com.github.thelonedevil.rpgoverhaul.MyWeapons;
import com.github.thelonedevil.rpgoverhaul.items.AlloyIngot;
import com.github.thelonedevil.rpgoverhaul.items.Hardness;
import com.github.thelonedevil.rpgoverhaul.items.MixedIngot;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class CraftingHandler {
	@SubscribeEvent
	public void onCraft(ItemCraftedEvent event) {
		ItemStack crafted = event.crafting;	
	}
}
