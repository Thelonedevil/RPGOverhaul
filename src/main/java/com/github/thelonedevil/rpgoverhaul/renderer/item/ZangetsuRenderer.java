package com.github.thelonedevil.rpgoverhaul.renderer.item;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.github.thelonedevil.rpgoverhaul.Ref;
import com.github.thelonedevil.rpgoverhaul.models.ModelZangetsu;

import cpw.mods.fml.client.FMLClientHandler;

public class ZangetsuRenderer implements IItemRenderer {

	ModelZangetsu model;

	public ZangetsuRenderer() {
		model = new ModelZangetsu();
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
			scale = 0.04f;
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);

			// Scale, Translate, Rotate
			GL11.glScalef(scale, scale, scale);
			GL11.glTranslatef(10F, 70F, -15F);
			GL11.glRotatef(-70F, 1F, 0, 0);
			GL11.glRotatef(90F, 0, 1F, 0);
			GL11.glRotatef(-40F, 0, 0, 1F);

			// Bind texture
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/zangetsu.png"));

			// Render
			ModelZangetsu.render();

			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();
			break;

		case EQUIPPED_FIRST_PERSON:

			scale = 0.04f;
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);

			// Scale, Translate, Rotate
			GL11.glScalef(scale, scale, scale);
			GL11.glTranslatef(40.1F, -2.1F, -0.175F);
			GL11.glRotatef(0F, 1F, 0, 0);
			GL11.glRotatef(180F, 0, 1F, 0);
			GL11.glRotatef(-90F, 0, 0, 1F);

			// Bind texture
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/zangetsu.png"));

			// Render
			ModelZangetsu.render();

			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();

			break;

		case ENTITY:
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);

			// Scale, Translate, Rotate
			GL11.glScalef(0.04F, 0.04F, 0.04F);
			GL11.glTranslatef(0, 0, 0);
			GL11.glRotatef(0, 1F, 0, 0);

			// Bind texture
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/zangetsu.png"));

			// Render
			ModelZangetsu.render();

			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();
			break;

		case INVENTORY:
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);

			// Scale, Translate, Rotate
			GL11.glScalef(0.01F, 0.01F, 0.01F);
			GL11.glTranslatef(0, 0, 0);
			GL11.glRotatef(-90F, 1F, 0, 0);

			// Bind texture
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/zangetsu.png"));

			// Render
			ModelZangetsu.render();

			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();
			break;

		default:
			break;
		}

	}

}
