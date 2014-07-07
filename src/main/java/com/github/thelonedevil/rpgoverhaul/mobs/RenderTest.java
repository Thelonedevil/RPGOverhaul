package com.github.thelonedevil.rpgoverhaul.mobs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.github.thelonedevil.rpgoverhaul.Ref;

public class RenderTest extends RenderBiped {	

	public RenderTest(ModelBiped model, float shadowSize) {
		super(model, shadowSize);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par3Entity) {
		Mob1 mob = (Mob1) par3Entity;
		return new ResourceLocation(Ref.MODID+":textures/models/Unknown.png");


	}
}
