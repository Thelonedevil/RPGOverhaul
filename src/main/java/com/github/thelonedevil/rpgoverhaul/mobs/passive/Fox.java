package com.github.thelonedevil.rpgoverhaul.mobs.passive;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.github.thelonedevil.rpgoverhaul.MyItems;

public class Fox extends EntityAnimal {

	public Fox(World p_i1681_1_) {
		super(p_i1681_1_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		return new Fox(this.worldObj);
	}

	public boolean isAIEnabled() {
		return true;
	}

	protected Item getDropItem() {
		return MyItems.foxFur;
	}

	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		int j = this.rand.nextInt(3) + this.rand.nextInt(1 + p_70628_2_);
		int k;

		for (k = 0; k < j; ++k) {
			this.dropItem(MyItems.goatSkin, 1);
		}

		j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + p_70628_2_);

		for (k = 0; k < j; ++k) {
			if (this.isBurning()) {
				this.dropItem(MyItems.CookedGoat, 1);
			} else {
				this.dropItem(MyItems.RawGoat, 1);
			}
		}
	}

}
