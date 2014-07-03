package com.github.thelonedevil.rpgoverhaul;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class CustomCrafting {
	/** The static instance of this class */
	private static final CustomCrafting instance = new CustomCrafting();
	/** A list of all the recipes added */
	private List recipes = new ArrayList();

	/**
	 * Returns the static instance of this class
	 */
	public static final CustomCrafting getInstance() {
		/** The static instance of this class */
		return instance;
	}

	private CustomCrafting() {

		Collections.sort(this.recipes, new WeaponSmithRecipeSorter(this));
	}

	public WeaponSmithShapedRecipe addRecipe(ItemStack par1ItemStack, Object... par2ArrayOfObj) {
		String s = "";
		int i = 0;
		int j = 0;
		int k = 0;

		if (par2ArrayOfObj[i] instanceof String[]) {
			String[] astring = (String[]) ((String[]) par2ArrayOfObj[i++]);

			for (int l = 0; l < astring.length; ++l) {
				String s1 = astring[l];
				++k;
				j = s1.length();
				s = s + s1;
			}
		} else {
			while (par2ArrayOfObj[i] instanceof String) {
				String s2 = (String) par2ArrayOfObj[i++];
				++k;
				j = s2.length();
				s = s + s2;
			}
		}

		HashMap hashmap;

		for (hashmap = new HashMap(); i < par2ArrayOfObj.length; i += 2) {
			Character character = (Character) par2ArrayOfObj[i];
			ItemStack itemstack1 = null;

			if (par2ArrayOfObj[i + 1] instanceof Item) {
				itemstack1 = new ItemStack((Item) par2ArrayOfObj[i + 1]);
			} else if (par2ArrayOfObj[i + 1] instanceof Block) {
				itemstack1 = new ItemStack((Block) par2ArrayOfObj[i + 1], 1, 32767);
			} else if (par2ArrayOfObj[i + 1] instanceof ItemStack) {
				itemstack1 = (ItemStack) par2ArrayOfObj[i + 1];
			}

			hashmap.put(character, itemstack1);
		}

		ItemStack[] aitemstack = new ItemStack[j * k];

		for (int i1 = 0; i1 < j * k; ++i1) {
			char c0 = s.charAt(i1);

			if (hashmap.containsKey(Character.valueOf(c0))) {
				aitemstack[i1] = ((ItemStack) hashmap.get(Character.valueOf(c0))).copy();
			} else {
				aitemstack[i1] = null;
			}
		}

		WeaponSmithShapedRecipe shapedrecipes = new WeaponSmithShapedRecipe(j, k, aitemstack, par1ItemStack);
		this.recipes.add(shapedrecipes);
		return shapedrecipes;
	}

	public void addShapelessRecipe(ItemStack par1ItemStack, Object... par2ArrayOfObj) {
		ArrayList arraylist = new ArrayList();
		Object[] aobject = par2ArrayOfObj;
		int i = par2ArrayOfObj.length;

		for (int j = 0; j < i; ++j) {
			Object object1 = aobject[j];

			if (object1 instanceof ItemStack) {
				arraylist.add(((ItemStack) object1).copy());
			} else if (object1 instanceof Item) {
				arraylist.add(new ItemStack((Item) object1));
			} else {
				if (!(object1 instanceof Block)) {
					throw new RuntimeException("Invalid shapeless recipe!");
				}

				arraylist.add(new ItemStack((Block) object1));
			}
		}

		this.recipes.add(new ShapelessRecipes(par1ItemStack, arraylist));
	}

	public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, World par2World) {

		int i = 0;
		ItemStack itemstack = null;
		ItemStack itemstack1 = null;
		int j;

		for (j = 0; j < par1InventoryCrafting.getSizeInventory(); ++j) {
			ItemStack itemstack2 = par1InventoryCrafting.getStackInSlot(j);
			List<ItemStack> ingots = OreDictionary.getOres("baseIngot");
			if (itemstack2 != null) {
				if (i == 0) {
					for (int l = 0; l < ingots.size(); l++) {
						if (ingots.get(l).getItem().equals(itemstack2.getItem())) {
							itemstack = itemstack2;
						}
					}

				}

				if (i == 1) {
					for (int l = 0; l < ingots.size(); l++) {
						if (ingots.get(l).getItem().equals(itemstack2.getItem())) {
							itemstack1 = itemstack2;
						}
					}
				}

				++i;
			}
		}

		if (i == 2 && itemstack != null && itemstack1 != null && !itemstack1.getItem().equals(itemstack.getItem())) {
			ItemStack stack = new ItemStack(MyItems.mixedIngot);
			NBTTagCompound tag = new NBTTagCompound();
			tag.setString("metal1", itemstack.getUnlocalizedName().substring(11));
			tag.setString("metal2", itemstack1.getUnlocalizedName().substring(11));
			stack.setTagCompound(tag);
			return stack;
		}
		for (j = 0; j < this.recipes.size(); ++j) {
			IRecipe irecipe = (IRecipe) this.recipes.get(j);

			if (irecipe.matches(par1InventoryCrafting, par2World)) {
				if (irecipe.getCraftingResult(par1InventoryCrafting).getItem().equals(MyWeapons.broadsword_bottom)) {
					return broadswordBottom(par1InventoryCrafting, irecipe);
				}
				if (irecipe.getCraftingResult(par1InventoryCrafting).getItem().equals(MyItems.alloyIngot)) {
					int k = 0;
					ItemStack itemstack4 = null;
					ItemStack itemstack5 = null;

					for (j = 0; j < par1InventoryCrafting.getSizeInventory(); ++j) {
						ItemStack itemstack2 = par1InventoryCrafting.getStackInSlot(j);
						if (itemstack2 != null) {
							if (k == 0) {
								if (itemstack2.getItem().equals(MyItems.mixedIngot)) {
									itemstack4 = itemstack2;
								}

							}

							if (k == 1) {

								if (itemstack2.getItem().equals(MyItems.crystal_smelting)) {
									itemstack5 = itemstack2;
								}

							}

							++k;
						}
					}

					if (k == 2 && itemstack4 != null && itemstack5 != null) {
						ItemStack stack = new ItemStack(MyItems.alloyIngot);
						NBTTagCompound tag = new NBTTagCompound();
						tag.setString("metal1", itemstack4.getTagCompound().getString("metal1"));
						tag.setString("metal2", itemstack4.getTagCompound().getString("metal2"));
						stack.setTagCompound(tag);
						return stack;
					}
				}
			}
		}

		return null;

	}

	private ItemStack broadswordBottom(InventoryCrafting par1InventoryCrafting, IRecipe irecipe) {
		ItemStack slot1 = null;
		ItemStack slot2 = null;
		ItemStack slot3 = null;
		ItemStack slot4 = null;
		ItemStack slot5 = null;
		ItemStack slot6 = null;
		ItemStack slot7 = null;
		ItemStack slot8 = null;
		for (int k = 0; k < par1InventoryCrafting.getSizeInventory(); k++) {
			if (slot1 == null && par1InventoryCrafting.getStackInSlot(k) != null) {
				slot1 = par1InventoryCrafting.getStackInSlot(k);
			} else if (slot2 == null && par1InventoryCrafting.getStackInSlot(k) != null) {
				slot2 = par1InventoryCrafting.getStackInSlot(k);
			} else if (slot3 == null && par1InventoryCrafting.getStackInSlot(k) != null) {
				slot4 = par1InventoryCrafting.getStackInSlot(k);
			} else if (slot4 == null && par1InventoryCrafting.getStackInSlot(k) != null) {
				slot4 = par1InventoryCrafting.getStackInSlot(k);
			} else if (slot5 == null && par1InventoryCrafting.getStackInSlot(k) != null) {
				slot5 = par1InventoryCrafting.getStackInSlot(k);
			} else if (slot6 == null && par1InventoryCrafting.getStackInSlot(k) != null) {
				slot6 = par1InventoryCrafting.getStackInSlot(k);
			} else if (slot7 == null && par1InventoryCrafting.getStackInSlot(k) != null) {
				slot7 = par1InventoryCrafting.getStackInSlot(k);
			} else if (slot8 == null && par1InventoryCrafting.getStackInSlot(k) != null) {
				slot8 = par1InventoryCrafting.getStackInSlot(k);
			}
		}
		if ((Hardness.getAlloyHardness(slot1) == Hardness.HARD || Hardness.getMetalHardness(slot1) == Hardness.HARD)
				&& (Hardness.getAlloyHardness(slot2) == Hardness.HARD || Hardness.getMetalHardness(slot2) == Hardness.HARD)
				&& (Hardness.getAlloyHardness(slot3) == Hardness.HARD || Hardness.getMetalHardness(slot3) == Hardness.HARD)
				&& (Hardness.getAlloyHardness(slot4) == Hardness.HARD || Hardness.getMetalHardness(slot4) == Hardness.HARD)
				&& (Hardness.getAlloyHardness(slot5) == Hardness.HARD || Hardness.getMetalHardness(slot5) == Hardness.HARD)
				&& (Hardness.getAlloyHardness(slot6) == Hardness.HARD || Hardness.getMetalHardness(slot6) == Hardness.HARD)
				&& (Hardness.getAlloyHardness(slot7) == Hardness.HARD || Hardness.getMetalHardness(slot7) == Hardness.HARD)
				&& (Hardness.getAlloyHardness(slot8) == Hardness.SOFT || Hardness.getMetalHardness(slot8) == Hardness.SOFT)) {
			return irecipe.getCraftingResult(par1InventoryCrafting);
		} else {
			return null;
		}
	}

	/**
	 * returns the List<> of all recipes
	 */
	public List getRecipeList() {
		return this.recipes;
	}
}