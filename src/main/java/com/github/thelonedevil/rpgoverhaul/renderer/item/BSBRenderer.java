package com.github.thelonedevil.rpgoverhaul.renderer.item;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.github.thelonedevil.rpgoverhaul.RPGOMain;
import com.github.thelonedevil.rpgoverhaul.Ref;
import com.github.thelonedevil.rpgoverhaul.util.Util;

import cpw.mods.fml.client.FMLClientHandler;

public class BSBRenderer implements IItemRenderer {

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
		NBTTagCompound tag = item.getTagCompound();
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
			BufferedImage img = null;
			ResourceLocation resloc;
			for(String key : RPGOMain.textures.keySet()){
				if(key.equalsIgnoreCase("bsb.png")){
					img = RPGOMain.textures.get(key);
					break;
				}
			}
			if (img == null){
				resloc= new ResourceLocation(Ref.MODID, "textures/models/bsb.png");
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(resloc);
				
			}else{
				 GL11.glBindTexture(GL11.GL_TEXTURE_2D, TextureUtil.uploadTextureImage(TextureUtil.glGenTextures(), img));
			}
			

			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();
			break;

		case EQUIPPED_FIRST_PERSON:

			scale = 0.04f;
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);

			GL11.glScalef(scale, scale, scale);
			GL11.glTranslatef(40.1F, -2.1F, -0.175F);
			GL11.glRotatef(0F, 1F, 0, 0);
			GL11.glRotatef(180F, 0, 1F, 0);
			GL11.glRotatef(-90F, 0, 0, 1F);

			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/bsb.png"));

			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();

			break;

		case ENTITY:
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);

			GL11.glScalef(0.04F, 0.04F, 0.04F);
			GL11.glTranslatef(0, 0, 0);
			GL11.glRotatef(0, 1F, 0, 0);

			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/bsb.png"));

			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();
			break;

		case INVENTORY:
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);

			GL11.glScalef(0.01F, 0.01F, 0.01F);
			GL11.glTranslatef(0, 0, 0);
			GL11.glRotatef(-90F, 1F, 0, 0);

			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/zangetsu.png"));

			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();
			break;

		default:
			break;
		}

	}

}
