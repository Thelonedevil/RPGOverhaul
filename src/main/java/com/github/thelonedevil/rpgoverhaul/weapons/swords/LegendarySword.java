package com.github.thelonedevil.rpgoverhaul.weapons.swords;

import com.github.thelonedevil.rpgoverhaul.RPGOMain;


public class LegendarySword extends Sword {
	String lore;
	
	public LegendarySword(String name,String lore, int[] stats){
		super(name, stats);
		this.lore = lore;
		this.setUnlocalizedName(name).setTextureName(RPGOMain.MODID+":"+name);
	}
	
	public String getLore(){
		return lore;
	}

	

}
