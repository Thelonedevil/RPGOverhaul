package com.github.thelonedevil.rpgoverhaul.weapons.swords;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import com.github.thelonedevil.rpgoverhaul.util.LogHelper;
import com.github.thelonedevil.rpgoverhaul.util.WeaponUtil;
import com.github.thelonedevil.rpgoverhaul.weapons.Weapon;
import com.github.thelonedevil.rpgoverhaul.weapons.WeaponType;
import com.github.thelonedevil.rpgoverhaul.weapons.swords.legendary.LegendarySword;

public class Sword extends Weapon {

	int attackLength;

	public Sword(String name, int[] stats) {
		super(WeaponType.SWORD, name, stats);
		this.attackLength = stats[1];
	}

	public int getAttackLength() {
		return attackLength;
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		String name1 = "Iron";
		String name2 = "Iron";
		String name3 = "Iron";
		NBTTagCompound tag = new NBTTagCompound();
		ItemStack stack = new ItemStack(item);
		int damage = 6;
		LogHelper.info(item.getUnlocalizedName().substring(5));
		switch (item.getUnlocalizedName().substring(5)) {
		case WeaponUtil.BROADSWORD:
			tag.setString("blade", name1);
			tag.setString("bottom", name2);
			tag.setInteger("damage", damage);
			stack.setTagCompound(tag);
			LogHelper.info("NBT SET!!");
			break;
		case WeaponUtil.LONGSWORD:
			tag.setString("blade", name1);
			tag.setString("blade1", name2);
			tag.setString("bottom", name3);
			tag.setInteger("damage", damage);
			stack.setTagCompound(tag);
			LogHelper.info("NBT SET!!");
			break;
		case WeaponUtil.GREATSWORD:
			break;
		}
		list.add(stack);
	}

	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		super.addInformation(itemstack, par2EntityPlayer, par3List, par4);
		if (itemstack.getTagCompound() != null) {
			if (itemstack.getItem() instanceof LegendarySword) {
			}else{
				String s = itemstack.getTagCompound().getString("bottom");
				String s1 = itemstack.getTagCompound().getString("blade");
				String s2 = "Made from " + s + " and " + s1;
				addStringToTooltip(StatCollector.translateToLocal(s2), par3List);
			}
			String s3 = "&9+" + itemstack.getTagCompound().getInteger("damage") + " Attack Damage";
			addStringToTooltip(StatCollector.translateToLocal(s3), par3List);
		}
	}

	private void addStringToTooltip(String s, List<String> tooltip) {
		tooltip.add(s.replaceAll("&", "\u00a7"));
	}
}
