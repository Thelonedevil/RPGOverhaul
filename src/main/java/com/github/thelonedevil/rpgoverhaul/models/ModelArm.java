package com.github.thelonedevil.rpgoverhaul.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelArm extends ModelBase {

	ModelRenderer arm;
	public ModelArm() {
		arm = new ModelRenderer(this, 11, 0);
		arm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4);
        arm.setRotationPoint(-5.0F, 2.0F + 12, 0.0F);
		arm.setTextureSize(64, 32);
		arm.mirror = true;
		setRotation(arm, 0F, 0F, 0F);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
	}
}
