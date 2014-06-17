package com.github.thelonedevil.rpgoverhaul.weapons;

import com.github.thelonedevil.rpgoverhaul.RPGOMain;

import net.minecraft.item.Item;

public class Weapon extends Item {
	int attackDamage;
	int attackSpeed;
	WeaponType type;
	CrystalType crystal = CrystalType.NONE;

	public Weapon(WeaponType type, String name, int[] stats) {
		super();
		this.type = type;
		this.attackDamage = stats[0];
		this.attackSpeed = stats[1];
		this.setCreativeTab(RPGOMain.myTab).setMaxStackSize(1);

	}

	public void addCrystal(CrystalType newCrystal) {
		if (this.crystal.equals(CrystalType.NONE) && !newCrystal.equals(CrystalType.NONE)) {
			this.crystal = newCrystal;
		}
	}

	public CrystalType getCrystal() {
		return this.crystal;
	}

	public boolean removeCrystal() {
		if (!this.crystal.equals(CrystalType.NONE)) {
			this.crystal = CrystalType.NONE;
			return true;
		} else {
			return false;
		}
	}
	
	public int getAttackDamage(){
		return attackDamage;
	}
	
	public int getAttackSpeed(){
		return attackSpeed;
	}

}
