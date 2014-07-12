package com.github.thelonedevil.rpgoverhaul.mobs.passive;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;

public class Gazelle extends EntityAnimal {

	public Gazelle(World p_i1681_1_) {
		super(p_i1681_1_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		// TODO Auto-generated method stub
		return new Gazelle(this.worldObj);
	}

}
