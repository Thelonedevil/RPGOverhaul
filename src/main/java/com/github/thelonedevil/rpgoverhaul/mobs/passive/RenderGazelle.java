package com.github.thelonedevil.rpgoverhaul.mobs.passive;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.github.thelonedevil.rpgoverhaul.Ref;

public class RenderGazelle extends RenderLiving {
	private static final ResourceLocation gazelleTextures = new ResourceLocation(Ref.MODID, "textures/entity/gazelle/gazelle.png");

	public RenderGazelle(ModelBase p_i1262_1_, float p_i1262_2_) {
		super(p_i1262_1_, p_i1262_2_);

	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		// TODO Auto-generated method stub
		return gazelleTextures;
	}

}
