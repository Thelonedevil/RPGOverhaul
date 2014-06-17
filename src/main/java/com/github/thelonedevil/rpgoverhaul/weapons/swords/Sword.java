package com.github.thelonedevil.rpgoverhaul.weapons.swords;

import com.github.thelonedevil.rpgoverhaul.weapons.Weapon;
import com.github.thelonedevil.rpgoverhaul.weapons.WeaponType;

public class Sword extends Weapon {
	
	int attackLength;
	
	public Sword(String name,int[] stats){
		super(WeaponType.SWORD, name, stats);
		this.attackLength = stats[2];
	}
	
	public int getAttackLength(){
		return attackLength;
	}
}
