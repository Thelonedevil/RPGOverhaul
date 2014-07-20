package com.github.thelonedevil.rpgoverhaul.recipes;

import java.util.List;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;

import com.github.thelonedevil.rpgoverhaul.MyMetals;
import com.github.thelonedevil.rpgoverhaul.MyWeapons;
import com.github.thelonedevil.rpgoverhaul.items.MetalUtil;
import com.github.thelonedevil.rpgoverhaul.util.LogHelper;

public class WeaponUtil {

	public static ItemStack makeBroadSword(InventoryCrafting par1InventoryCrafting) {
		LogHelper.info("BroadSword Crafted!");
		int i = 0;
		ItemStack blade = null;
		ItemStack bottom = null;
		int j;

		for (j = 0; j < par1InventoryCrafting.getSizeInventory(); ++j) {
			ItemStack itemstack2 = par1InventoryCrafting.getStackInSlot(j);
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
			switch (blade.getItem().getUnlocalizedName().substring(5)) {
			case MyMetals.KETSUEKIUM:
				tag.setInteger("damage", MetalUtil.damage_ketsuekium);
				break;
			case MyMetals.IRON:
				tag.setInteger("damage", MetalUtil.damage_iron);
				break;
			case MyMetals.KIRITORIUM:
				tag.setInteger("damage", MetalUtil.damage_kiritorium);
				break;
			case MyMetals.NAUTRENESE:
				tag.setInteger("damage", MetalUtil.damage_nautrenese);
				break;
			case MyMetals.ASUNALT:
				tag.setInteger("damage", MetalUtil.damage_asunalt);
				break;
			case MyMetals.ITHASIUM:
				tag.setInteger("damage", MetalUtil.damage_ithasium);
				break;
			case MyMetals.OZESTUM:
				tag.setInteger("damage", MetalUtil.damage_ozestum);
				break;
			case MyMetals.SAKURALT:
				tag.setInteger("damage", MetalUtil.damage_sakuralt);
				break;
			case MyMetals.XIATHERIUM:
				tag.setInteger("damage", MetalUtil.damage_xiatherium);
				break;
			case MyMetals.OROBALT:
				tag.setInteger("damage", MetalUtil.damage_orobalt);
				break;
			case MyMetals.SHIKYOLT:
				tag.setInteger("damage", MetalUtil.damage_shikyolt);
				break;
			case MyMetals.AXESPIUM:
				tag.setInteger("damage", MetalUtil.damage_axespium);
				break;
			case MyMetals.AYAGRESE:
				tag.setInteger("damage", MetalUtil.damage_ayagrese);
				break;
			case MyMetals.EMODRALT:
				tag.setInteger("damage", MetalUtil.damage_emodralt);
				break;
			case MyMetals.ERUSLALT:
				tag.setInteger("damage", MetalUtil.damage_eruslalt);
				break;
			case MyMetals.EVOSUM:
				tag.setInteger("damage", MetalUtil.damage_evosum);
				break;
			case MyMetals.GOLD:
				tag.setInteger("damage", MetalUtil.damage_gold);
				break;
			case MyMetals.ONECRUM:
				tag.setInteger("damage", MetalUtil.damage_onecrum);
				break;
			case MyMetals.TENSHIRIUM:
				tag.setInteger("damage",MetalUtil.damage_tenshirium);
				break;
			case MyMetals.FARUNESE:
				tag.setInteger("damage", MetalUtil.damage_farunese);
				
			}

			stack.setTagCompound(tag);
			LogHelper.info("NBT SET!!");
			return stack;
		}
		return null;

	}

}
