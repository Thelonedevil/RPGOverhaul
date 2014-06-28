package com.github.thelonedevil.rpgoverhaul.handlers;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import com.github.thelonedevil.rpgoverhaul.AlloyIngot;
import com.github.thelonedevil.rpgoverhaul.MixedIngot;
import com.github.thelonedevil.rpgoverhaul.MyItems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class CraftingHandler {
	@SubscribeEvent
	public void onCraft(ItemCraftedEvent event) {
		ItemStack crafted = event.crafting;

		if (crafted.getItem().equals(MyItems.mixedIngot)) {
			ItemStack slot1 = null;
			ItemStack slot2 = null;
			for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
				if (slot1 == null &&  event.craftMatrix.getStackInSlot(i) != null) {
					slot1 = event.craftMatrix.getStackInSlot(i);
				} else if (slot2 == null &&  event.craftMatrix.getStackInSlot(i) != null) {
					slot2 = event.craftMatrix.getStackInSlot(i);
				}
			}
			if (slot1 != null && slot2 != null) {
				if (!slot1.getItem().equals(slot2.getItem())) {
					NBTTagCompound tag = new NBTTagCompound();
					tag.setString("metal1", slot1.getItem().getUnlocalizedName().substring(11));
					tag.setString("metal2", slot2.getItem().getUnlocalizedName().substring(11));
					MixedIngot mi = (MixedIngot) event.crafting.getItem();
					mi.crafted = true;
					event.crafting.setTagCompound(tag);
				}
			}
		}
		if(crafted.getItem().equals(MyItems.alloyIngot)){
			ItemStack slot = null;
			for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
				if(slot == null &&  event.craftMatrix.getStackInSlot(i) != null &&event.craftMatrix.getStackInSlot(i).getItem().equals(MyItems.mixedIngot)){
					slot = event.craftMatrix.getStackInSlot(i);
				}
			}
			if(slot != null){
				NBTTagCompound tag = new NBTTagCompound();
				tag.setString("metal1", slot.getTagCompound().getString("metal1"));
				tag.setString("metal2", slot.getTagCompound().getString("metal2"));
				AlloyIngot ai = (AlloyIngot) event.crafting.getItem();
				ai.crafted = true;
				event.crafting.setTagCompound(tag);
			}
		}
	}
}
