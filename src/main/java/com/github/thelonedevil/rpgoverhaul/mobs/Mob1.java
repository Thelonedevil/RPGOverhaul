package com.github.thelonedevil.rpgoverhaul.mobs;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.github.thelonedevil.rpgoverhaul.ai.EntityAIFleeLight;
import com.github.thelonedevil.rpgoverhaul.ai.EntityAIStartled;

public class Mob1 extends EntityMyMob implements IMob {
	
	public Mob1(World par1World) {
		super(par1World);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2,new EntityAIStartled(this,10.0D));
		//this.tasks.addTask(3, new EntityAIFleeLight(this, 2.0D));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.2D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.stepHeight = 2.0f;
		startled = false;

		// TODO Auto-generated constructor stub
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);

	}


	


}
