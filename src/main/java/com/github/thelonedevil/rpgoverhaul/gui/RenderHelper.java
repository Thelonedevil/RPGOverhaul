
package com.github.thelonedevil.rpgoverhaul.gui;

import java.util.List;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.Tessellator;

import org.lwjgl.opengl.GL11;

public final class RenderHelper {

	public static void renderTooltip(int x, int y, List<String> tooltipData) {
		int color = 0x505000ff;
		int color2 = 0xf0100010;

		renderTooltip(x, y, tooltipData, color, color2);
	}

	public static void renderTooltipOrange(int x, int y, List<String> tooltipData) {
		int color = 0x50a06600;
		int color2 = 0xf01e1200;

		renderTooltip(x, y, tooltipData, color, color2);
	}

	public static void renderTooltipGreen(int x, int y, List<String> tooltipData) {
		int color = 0x5000a000;
		int color2 = 0xf0001e00;

		renderTooltip(x, y, tooltipData, color, color2);
	}

	public static void renderTooltip(int x, int y, List<String> tooltipData, int color, int color2) {
		boolean lighting = GL11.glGetBoolean(GL11.GL_LIGHTING);
		if(lighting)
			net.minecraft.client.renderer.RenderHelper.disableStandardItemLighting();

		if (!tooltipData.isEmpty()) {
			int var5 = 0;
			int var6;
			int var7;
			FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
			for (var6 = 0; var6 < tooltipData.size(); ++var6) {
				var7 = fontRenderer.getStringWidth(tooltipData.get(var6));
				if (var7 > var5)
					var5 = var7;
			}
			var6 = x + 12;
			var7 = y - 12;
			int var9 = 8;
			if (tooltipData.size() > 1)
				var9 += 2 + (tooltipData.size() - 1) * 10;
			float z = 300F;
			drawGradientRect(var6 - 3, var7 - 4, z, var6 + var5 + 3, var7 - 3, color2, color2);
			drawGradientRect(var6 - 3, var7 + var9 + 3, z, var6 + var5 + 3, var7 + var9 + 4, color2, color2);
			drawGradientRect(var6 - 3, var7 - 3, z, var6 + var5 + 3, var7 + var9 + 3, color2, color2);
			drawGradientRect(var6 - 4, var7 - 3, z, var6 - 3, var7 + var9 + 3, color2, color2);
			drawGradientRect(var6 + var5 + 3, var7 - 3, z, var6 + var5 + 4, var7 + var9 + 3, color2, color2);
			int var12 = (color & 0xFFFFFF) >> 1 | color & -16777216;
			drawGradientRect(var6 - 3, var7 - 3 + 1, z, var6 - 3 + 1, var7 + var9 + 3 - 1, color, var12);
			drawGradientRect(var6 + var5 + 2, var7 - 3 + 1, z, var6 + var5 + 3, var7 + var9 + 3 - 1, color, var12);
			drawGradientRect(var6 - 3, var7 - 3, z, var6 + var5 + 3, var7 - 3 + 1, color, color);
			drawGradientRect(var6 - 3, var7 + var9 + 2, z, var6 + var5 + 3, var7 + var9 + 3, var12, var12);

			GL11.glDisable(GL11.GL_DEPTH_TEST);
			for (int var13 = 0; var13 < tooltipData.size(); ++var13) {
				String var14 = tooltipData.get(var13);
				fontRenderer.drawStringWithShadow(var14, var6, var7, -1);
				if (var13 == 0)
					var7 += 2;
				var7 += 10;
			}
			GL11.glEnable(GL11.GL_DEPTH_TEST);
		}
		if(!lighting)
			net.minecraft.client.renderer.RenderHelper.disableStandardItemLighting();
		GL11.glColor4f(1F, 1F, 1F, 1F);
	}

