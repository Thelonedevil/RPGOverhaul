package com.github.thelonedevil.rpgoverhaul.weapons.swords;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import com.github.thelonedevil.rpgoverhaul.Ref;
import com.github.thelonedevil.rpgoverhaul.weapons.Weapon;
import com.github.thelonedevil.rpgoverhaul.weapons.WeaponType;

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
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.block;
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		return par1ItemStack;
	}
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		super.addInformation(itemstack, par2EntityPlayer, par3List, par4);
		if (itemstack.getTagCompound() != null) {
			String s = itemstack.getTagCompound().getString("bottom");
			String s1 = itemstack.getTagCompound().getString("blade");
			String s2 = "Made from " + s + " and " + s1;
			String s3 = "&9+"+itemstack.getTagCompound().getInteger("damage")+" Attack Damage";
			addStringToTooltip(StatCollector.translateToLocal(s2), par3List);
			addStringToTooltip(StatCollector.translateToLocal(s3), par3List);
		}
	}

	private void addStringToTooltip(String s, List<String> tooltip) {
		tooltip.add(s.replaceAll("&", "\u00a7"));
	}
}
