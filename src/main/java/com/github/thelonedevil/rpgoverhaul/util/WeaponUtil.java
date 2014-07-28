package com.github.thelonedevil.rpgoverhaul.util;

import java.util.List;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraftforge.oredict.OreDictionary;

import com.github.thelonedevil.rpgoverhaul.MyMetals;
import com.github.thelonedevil.rpgoverhaul.MyWeapons;

public class WeaponUtil {

	public static final String BROADSWORD = "broadsword";
	public static final String LONGSWORD = "longsword";
	public static final String GREATSWORD = "greatsword";
	public static final String FIST = "fist";
    public static final String SCYTHE = "scythe";
    public static final String DAGGER = "dagger";

	public static ItemStack makeBroadSword(InventoryCrafting craft) {
		LogHelper.info("BroadSword Crafted!");
		int i = 0;
		ItemStack blade = null;
		ItemStack bottom = null;
		int j;

		for (j = 0; j < craft.getSizeInventory(); ++j) {
			ItemStack itemstack2 = craft.getStackInSlot(j);
			List<ItemStack> ingots = OreDictionary.getOres("ingotMetal");
			if (itemstack2 != null) {
				if (i == 0) {
					for (int l = 0; l < ingots.size(); l++) {
						if (ingots.get(l).getItem().equals(itemstack2.getItem())) {
							blade = itemstack2;
							LogHelper.info("Blade added");
						}
					}

				}

				if (i == 1) {
					for (int l = 0; l < ingots.size(); l++) {
						if (ingots.get(l).getItem().equals(itemstack2.getItem())) {
							bottom = itemstack2;
							LogHelper.info("bottom added");
						}
					}
				}
				i++;

			}
		}
		if (blade != null && bottom != null) {
			String name1 = blade.getItem().getUnlocalizedName().substring(10);
			String name2 = bottom.getItem().getUnlocalizedName().substring(10);
			ItemStack stack = new ItemStack(MyWeapons.broadSword);
			NBTTagCompound tag = new NBTTagCompound();
			tag.setString("blade", name1);
			tag.setString("bottom", name2);
			int damage = MetalUtil.getDamage(blade);
			tag.setInteger("damage", damage);
			stack.setTagCompound(tag);
			LogHelper.info("NBT SET!!");
			return stack;
		}
		return null;

	}

	public static ItemStack makeLongSword(InventoryCrafting craft) {
		LogHelper.info("LongSword Crafted!");
		int i = 0;
		ItemStack blade = null;
		ItemStack blade1 = null;
		ItemStack bottom = null;
		int j;

		for (j = 0; j < craft.getSizeInventory(); ++j) {
			ItemStack itemstack2 = craft.getStackInSlot(j);
			List<ItemStack> ingots = OreDictionary.getOres("ingotMetal");
			if (itemstack2 != null) {
				if (i == 0) {
					for (int l = 0; l < ingots.size(); l++) {
						if (ingots.get(l).getItem().equals(itemstack2.getItem())) {
							blade = itemstack2;
							LogHelper.info("Blade added");
						}
					}

				}

				if (i == 1) {
					for (int l = 0; l < ingots.size(); l++) {
						if (ingots.get(l).getItem().equals(itemstack2.getItem())) {
							blade1 = itemstack2;
							LogHelper.info("blade1 added");
						}
					}
				}
				if (i == 2) {
					for (int l = 0; l < ingots.size(); l++) {
						if (ingots.get(l).getItem().equals(itemstack2.getItem())) {
							bottom = itemstack2;
							LogHelper.info("bottom added");
						}
					}
				}
				i++;

			}
		}
		if (blade != null && blade1 != null && bottom != null) {
			String name1 = blade.getItem().getUnlocalizedName().substring(10);
			String name2 = blade1.getItem().getUnlocalizedName().substring(10);
			String name3 = bottom.getItem().getUnlocalizedName().substring(10);
			ItemStack stack = new ItemStack(MyWeapons.longSword);
			NBTTagCompound tag = new NBTTagCompound();
			tag.setString("blade", name1);
			tag.setString("blade1", name2);
			tag.setString("bottom", name3);
			int damage1 = MetalUtil.getDamage(blade);
			int damage2 = MetalUtil.getDamage(blade1);
            double damage3 = (damage1 + damage2) * 0.8;
            int damage = (int)Math.ceil(damage3);
			tag.setInteger("damage", damage);
			stack.setTagCompound(tag);
			LogHelper.info("NBT SET!!");
			return stack;
		}
		return null;
	}

