package com.github.thelonedevil.rpgoverhaul.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.github.thelonedevil.rpgoverhaul.Ref;
import com.github.thelonedevil.rpgoverhaul.weapons.swords.Sword2;

public class Sword2Renderer implements IItemRenderer {

	Sword2 model;

	public Sword2Renderer() {
		model = new Sword2();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		// TODO Auto-generated method stub
		return true;

	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		switch (type) {
		case INVENTORY:
			return true;
		default:
			break;
		}
		return false;

	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		Minecraft mc = Minecraft.getMinecraft();
		Float scale;
		switch (type) {

		case EQUIPPED:
			// render in third person
			GL11.glPushMatrix(); // start gl rendering for this section
			scale = 3F;
			GL11.glScalef(scale, scale, scale);
			mc.renderEngine.bindTexture(new ResourceLocation(Ref.MODID + ":textures/models/Sword2.png"));
			GL11.glRotatef(30F, 1.0f, 0.0f, 0.0f); // rotate 0 ° on X axis
			GL11.glRotatef(-70F, 0.0f, 1.0f, 0.0f); // rotate -5 ° on Y axis
			GL11.glRotatef(-150F, 0.0f, 0.0f, 1.0f); // rotate -150 ° on Z axis
			GL11.glTranslatef(-0.1F, -0.1F, -0.175F); // translate model to fit
														// in
														// the hand of the
														// player
			// the entity argument can/could be passed to as null.
			model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix(); // Stop gl rendering for this section
			break;

		case EQUIPPED_FIRST_PERSON:

			// rince and repeat the rendering. adjust axis' and translation as
			// needed
			GL11.glPushMatrix();
			scale = 3F;
			GL11.glScalef(scale, scale, scale);
			mc.renderEngine.bindTexture(new ResourceLocation(Ref.MODID + ":textures/models/Sword2.png"));
			GL11.glRotatef(0F, 1.0f, 0.0f, 0.0f);
			GL11.glRotatef(-5F, 0.0f, 1.0f, 0.0f);
			GL11.glRotatef(-150F, 0.0f, 0.0f, 1.0f);
			GL11.glTranslatef(-0.2f, -0.0F, -0.1F);
			model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			break;

		case ENTITY:
			GL11.glPushMatrix();
			scale = 3F;
			GL11.glScalef(scale, scale, scale);
			mc.renderEngine.bindTexture(new ResourceLocation(Ref.MODID + ":textures/models/Sword2.png"));
			GL11.glRotatef(90F, 1.0f, 0.0f, 0.0f);
			GL11.glRotatef(0F, 0.0f, 1.0f, 0.0f);
			GL11.glRotatef(45F, 0.0f, 0.0f, 1.0f);
			GL11.glTranslatef(-0.1F, 0.5F, 0F);
			model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			break;

		case INVENTORY:
			GL11.glPushMatrix();
			scale = 1F;
			GL11.glScalef(scale, scale, scale);
			mc.renderEngine.bindTexture(new ResourceLocation(Ref.MODID + ":textures/models/Sword2.png"));

			GL11.glRotatef(200F, 1.0f, 0.0f, 0.0f);
			GL11.glRotatef(-80F, 0.0f, 1.0f, 0.0f);
			GL11.glTranslatef(0.0F, 1.2F, 0F);
			// this is a method made by me in my model class to render only the
			// modelparts, without an entity argument, because in your
			// inventory, //the entity is always null.
			model.render(null, 0.0625F, 0.0625F, 0.0625F, 0.0625F, 0.0625F, 0.0625F);
			GL11.glPopMatrix();
			break;

		default:
			break;
		}

	}

}
