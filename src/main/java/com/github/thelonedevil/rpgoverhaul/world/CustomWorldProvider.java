package com.github.thelonedevil.rpgoverhaul.world;

import net.minecraft.world.WorldProvider;

public class CustomWorldProvider extends WorldProvider {
	
	public CustomWorldProvider(){
		super();
		
	}
	
	@Override
	public String getDimensionName() {
		return "OverWorld";
	}
	
	
	
	
	
}
