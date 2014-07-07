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
			if (is != null && is.getItem() == Items.diamond_boots) {
				recipe.remove();
			} else if (is != null && is.getItem() == Items.diamond_chestplate) {
				recipe.remove();
			} else if (is != null && is.getItem() == Items.diamond_leggings) {
				recipe.remove();
			} else if (is != null && is.getItem() == Items.diamond_helmet) {
				recipe.remove();
			} else if (is != null && is.getItem() == Items.leather_boots) {
				recipe.remove();
			} else if (is != null && is.getItem() == Items.leather_chestplate) {
				recipe.remove();
			} else if (is != null && is.getItem() == Items.leather_leggings) {
				recipe.remove();
			} else if (is != null && is.getItem() == Items.leather_helmet) {
				recipe.remove();
			} else if (is != null && is.getItem() == Items.iron_boots) {
				recipe.remove();
			} else if (is != null && is.getItem() == Items.iron_chestplate) {
				recipe.remove();
			} else if (is != null && is.getItem() == Items.iron_leggings) {
				recipe.remove();
			} else if (is != null && is.getItem() == Items.iron_helmet) {
				recipe.remove();
			} else if (is != null && is.getItem() == Items.golden_boots) {
				recipe.remove();
			} else if (is != null && is.getItem() == Items.golden_chestplate) {
				recipe.remove();
			} else if (is != null && is.getItem() == Items.golden_leggings) {
				recipe.remove();
			} else if (is != null && is.getItem() == Items.golden_helmet) {
				recipe.remove();
			}
		}
		;
	}

}
