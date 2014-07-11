package com.github.thelonedevil.rpgoverhaul.handlers;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import com.github.thelonedevil.rpgoverhaul.MyBlocks;
import com.github.thelonedevil.rpgoverhaul.MyItems;
import com.github.thelonedevil.rpgoverhaul.util.LogHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class CraftingHandler {
	@SubscribeEvent
	public void onCraft(ItemCraftedEvent event) {
		ItemStack crafted = event.crafting;
		if (crafted.getItem() == MyItems.questBook) {
			NBTTagCompound tag = new NBTTagCompound();
			tag.setString("player", event.player.getCommandSenderName());
			LogHelper.info(event.player.getCommandSenderName() + " crafted a quest book");
			crafted.setTagCompound(tag);
			if (crafted.getTagCompound() != null) {
				LogHelper.info("player stored correctly");
			}
		}
		if (crafted.getItem() == Item.getItemFromBlock(MyBlocks.portal)) {

		}
	}
}
