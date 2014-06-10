package com.github.thelonedevil.rpgoverhaul.ai;

import java.util.Random;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityAIFleeLight extends EntityAIBase {

	private EntityCreature theCreature;
	private double shelterX;
	private double shelterY;
	private double shelterZ;
	private double movementSpeed;
	private World theWorld;

	public EntityAIFleeLight(EntityCreature par1EntityCreature, double par2) {
		this.theCreature = par1EntityCreature;
		this.movementSpeed = par2;
		this.theWorld = par1EntityCreature.worldObj;
		this.setMutexBits(1);
	}

	@Override
	public boolean shouldExecute() {
		if ((this.theWorld.getBlock(MathHelper.floor_double(this.theCreature.posX), (int) this.theCreature.boundingBox.minY, MathHelper.floor_double(this.theCreature.posZ)).getLightValue() < 3)) {
			return false;
		} else {
			Vec3 vec3 = this.findPossibleShelter();
			if (vec3 == null) {
				return false;
			} else {
				this.shelterX = vec3.xCoord;
				this.shelterY = vec3.yCoord;
				this.shelterZ = vec3.zCoord;
				return true;
			}
		}
	}

	public boolean continueExecuting() {
		return !this.theCreature.getNavigator().noPath();
	}

	public void startExecuting() {
		this.theCreature.getNavigator().tryMoveToXYZ(this.shelterX, this.shelterY, this.shelterZ, this.movementSpeed);
	}

	private Vec3 findPossibleShelter() {
		Random random = this.theCreature.getRNG();

		for (int i = 0; i < 10; ++i) {
			int j = MathHelper.floor_double(this.theCreature.posX + (double) random.nextInt(20) - 10.0D);
			int k = MathHelper.floor_double(this.theCreature.boundingBox.minY + (double) random.nextInt(6) - 3.0D);
			int l = MathHelper.floor_double(this.theCreature.posZ + (double) random.nextInt(20) - 10.0D);

			if (this.theWorld.getBlock(j, k, l).getLightValue() < 3 && this.theCreature.getBlockPathWeight(j, k, l) < 1.0F) {
				return this.theWorld.getWorldVec3Pool().getVecFromPool((double) j, (double) k, (double) l);
			}
		}

		return null;
	}

}
