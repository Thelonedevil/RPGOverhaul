package com.github.thelonedevil.rpgoverhaul.util;

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
	
	public static int getDamage(ItemStack stack){
		int damage1;
		switch (stack.getItem().getUnlocalizedName().substring(5)) {
		case MyMetals.KETSUEKIUM:
			damage1 = MetalUtil.damage_ketsuekium;
			break;
		case MyMetals.IRON:
			damage1 = MetalUtil.damage_iron;
			break;
		case MyMetals.KIRITORIUM:
			damage1 = MetalUtil.damage_kiritorium;
			break;
		case MyMetals.NAUTRENESE:
			damage1 = MetalUtil.damage_nautrenese;
			break;
		case MyMetals.ASUNALT:
			damage1 = MetalUtil.damage_asunalt;
			break;
		case MyMetals.ITHASIUM:
			damage1 = MetalUtil.damage_ithasium;
			break;
		case MyMetals.OZESTUM:
			damage1 = MetalUtil.damage_ozestum;
			break;
		case MyMetals.SAKURALT:
			damage1 = MetalUtil.damage_sakuralt;
			break;
		case MyMetals.XIATHERIUM:
			damage1 = MetalUtil.damage_xiatherium;
			break;
		case MyMetals.OROBALT:
			damage1 = MetalUtil.damage_orobalt;
			break;
		case MyMetals.SHIKYOLT:
			damage1 = MetalUtil.damage_shikyolt;
			break;
		case MyMetals.AXESPIUM:
			damage1 = MetalUtil.damage_axespium;
			break;
		case MyMetals.AYAGRESE:
			damage1 = MetalUtil.damage_ayagrese;				
			break;
		case MyMetals.EMODRALT:
			damage1 = MetalUtil.damage_emodralt;				
			break;
		case MyMetals.ERUSLALT:
			damage1 = MetalUtil.damage_eruslalt;
			break;
		case MyMetals.EVOSUM:
			damage1 = MetalUtil.damage_evosum;
			break;
		case MyMetals.GOLD:
			damage1 = MetalUtil.damage_gold;
			break;
		case MyMetals.ONECRUM:
			damage1 = MetalUtil.damage_onecrum;
			break;
		case MyMetals.TENSHIRIUM:
			damage1 = MetalUtil.damage_tenshirium;
			break;
		case MyMetals.FARUNESE:
			damage1 = MetalUtil.damage_farunese;
			break;
		default:
			damage1 = 6;
		}
		
		return damage1;
		
	}

}
