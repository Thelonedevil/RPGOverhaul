package com.github.thelonedevil.rpgoverhaul.renderer.item;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.github.thelonedevil.rpgoverhaul.Ref;
import com.github.thelonedevil.rpgoverhaul.items.Crystal;
import com.github.thelonedevil.rpgoverhaul.models.ModelCrystal;

import cpw.mods.fml.client.FMLClientHandler;

public class CrystalRenderer implements IItemRenderer {
	ModelCrystal model;

	public CrystalRenderer() {
		model = new ModelCrystal();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;

	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {

		return true;

	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		Minecraft mc = Minecraft.getMinecraft();
		Float scale;
		switch (type) {

		case EQUIPPED:
			scale = 0.5f;
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);

			// Scale, Translate, Rotate
			GL11.glScalef(scale, scale, scale);
			GL11.glTranslatef(1.8F, 1.5F, 1F);
			GL11.glRotatef(-135F, 1F, 0, 0);
			GL11.glRotatef(0F, 0, 1F, 0);
			GL11.glRotatef(0F, 0, 0, 1F);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			//GL11.glColor4f(1F, 1F, 1F, 0.75F);
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/crystal.png"));
			switch (((Crystal)item.getItem()).type) {
			case 0:
				GL11.glColor4f(1f, 0f, 0f,0.75F);
				break;
			case 1:
				GL11.glColor4f(0f, 0f, 1f,0.75F);
				break;
			case 2:
				GL11.glColor4f(1f, 1f, 0.68235294117f,0.75F);
				break;
			case 3:
				GL11.glColor4f(0f, 1f, 0f,0.75F);
				break;
			case 4:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/fire_crystal.png"));
				break;
			case 5:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/fire_crystal.png"));
				break;
			case 6:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/fire_crystal.png"));
				break;
			}

			// Render
			model.render();

			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();
			break;

		case EQUIPPED_FIRST_PERSON:
			scale = 0.5f;
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);

			// Scale, Translate, Rotate
			GL11.glScalef(scale, scale, scale);
			GL11.glTranslatef(0F, 2F, 0F);
			GL11.glRotatef(-45F, 1F, 0, 0);
			GL11.glRotatef(0F, 0, 1F, 0);
			GL11.glRotatef(0F, 0, 0, 1F);

			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			//GL11.glColor4f(1F, 1F, 1F, 0.75F);
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/crystal.png"));
			switch (((Crystal)item.getItem()).type) {
			case 0:
				GL11.glColor4f(1f, 0f, 0f,0.75F);
				break;
			case 1:
				GL11.glColor4f(0f, 0f, 1f,0.75F);
				break;
			case 2:
				GL11.glColor4f(1f, 1f, 0.68235294117f,0.75F);
				break;
			case 3:
				GL11.glColor4f(0f, 1f, 0f,0.75F);
				break;
			case 4:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/fire_crystal.png"));
				break;
			case 5:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/fire_crystal.png"));
				break;
			case 6:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/fire_crystal.png"));
				break;
			}
			// Render
			model.render();

			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();

			break;

		case ENTITY:
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);

			// Scale, Translate, Rotate
			GL11.glScalef(0.5F, 0.5F, 0.5F);
			GL11.glTranslatef(0, 0, 0);
			GL11.glRotatef(0, 1F, 0, 0);

			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			//GL11.glColor4f(1F, 1F, 1F, 0.75F);
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/crystal.png"));
			switch (((Crystal)item.getItem()).type) {
			case 0:
				GL11.glColor4f(1f, 0f, 0f,0.75F);
				break;
			case 1:
				GL11.glColor4f(0f, 0f, 1f,0.75F);
				break;
			case 2:
				GL11.glColor4f(1f, 1f, 0.68235294117f,0.75F);
				break;
			case 3:
				GL11.glColor4f(0f, 1f, 0f,0.75F);
				break;
			case 4:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/fire_crystal.png"));
				break;
			case 5:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/fire_crystal.png"));
				break;
			case 6:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/fire_crystal.png"));
				break;
			}
			// Render
			model.render();

			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();
			break;

		case INVENTORY:
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);

			// Scale, Translate, Rotate
			GL11.glScalef(0.5f, 0.5F, 0.5F);
			GL11.glTranslatef(0, 0, 0);
			GL11.glRotatef(-135F, 1F, 0, 0);

			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			//GL11.glColor4f(1F, 1F, 1F, 0.75F);
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/crystal.png"));
			switch (((Crystal)item.getItem()).type) {
			case 0:
				GL11.glColor4f(1f, 0f, 0f,0.75F);
				break;
			case 1:
				GL11.glColor4f(0f, 0f, 1f,0.75F);
				break;
			case 2:
				GL11.glColor4f(1f, 1f, 0.68235294117f,0.75F);
				break;
			case 3:
				GL11.glColor4f(0f, 1f, 0f,0.75F);
				break;
			case 4:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/fire_crystal.png"));
				break;
			case 5:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/fire_crystal.png"));
				break;
			case 6:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/fire_crystal.png"));
				break;
			}
			// Render
			model.render();

			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();
			break;

		default:
			break;
		}

	}

}
