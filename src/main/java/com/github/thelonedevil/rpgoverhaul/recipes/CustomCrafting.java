package com.github.thelonedevil.rpgoverhaul.recipes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

import com.github.thelonedevil.rpgoverhaul.MyMetals;
import com.github.thelonedevil.rpgoverhaul.MyWeapons;
import com.github.thelonedevil.rpgoverhaul.items.MetalUtil;

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

		this.recipes.add(new WeaponSmithShapelessRecipe(par1ItemStack, arraylist));
	}

	public void addShapelessOreRecipe(ItemStack par1ItemStack, Object... par2ArrayOfObj) {
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

		this.recipes.add(new WeaponSmithShaplessOreRecipes(par1ItemStack, arraylist));
	}

	public WeaponSmithShapedOreRecipe addShapedOreRecipe(ItemStack par1ItemStack, Object... recipe) {
		WeaponSmithShapedOreRecipe shapedrecipes = new WeaponSmithShapedOreRecipe(par1ItemStack, recipe);
		this.recipes.add(shapedrecipes);
		return shapedrecipes;
	}

	public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, World par2World) {

		int i = 0;
		ItemStack itemstack = null;
		ItemStack itemstack1 = null;
		int j;

		for (j = 0; j < par1InventoryCrafting.getSizeInventory(); ++j) {
			ItemStack itemstack2 = par1InventoryCrafting.getStackInSlot(j);
			List<ItemStack> ingots = OreDictionary.getOres("ingotBase");
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

		if (i == 2 && itemstack != null && itemstack1 != null) {
			String name1 = itemstack.getItem().getUnlocalizedName().substring(11);
			String name2 = itemstack1.getItem().getUnlocalizedName().substring(11);
			switch (name1) {
			case MyMetals.ASUNALT:
				switch (name2) {
				case MyMetals.KIRITORIUM:
				case MyMetals.KETSUEKIUM:
					return MetalUtil.makeMixedIngot(itemstack, itemstack1);
				}
			case MyMetals.KIRITORIUM:
				switch (name2) {
				case MyMetals.ASUNALT:
					return MetalUtil.makeMixedIngot(itemstack, itemstack1);
				}
			case MyMetals.KETSUEKIUM:
				switch (name2) {
				case MyMetals.ASUNALT:
				case MyMetals.SHIKYOLT:
					return MetalUtil.makeMixedIngot(itemstack, itemstack1);
				}
			case MyMetals.SHIKYOLT:
				switch(name2){
				case MyMetals.KETSUEKIUM:
					return MetalUtil.makeMixedIngot(itemstack, itemstack1);
				}
			case MyMetals.XIATHERIUM:
				switch (name2) {
				case MyMetals.FARUNESE:
					return MetalUtil.makeMixedIngot(itemstack, itemstack1);
				}
			case MyMetals.FARUNESE:
				switch (name2) {
				case MyMetals.XIATHERIUM:
					return MetalUtil.makeMixedIngot(itemstack, itemstack1);
				}
			}

		}
		for (j = 0; j < this.recipes.size(); ++j) {
			IRecipe irecipe = (IRecipe) this.recipes.get(j);

			if (irecipe.matches(par1InventoryCrafting, par2World)) {
				if (irecipe.getCraftingResult(par1InventoryCrafting).getItem().equals(MyWeapons.broadSword)) {
					return WeaponUtil.makeBroadSword(par1InventoryCrafting);
				}
				
				if (irecipe.getCraftingResult(par1InventoryCrafting).getItem().equals(MyMetals.alloyIngot)) {
					ItemStack itemstack4 = null;
					for (j = 0; j < par1InventoryCrafting.getSizeInventory(); ++j) {
						ItemStack itemstack2 = par1InventoryCrafting.getStackInSlot(j);
						if (itemstack2 != null) {

							if (itemstack4 == null && itemstack2.getItem().equals(MyMetals.mixedIngot)) {
								itemstack4 = itemstack2;
							}


						}
					}
					if (itemstack4 != null) {
						ItemStack stack = new ItemStack(MyMetals.alloyIngot);
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

	/**
	 * returns the List<> of all recipes
	 */
	public List getRecipeList() {
		return this.recipes;
	}
}