package com.github.thelonedevil.rpgoverhaul.renderer.block;

import net.minecraft.client.model.ModelBook;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.github.thelonedevil.rpgoverhaul.MyItems;
import com.github.thelonedevil.rpgoverhaul.Ref;
import com.github.thelonedevil.rpgoverhaul.handlers.ClientTickHandler;
import com.github.thelonedevil.rpgoverhaul.tileentities.PortalTileEntity;
import com.github.thelonedevil.rpgoverhaul.util.LogHelper;

public class TileEntityPortalRenderer extends TileEntitySpecialRenderer {
	private static final ResourceLocation book = new ResourceLocation(Ref.MODID + ":textures/models/QuestBook.png");
	private ModelBook model = new ModelBook();

	public void renderTileEntityAt(PortalTileEntity tile, double x, double y, double z, float p_147500_8_) {
		if (tile.book) {
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + 0.85f, (float) z + 0.5F);
			GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
			this.bindTexture(book);
			float pageFlip = 0F;
			float opening = 1F;
			GL11.glEnable(GL11.GL_CULL_FACE);
			model.render(null, 0F, 0F, pageFlip, opening, 0F, 1F / 16F);
			GL11.glPopMatrix();
		} 
		
		

	}

	public void renderTileEntityAt(TileEntity p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_) {
		this.renderTileEntityAt((PortalTileEntity) p_147500_1_, p_147500_2_, p_147500_4_, p_147500_6_, p_147500_8_);
	}

}
