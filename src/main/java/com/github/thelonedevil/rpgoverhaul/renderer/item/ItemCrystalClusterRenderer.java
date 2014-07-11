package com.github.thelonedevil.rpgoverhaul.renderer.item;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.github.thelonedevil.rpgoverhaul.Ref;
import com.github.thelonedevil.rpgoverhaul.blocks.crystals.CrystalCluster;
import com.github.thelonedevil.rpgoverhaul.models.ModelCrystalBase;

import cpw.mods.fml.client.FMLClientHandler;

public class ItemCrystalClusterRenderer implements IItemRenderer {

	ModelCrystalBase model;

	public ItemCrystalClusterRenderer() {
		model = new ModelCrystalBase();
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
			scale = 1f;
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);

			// Scale, Translate, Rotate
			GL11.glScalef(scale, scale, scale);
			GL11.glTranslatef(0F, 0F, 0F);
			GL11.glRotatef(0F, 1F, 0, 0);
			GL11.glRotatef(0F, 0, 1F, 0);
			GL11.glRotatef(0F, 0, 0, 1F);
			switch (((CrystalCluster) Block.getBlockFromItem(item.getItem())).type) {
			case 0:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/fire_crystal.png"));
				break;
			case 1:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/water_crystal.png"));
				break;
			case 2:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/air_crystal.png"));
				break;
			case 3:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/earth_crystal.png"));
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
			scale = 1f;
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);

			// Scale, Translate, Rotate
			GL11.glScalef(scale, scale, scale);
			GL11.glTranslatef(0F, 0.72F, 0F);
			GL11.glRotatef(0F, 1F, 0, 0);
			GL11.glRotatef(0F, 0, 1F, 0);
			GL11.glRotatef(0F, 0, 0, 1F);

			switch (((CrystalCluster) Block.getBlockFromItem(item.getItem())).type) {
			case 0:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/fire_crystal.png"));
				break;
			case 1:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/water_crystal.png"));
				break;
			case 2:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/air_crystal.png"));
				break;
			case 3:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/earth_crystal.png"));
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
			GL11.glScalef(1F, 1F, 1F);
			GL11.glTranslatef(0, 0, 0);
			GL11.glRotatef(0, 1F, 0, 0);

			switch (((CrystalCluster) Block.getBlockFromItem(item.getItem())).type) {
			case 0:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/fire_crystal.png"));
				break;
			case 1:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/water_crystal.png"));
				break;
			case 2:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/air_crystal.png"));
				break;
			case 3:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/earth_crystal.png"));
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
			GL11.glScalef(1f, 1F, 1F);
			GL11.glTranslatef(0, 0, 0);
			GL11.glRotatef(-90F, 1F, 0, 0);

			switch (((CrystalCluster) Block.getBlockFromItem(item.getItem())).type) {
			case 0:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/fire_crystal.png"));
				break;
			case 1:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/water_crystal.png"));
				break;
			case 2:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/air_crystal.png"));
				break;
			case 3:
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/earth_crystal.png"));
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
