package com.github.thelonedevil.rpgoverhaul.renderer.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.github.thelonedevil.rpgoverhaul.Ref;
import com.github.thelonedevil.rpgoverhaul.models.ModelLongSword;

import cpw.mods.fml.client.FMLClientHandler;

public class LongSwordRenderer implements IItemRenderer {
	ModelLongSword model;

	public LongSwordRenderer() {
		model = new ModelLongSword();
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
	public void renderItem(ItemRenderType type, ItemStack itemstack, Object... data) {
		String blade = "iron";
		String bottom = "iron";
		String blade1 = "iron"; 
		if (itemstack.getTagCompound() != null) {
			blade = itemstack.getTagCompound().getString("blade").toLowerCase();
			blade1 = itemstack.getTagCompound().getString("blade1").toLowerCase();
			bottom = itemstack.getTagCompound().getString("bottom").toLowerCase();
		}
		switch (type) {
		case EQUIPPED:
			float scale = 2f;
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glScalef(scale, scale, scale);
			GL11.glTranslatef(-0.2F, 0.7F, 0.9F);
			GL11.glRotatef(110F, 1F, 0, 0);
			GL11.glRotatef(110F, 0, 1F, 0);
			GL11.glRotatef(120F, 0, 0, 1F);
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/sword-handle.png"));
			model.render((Entity) data[1], 0, 0, 0, 0, 0, 0.0625F);
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/" + bottom + "-longsword-bottom.png"));
			model.render((Entity) data[1], 0, 0, 0, 0, 0, 0.0625F);
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/" + blade + "-longsword-blade.png"));
			model.render((Entity) data[1], 0, 0, 0, 0, 0, 0.0625F);
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/" + blade1 + "-longsword-blade1.png"));
			model.render((Entity) data[1], 0, 0, 0, 0, 0, 0.0625F);
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();
			break;
		case EQUIPPED_FIRST_PERSON:
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glTranslatef(-0.50F, 0.1F, 0F);
			GL11.glRotatef(180F, 1F, 0, 0);
			GL11.glRotatef(180F, 0, 1F, 0);
			GL11.glRotatef(90F, 0, 0, 1F);
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/sword-handle.png"));
			model.render((Entity) data[1], 0, 0, 0, 0, 0, 0.0625F);
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/" + bottom + "-longsword-bottom.png"));
			model.render((Entity) data[1], 0, 0, 0, 0, 0, 0.0625F);
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/" + blade + "-longsword-blade.png"));
			model.render((Entity) data[1], 0, 0, 0, 0, 0, 0.0625F);
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/" + blade1 + "-longsword-blade1.png"));
			model.render((Entity) data[1], 0, 0, 0, 0, 0, 0.0625F);
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();

			break;
		case ENTITY:
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glTranslatef(1F, 0F, 0F);
			GL11.glRotatef(90F, 1F, 0, 0);
			GL11.glRotatef(0F, 0, 1F, 0);
			GL11.glRotatef(90F, 0, 0, 1F);
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/sword-handle.png"));
			model.render((Entity) data[1], 0, 0, 0, 0, 0, 0.0625F);
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/" + bottom + "-longsword-bottom.png"));
			model.render((Entity) data[1], 0, 0, 0, 0, 0, 0.0625F);
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/" + blade + "-longsword-blade.png"));
			model.render((Entity) data[1], 0, 0, 0, 0, 0, 0.0625F);
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/" + blade1 + "-longsword-blade1.png"));
			model.render((Entity) data[1], 0, 0, 0, 0, 0, 0.0625F);
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();
			break;
		case INVENTORY:
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glTranslatef(-0.4F, 0.7F, 0F);
			GL11.glRotatef(90F, 1F, 0, 0);
			GL11.glRotatef(90F, 0, 1F, 0);
			GL11.glRotatef(90F, 0, 0, 1F);
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/sword-handle.png"));
			model.render(null, 0F, 0F, 0F, 0F, 0F, 0.0625F);
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/" + bottom + "-longsword-bottom.png"));
			model.render(null, 0F, 0F, 0F, 0F, 0F, 0.0625F);
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/" + blade + "-longsword-blade.png"));
			model.render(null, 0F, 0F, 0F, 0F, 0F, 0.0625F);
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/" + blade1 + "-longsword-blade1.png"));
			model.render(null, 0, 0, 0, 0, 0, 0.0625F);
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();
			break;
		default:
			break;
		}

	}


}
