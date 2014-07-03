package com.github.thelonedevil.rpgoverhaul;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class WeaponSmithShapelessRecipe implements IRecipe {
	// Is the ItemStack that you get when craft the recipe.
	private final ItemStack recipeOutput;

	// Is a List of ItemStack that composes the recipe.
	public final List recipeItems;

	private static final String __OBFID = "CL_00000094";

	public WeaponSmithShapelessRecipe(ItemStack par1ItemStack, List par2List) {
		this.recipeOutput = par1ItemStack;
		this.recipeItems = par2List;
	}

	public ItemStack getRecipeOutput() {
		return this.recipeOutput;
	}

	// Used to check if a recipe matches current crafting inventory
	public boolean matches(InventoryCrafting par1InventoryCrafting, World par2World) {
		ArrayList arraylist = new ArrayList(this.recipeItems);

		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 5; col++) {
				ItemStack itemstack = par1InventoryCrafting.getStackInRowAndColumn(col, row);

				if (itemstack != null) {
					boolean flag = false;
					Iterator iterator = arraylist.iterator();

					while (iterator.hasNext()) {
						ItemStack itemstack1 = (ItemStack) iterator.next();

						if (itemstack.getItem() == itemstack1.getItem() && (itemstack1.getItemDamage() == 32767 || itemstack.getItemDamage() == itemstack1.getItemDamage())) {
							flag = true;
							arraylist.remove(itemstack1);
							break;
						}
					}

					if (!flag) {
						return false;
					}
				}
			}
		}

		return arraylist.isEmpty();
	}

	// Returns an Item that is the result of this recipe
	public ItemStack getCraftingResult(InventoryCrafting par1InventoryCrafting) {
		return this.recipeOutput.copy();
	}

	// Returns the size of the recipe area
	public int getRecipeSize() {
		return this.recipeItems.size();
	}
}
