package com.github.thelonedevil.rpgoverhaul.items;

import java.util.Iterator;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

public class RecipeRemoval {

	public static void init() {
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();

		Iterator<IRecipe> recipe = recipes.iterator();

		while (recipe.hasNext()) {
			ItemStack is = recipe.next().getRecipeOutput();
			if (is != null && is.getItem() == Items.diamond_boots
					|| is.getItem() == Items.diamond_chestplate
					|| is.getItem() == Items.diamond_leggings
					|| is.getItem() == Items.diamond_helmet
					|| is.getItem() == Items.leather_boots
					|| is.getItem() == Items.leather_chestplate
					|| is.getItem() == Items.leather_leggings
					|| is.getItem() == Items.leather_helmet
					|| is.getItem() == Items.iron_boots
					|| is.getItem() == Items.iron_chestplate
					|| is.getItem() == Items.iron_leggings
					|| is.getItem() == Items.iron_helmet
					|| is.getItem() == Items.golden_boots
					|| is.getItem() == Items.golden_chestplate
					|| is.getItem() == Items.golden_leggings
					|| is.getItem() == Items.golden_helmet
					|| is.getItem() == Items.paper) {
				recipe.remove();
			}
		}

	}

}
