package com.github.thelonedevil.rpgoverhaul.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.world.World;

public class EntityAIStartled extends EntityAIBase{
	
	private EntityCreature theCreature;
	private double shelterX;
	private double shelterY;
	private double shelterZ;
	private double movementSpeed;
	private World theWorld;
	private static final String __OBFID = "CL_00001583";

	public EntityAIStartled(EntityCreature par1EntityCreature, double par2) {
		this.theCreature = par1EntityCreature;
		this.movementSpeed = par2;
		this.theWorld = par1EntityCreature.worldObj;
		this.setMutexBits(1);
	}

	@Override
	public boolean shouldExecute() {
		// TODO Auto-generated method stub
		return false;
	}

}
