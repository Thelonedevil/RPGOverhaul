package com.github.thelonedevil.rpgoverhaul.recipes;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class WeaponSmithRecipeSorter implements Comparator {
	final CustomCrafting crafting;

	public WeaponSmithRecipeSorter(CustomCrafting craftingHandler) {
		this.crafting = craftingHandler;
	}

	public int compareRecipes(IRecipe recipe1, IRecipe recipe2) {
		if (recipe1 instanceof WeaponSmithShapelessRecipe && recipe2 instanceof WeaponSmithShapedRecipe) {
			return 1;
		}

		if (recipe2 instanceof WeaponSmithShapelessRecipe && recipe1 instanceof WeaponSmithShapedRecipe) {
			return -1;
		}

		if (recipe2.getRecipeSize() < recipe1.getRecipeSize()) {
			return -1;
		}

		if (recipe2.getRecipeSize() > recipe1.getRecipeSize()) {
			return 1;
		}

		else
			return 0;
	}

	@Override
	public int compare(Object recipe1, Object recipe2) {
		return this.compareRecipes((IRecipe) recipe1, (IRecipe) recipe2);
	}

}