package com.github.thelonedevil.rpgoverhaul.mobs.passive;

import net.minecraft.client.model.ModelQuadruped;
import net.minecraft.client.model.ModelRenderer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class modelGoat extends ModelQuadruped {

	public modelGoat(int p_i1154_1_, float p_i1154_2_) {
		super(12, 0.0F);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3.0F, -4.0F, -6.0F, 6, 6, 8, 0.0F);
		this.head.setRotationPoint(0.0F, 6.0F, -8.0F);
		this.head.setTextureOffset(22, 0).addBox(-4.0F, -9.0F, -4.0F, 1, 6, 1, 0.0F);
		this.head.setTextureOffset(22, 0).addBox(3.0F, -9.0F, -4.0F, 1, 6, 1, 0.0F);
		this.body = new ModelRenderer(this, 28, 8);
		this.body.addBox(-4.0F, -10.0F, -7.0F, 8, 16, 6, 0.0F);
		this.body.setRotationPoint(0.0F, 5.0F, 2.0F);
	}

}