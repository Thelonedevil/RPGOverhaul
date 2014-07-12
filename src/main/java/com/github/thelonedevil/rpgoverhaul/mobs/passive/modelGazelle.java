package com.github.thelonedevil.rpgoverhaul.mobs.passive;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelQuadruped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class modelGazelle extends ModelQuadruped {
	ModelRenderer horn;

	public modelGazelle() {
		
		super(15, 0.0f);
		int size = 15;
		float scale = 0.0f;
		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3.0F, -11.0F, -6.0F, 6, 6, 8, scale);
		this.head.setRotationPoint(0.0F, 6.0F, -8.0F);
		this.horn = new ModelRenderer(this,22,0);
		this.horn.addBox(-3.0F, -15.0F, -6.0F, 2, 6, 2, scale);
		this.horn.addBox(1.0F, -15.0F, -6.0F, 2, 6, 2, scale);
		this.horn.addBox(-2.5F, -21.0F, -5.5F, 1, 6, 1, scale);
		this.horn.addBox(1.5F, -21.0F, -5.5F, 1, 6, 1, scale);
		this.body.setTextureOffset(30,0).addBox(0, 6.0f, -4, 2,2, 2,scale);
		this.leg1 = new ModelRenderer(this, 0, 15);
        this.leg1.addBox(-2.0F, 0.0F, -2.0F, 2, size, 2, scale);
        this.leg1.setRotationPoint(-3.0F, (float)(24 - size), 7.0F);
        this.leg2 = new ModelRenderer(this, 0, 15);
        this.leg2.addBox(0.0F, 0.0F, -2.0F, 2, size, 2, scale);
        this.leg2.setRotationPoint(3.0F, (float)(24 - size), 7.0F);
        this.leg3 = new ModelRenderer(this, 0, 15);
        this.leg3.addBox(-2.0F, 0.0F, -2.0F, 2, size, 2, scale);
        this.leg3.setRotationPoint(-3.0F, (float)(24 - size), -5.0F);
        this.leg4 = new ModelRenderer(this, 0, 15);
        this.leg4.addBox(0.0F, 0.0F, -2.0F, 2, size, 2, scale);
        this.leg4.setRotationPoint(3.0F, (float)(24 - size), -5.0F);
	}
	
	public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
		super.render(p_78088_1_, p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
		

		if (this.isChild) {
			float f6 = 2.0F;
			GL11.glPushMatrix();
			GL11.glTranslatef(0.0F, 5.0F * p_78088_7_, 2.0F * p_78088_7_);
			this.head.renderWithRotation(p_78088_7_);
			this.horn.renderWithRotation(p_78088_7_);
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
			GL11.glTranslatef(0.0F, 24.0F * p_78088_7_, 0.0F);
			this.body.render(p_78088_7_);
			this.leg1.render(p_78088_7_);
			this.leg2.render(p_78088_7_);
			this.leg3.render(p_78088_7_);
			this.leg4.render(p_78088_7_);


			GL11.glPopMatrix();
		} else {
			this.head.renderWithRotation(p_78088_7_);
			this.horn.renderWithRotation(p_78088_7_);
			this.body.render(p_78088_7_);
			this.leg1.render(p_78088_7_);
			this.leg2.render(p_78088_7_);
			this.leg3.render(p_78088_7_);
			this.leg4.render(p_78088_7_);
		}
	}




	
	public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
		super.setRotationAngles(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
		this.horn.setRotationPoint(0.0F, 6.0F, -8.0F);
		this.horn.rotateAngleY = this.head.rotateAngleY;
		this.horn.rotateAngleZ = this.head.rotateAngleZ;
		this.horn.rotateAngleX = this.head.rotateAngleX +6f;
	}

}
