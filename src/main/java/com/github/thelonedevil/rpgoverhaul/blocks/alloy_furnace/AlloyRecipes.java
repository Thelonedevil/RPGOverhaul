package com.github.thelonedevil.rpgoverhaul.blocks.alloy_furnace;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.github.thelonedevil.rpgoverhaul.MyBlocks;
import com.github.thelonedevil.rpgoverhaul.MyItems;

public class AlloyRecipes {

	private static final AlloyRecipes SMELTING_BASE = new AlloyRecipes();

	private Map<ItemStack[], ItemStack> smeltingList = new HashMap<ItemStack[], ItemStack>();
	private Map<ItemStack, Float> experienceList = new HashMap<ItemStack, Float>();

	public static AlloyRecipes smelting() {
		return SMELTING_BASE;
	}

	private AlloyRecipes() {
		//this.addRecipe(Item.getItemFromBlock(MyBlocks.ore_asunalt), Item.getItemFromBlock(MyBlocks.ore_kiritorium), new ItemStack(MyItems.ingot_asunalt), 0.8F);
	}

	public void addRecipe(Item item, Item item2, ItemStack itemstack, float experience) {
		this.addLists(item, item2, itemstack, experience);
	}

	public void addLists(Item item, Item item2, ItemStack itemstack, float experience) {
		this.putLists(new ItemStack(item, 1, 32767), new ItemStack(item2, 1, 32767), itemstack, experience);
	}

	public void putLists(ItemStack itemstack, ItemStack itemstack2, ItemStack itemstack3, float experience) {
		this.smeltingList.put(new ItemStack[] { itemstack, itemstack2 }, itemstack3);
		this.experienceList.put(itemstack3, Float.valueOf(experience));
	}

	public ItemStack getSmeltingResult(ItemStack itemstack, ItemStack itemstack2) {
		Iterator<Entry<ItemStack[], ItemStack>> iterator = this.smeltingList.entrySet().iterator();
		Entry<ItemStack[], ItemStack> entry;

		do {
			if (!iterator.hasNext()) {
				return null;
			}
			entry = (Entry<ItemStack[], ItemStack>) iterator.next();
		} while (!canBeSmelted(new ItemStack[] { itemstack, itemstack2 }, (ItemStack[]) entry.getKey()));
		return (ItemStack) entry.getValue();
	}

	private boolean canBeSmelted(ItemStack[] itemstack, ItemStack[] itemstack2) {
		if (itemstack[0] != null && itemstack[1] != null) {
			if (itemstack[0].isItemEqual(itemstack2[0]) && itemstack[1].isItemEqual(itemstack2[1])) {
				return true;
			} else if (itemstack[1].isItemEqual(itemstack2[0]) && itemstack[0].isItemEqual(itemstack2[1])) {
				return true;
			} else {
				return false;
			}
		} else
			return false;
	}

	private boolean isSmeltingResult(ItemStack itemstack, ItemStack itemstack2) {
		if (itemstack.isItemEqual(itemstack2)) {
			return true;
		} else {
			return false;
		}
	}

	public float giveExperience(ItemStack itemstack) {
		Iterator<Entry<ItemStack, Float>> iterator = this.experienceList.entrySet().iterator();
		Entry<ItemStack, Float> entry;

		do {
			if (!iterator.hasNext()) {
				return 0.0f;
			}

			entry = (Entry<ItemStack, Float>) iterator.next();
		} while (!this.isSmeltingResult(itemstack, (ItemStack) entry.getKey()));

		if (itemstack.getItem().getSmeltingExperience(itemstack) != -1) {
			return itemstack.getItem().getSmeltingExperience(itemstack);
		}

		return ((Float) entry.getValue()).floatValue();
	}

	public boolean isAlloyIngredient(ItemStack itemstack1) {
		boolean i = false;
		for (ItemStack[] key : smeltingList.keySet()) {
			if (key[0].isItemEqual(itemstack1) || key[1].isItemEqual(itemstack1)) {
				i = true;
				return i;
			} else
				i = false;

		}
		return i;
	}
}
