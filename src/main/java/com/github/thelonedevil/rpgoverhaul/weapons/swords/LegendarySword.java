package com.github.thelonedevil.rpgoverhaul.weapons.swords;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

import com.github.thelonedevil.rpgoverhaul.Ref;


public class LegendarySword extends Sword {
	String lore;
	
	public LegendarySword(String name,String lore, int[] stats){
		super(name, stats);
		this.lore = lore;
		this.setUnlocalizedName(name).setTextureName(Ref.MODID+":"+name);
	}
	
	public String getLore(){
		return lore;
	}
	
	@Override
	 public EnumRarity getRarity(ItemStack par1ItemStack){
		return EnumRarity.epic;
		
	}

	

}
