package com.github.thelonedevil.rpgoverhaul.mobs.passive;

import com.github.thelonedevil.rpgoverhaul.MyItems;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Gazelle extends EntityAnimal {

	public Gazelle(World p_i1681_1_) {
		super(p_i1681_1_);
		this.setSize(0.9F, 0.9F);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
		this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(4, new EntityAITempt(this, 1.2D, Item.getItemFromBlock(Blocks.vine), false));
		this.tasks.addTask(4, new EntityAITempt(this, 1.2D, Item.getItemFromBlock(Blocks.sapling), false));
		this.tasks.addTask(5, new EntityAIFollowParent(this, 1.1D));
		this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
	}

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		// TODO Auto-generated method stub
		return new Gazelle(this.worldObj);
	}
	public boolean isAIEnabled() {
		return true;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
	}

	protected void updateAITasks() {
		super.updateAITasks();
	}
	protected Item getDropItem() {
		return this.isBurning() ? MyItems.CookedGazelle : MyItems.RawGazelle;
	}

	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		int j = this.rand.nextInt(3) + this.rand.nextInt(1 + p_70628_2_);
		int k;
		for (k = 0; k < j; ++k) {
			if (this.isBurning()) {
				this.dropItem(MyItems.CookedGazelle, 1);
			} else {
				this.dropItem(MyItems.RawGazelle, 1);
			}
		}
	}

	public boolean isBreedingItem(ItemStack p_70877_1_) {
		return p_70877_1_ != null && p_70877_1_.getItem() == Item.getItemFromBlock(Blocks.vine);
	}

}
