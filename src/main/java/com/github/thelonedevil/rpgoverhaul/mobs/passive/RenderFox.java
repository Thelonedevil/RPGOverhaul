package com.github.thelonedevil.rpgoverhaul.mobs.passive;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.github.thelonedevil.rpgoverhaul.Ref;

public class RenderFox extends RenderLiving {
	private static final ResourceLocation foxTextures = new ResourceLocation(Ref.MODID, "textures/entity/fox/fox.png");
	 private static final ResourceLocation wolfCollarTextures = new ResourceLocation("textures/entity/wolf/wolf_collar.png");

	public RenderFox(ModelBase p_i1262_1_, float p_i1262_2_) {
		super(p_i1262_1_, p_i1262_2_);

	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		// TODO Auto-generated method stub
		return foxTextures;
	}

	/*protected int shouldRenderPass(Fox p_77032_1_, int p_77032_2_, float p_77032_3_) {
		if (p_77032_2_ == 1 && p_77032_1_.isTamed()) {
			this.bindTexture(wolfCollarTextures);
			int j = p_77032_1_.getCollarColor();
			GL11.glColor3f(EntitySheep.fleeceColorTable[j][0], EntitySheep.fleeceColorTable[j][1], EntitySheep.fleeceColorTable[j][2]);
			return 1;
		} else {
			return -1;
		}
	}
	 protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_)
	    {
	        return this.shouldRenderPass((Fox)p_77032_1_, p_77032_2_, p_77032_3_);
	    }*/

}