	public static void drawGradientRect(int par1, int par2, float z, int par3, int par4, int par5, int par6) {
		float var7 = (par5 >> 24 & 255) / 255F;
		float var8 = (par5 >> 16 & 255) / 255F;
		float var9 = (par5 >> 8 & 255) / 255F;
		float var10 = (par5 & 255) / 255F;
		float var11 = (par6 >> 24 & 255) / 255F;
		float var12 = (par6 >> 16 & 255) / 255F;
		float var13 = (par6 >> 8 & 255) / 255F;
		float var14 = (par6 & 255) / 255F;
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		Tessellator var15 = Tessellator.instance;
		var15.startDrawingQuads();
		var15.setColorRGBA_F(var8, var9, var10, var7);
		var15.addVertex(par3, par2, z);
		var15.addVertex(par1, par2, z);
		var15.setColorRGBA_F(var12, var13, var14, var11);
		var15.addVertex(par1, par4, z);
		var15.addVertex(par3, par4, z);
		var15.draw();
		GL11.glShadeModel(GL11.GL_FLAT);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}

	public static void drawTexturedModalRect(int par1, int par2, float z, int par3, int par4, int par5, int par6) {
		float f = 0.00390625F;
		float f1 = 0.00390625F;
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(par1 + 0, par2 + par6, z, (par3 + 0) * f, (par4 + par6) * f1);
		tessellator.addVertexWithUV(par1 + par5, par2 + par6, z, (par3 + par5) * f, (par4 + par6) * f1);
		tessellator.addVertexWithUV(par1 + par5, par2 + 0, z, (par3 + par5) * f, (par4 + 0) * f1);
		tessellator.addVertexWithUV(par1 + 0, par2 + 0, z, (par3 + 0) * f, (par4 + 0) * f1);
		tessellator.draw();
	}

	public static void renderStar(int color, float xScale, float yScale, float zScale, long seed) {
		Tessellator tessellator = Tessellator.instance;

		int ticks = (int) (Minecraft.getMinecraft().theWorld.getTotalWorldTime() % 200);
		if (ticks >= 100)
			ticks = 200 - ticks - 1;

		float f1 = ticks / 200F;
		float f2 = 0F;
		if (f1 > 0.7F)
			f2 = (f1 - 0.7F) / 0.2F;
		Random random = new Random(seed);

		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(770, 1);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glDepthMask(false);
		GL11.glTranslatef(0F, -1F, -2F);
		GL11.glScalef(xScale, yScale, zScale);

		for (int i = 0; i < (f1 + f1 * f1) / 2F * 90F + 30F; i++) {
			GL11.glRotatef(random.nextFloat() * 360F, 1F, 0F, 0F);
			GL11.glRotatef(random.nextFloat() * 360F, 0F, 1F, 0F);
			GL11.glRotatef(random.nextFloat() * 360F, 0F, 0F, 1F);
			GL11.glRotatef(random.nextFloat() * 360F, 1F, 0F, 0F);
			GL11.glRotatef(random.nextFloat() * 360F, 0F, 1F, 0F);
			GL11.glRotatef(random.nextFloat() * 360F + f1 * 90F, 0F, 0F, 1F);
			tessellator.startDrawing(GL11.GL_TRIANGLE_FAN);
			float f3 = random.nextFloat() * 20F + 5F + f2 * 10F;
			float f4 = random.nextFloat() * 2F + 1F + f2 * 2F;
			tessellator.setColorRGBA_I(color, (int) (255F * (1F - f2)));
			tessellator.addVertex(0, 0, 0);
			tessellator.setColorRGBA_F(0F, 0F, 0F, 0);
			tessellator.addVertex(-0.866D * f4, f3, -0.5F * f4);
			tessellator.addVertex(0.866D * f4, f3, -0.5F * f4);
			tessellator.addVertex(0, f3, 1F * f4);
			tessellator.addVertex(-0.866D * f4, f3, -0.5F * f4);
			tessellator.draw();
		}

		GL11.glDepthMask(true);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glShadeModel(GL11.GL_FLAT);
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glPopMatrix();
	}
}
