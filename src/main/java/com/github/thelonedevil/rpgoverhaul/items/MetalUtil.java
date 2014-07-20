package com.github.thelonedevil.rpgoverhaul.items;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import com.github.thelonedevil.rpgoverhaul.MyMetals;

public class MetalUtil {

	public static final int damage_ketsuekium = 10;
	public static final int damage_nautrenese = 9;
	public static final int damage_kiritorium = 15;
	public static final int damage_iron = 6;
	public static final int damage_asunalt = 15;
	public static final int damage_ithasium = 8;
	public static final int damage_ozestum = 8;
	public static final int damage_sakuralt = 12;
	public static final int damage_xiatherium = 8;
	public static final int damage_orobalt = 9;
	public static final int damage_shikyolt = 11;
	public static final int damage_axespium = 10;
	public static final int damage_ayagrese = 10;
	public static final int damage_emodralt = 10;
	public static final int damage_eruslalt = 10;
	public static final int damage_evosum = 10;
	public static final int damage_gold = 4;
	public static final int damage_onecrum = 10;
	public static final int damage_tenshirium = 10;
	public static final int damage_farunese = 10;

	public static String getMetals(ItemStack stack) {
		if (stack.getTagCompound() != null) {
			// alloys
			NBTTagCompound tag = stack.getTagCompound();
			String i = tag.getString("metal1");
			String j = tag.getString("metal2");
			return i + " " + j;
		} else {
			// base
			return stack.getUnlocalizedName().substring(10);
		}
	}

	public static ItemStack makeMixedIngot(ItemStack itemstack, ItemStack itemstack1) {
		ItemStack stack = new ItemStack(MyMetals.mixedIngot);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setString("metal1", itemstack.getUnlocalizedName().substring(10));
		tag.setString("metal2", itemstack1.getUnlocalizedName().substring(10));
		stack.setTagCompound(tag);
		return stack;
	}

}