    public static ItemStack makeGreatSword(InventoryCrafting craft){
        LogHelper.info("greatSword Crafted!");
        int i = 0;
        ItemStack blade = null;
        ItemStack blade1 = null;
        ItemStack bottom = null;
        ItemStack blade2 = null;
        int j;

        for (j = 0; j < craft.getSizeInventory(); ++j) {
            ItemStack itemstack2 = craft.getStackInSlot(j);
            List<ItemStack> ingots = OreDictionary.getOres("ingotMetal");
            if (itemstack2 != null) {
                if (i == 0) {
                    for (int l = 0; l < ingots.size(); l++) {
                        if (ingots.get(l).getItem().equals(itemstack2.getItem())) {
                            blade = itemstack2;
                            LogHelper.info("Blade added");
                        }
                    }

                }

                if (i == 1) {
                    for (int l = 0; l < ingots.size(); l++) {
                        if (ingots.get(l).getItem().equals(itemstack2.getItem())) {
                            blade1 = itemstack2;
                            LogHelper.info("blade1 added");
                        }
                    }
                }
                if (i == 2){
                    for (int l = 0; l < ingots.size(); l++) {
                        if (ingots.get(l).getItem().equals(itemstack2.getItem())) {
                            blade2 = itemstack2;
                            LogHelper.info("blade2 added");
                        }
                    }
                }
                if (i == 3) {
                    for (int l = 0; l < ingots.size(); l++) {
                        if (ingots.get(l).getItem().equals(itemstack2.getItem())) {
                            bottom = itemstack2;
                            LogHelper.info("bottom added");
                        }
                    }
                }
                i++;

            }
        }
        if (blade != null && blade1 != null && blade2 != null && bottom != null) {
            String name1 = blade.getItem().getUnlocalizedName().substring(10);
            String name2 = blade1.getItem().getUnlocalizedName().substring(10);
            String name3 = bottom.getItem().getUnlocalizedName().substring(10);
            String name4 = blade2.getItem().getUnlocalizedName().substring(10);
            ItemStack stack = new ItemStack(MyWeapons.greatSword);
            NBTTagCompound tag = new NBTTagCompound();
            tag.setString("blade", name1);
            tag.setString("blade1", name2);
            tag.setString("blade2", name4);
            tag.setString("bottom", name3);
            int damage1 = MetalUtil.getDamage(blade);
            int damage2 = MetalUtil.getDamage(blade1);
            int damage3 = MetalUtil.getDamage(blade2);
            double damage4 = ((damage1 + damage2+ damage3) / 3);
            int damage = (int)Math.ceil(damage4);
            tag.setInteger("damage", damage);
            stack.setTagCompound(tag);
            LogHelper.info("NBT SET!!");
            return stack;
        }
        return null;
    }
    public static ItemStack makeFist(InventoryCrafting craft){
        return null;
    }
    public static ItemStack makeScythe(InventoryCrafting craft){
        return null;
    }
    public static ItemStack makeHammer(InventoryCrafting craft){
        return null;
    }
    public static ItemStack makeMace(InventoryCrafting craft){
        return null;
    }
    public static ItemStack makeDagger(InventoryCrafting craft){
        LogHelper.info("Dagger Crafted!");
        int i = 0;
        ItemStack blade = null;

        int j;

        for (j = 0; j < craft.getSizeInventory(); ++j) {
            ItemStack itemstack2 = craft.getStackInSlot(j);
            List<ItemStack> ingots = OreDictionary.getOres("ingotMetal");
            if (itemstack2 != null) {
                if (i == 0) {
                    for (int l = 0; l < ingots.size(); l++) {
                        if (ingots.get(l).getItem().equals(itemstack2.getItem())) {
                            blade = itemstack2;
                            LogHelper.info("Blade added");
                        }
                    }

                }
                i++;

            }
        }
        if (blade != null ) {
            String name1 = blade.getItem().getUnlocalizedName().substring(10);
            ItemStack stack = new ItemStack(MyWeapons.dagger);
            NBTTagCompound tag = new NBTTagCompound();
            tag.setString("blade", name1);
            int damage = MetalUtil.getDamage(blade);
            tag.setInteger("damage", damage);
            stack.setTagCompound(tag);
            LogHelper.info("NBT SET!!");
            return stack;
        }
        return null;
    }
    public static ItemStack makeStave(InventoryCrafting craft){
        return null;
    }

}
