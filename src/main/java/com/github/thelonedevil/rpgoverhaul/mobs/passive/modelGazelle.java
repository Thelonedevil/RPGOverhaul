package com.github.thelonedevil.rpgoverhaul.mobs.passive;

import net.minecraft.client.model.ModelQuadruped;
import net.minecraft.client.model.ModelRenderer;

public class modelGazelle extends ModelQuadruped {
	
	ModelRenderer neck;

	public modelGazelle() {
		super(15, 0.0f);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3.0F, -7.0F, -6.0F, 6, 6, 8, 0.0F);
		this.head.setRotationPoint(0.0F, 6.0F, -8.0F);
		this.head.setTextureOffset(22, 0).addBox(-4.0F, -9.0F, -4.0F, 1, 6, 1, 0.0F);
		this.head.setTextureOffset(22, 0).addBox(3.0F, -9.0F, -4.0F, 1, 6, 1, 0.0F);
		this.neck = new ModelRenderer(this, 0,0);
		this.neck.addBox(-3.0f, -4.0f, -6.0f, 6, 6, 8, 0.0f);
	}

}
