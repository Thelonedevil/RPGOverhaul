package com.github.thelonedevil.rpgoverhaul.renderer.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.github.thelonedevil.rpgoverhaul.Ref;
import com.github.thelonedevil.rpgoverhaul.models.ModelArm;

import cpw.mods.fml.client.FMLClientHandler;

public class FistRenderer implements IItemRenderer {
	ModelArm modelArm;

	public FistRenderer() {
		modelArm = new ModelArm();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		Minecraft mc = Minecraft.getMinecraft();
		switch (type) {
		case EQUIPPED:
			break;
		case EQUIPPED_FIRST_PERSON:
			EntityPlayer playermp = mc.thePlayer;
			mc.renderEngine.bindTexture(mc.thePlayer.getLocationSkin());
			for (int var9 = 0; var9 < 2; var9++) {
				int var22 = var9 * 2 - 1;
				GL11.glPushMatrix();
				GL11.glTranslatef(-0.0F, -0.6F, 1.1F * var22);
				GL11.glRotatef(-45 * var22, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(59.0F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(-65 * var22, 0.0F, 1.0F, 0.0F);
				Render var24 = RenderManager.instance.getEntityRenderObject(mc.thePlayer);
				RenderPlayer var26 = (RenderPlayer) var24;
				float var13 = 1.0F;
				GL11.glScalef(var13, var13, var13);
				var26.renderFirstPersonArm(mc.thePlayer);
				GL11.glPopMatrix();
			}
			break;
		case ENTITY:
			break;
		case INVENTORY:
			break;
		default:
			break;
		}

	}

}