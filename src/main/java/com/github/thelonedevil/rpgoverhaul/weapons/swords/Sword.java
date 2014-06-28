package com.github.thelonedevil.rpgoverhaul.weapons.swords;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.github.thelonedevil.rpgoverhaul.weapons.Weapon;
import com.github.thelonedevil.rpgoverhaul.weapons.WeaponType;

public class Sword extends Weapon {

	int attackLength;

	public Sword(String name, int[] stats) {
		super(WeaponType.SWORD, name, stats);
		this.attackLength = stats[2];
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
}
