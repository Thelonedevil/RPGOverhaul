package com.github.thelonedevil.rpgoverhaul.renderer.block;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.github.thelonedevil.rpgoverhaul.Ref;
import com.github.thelonedevil.rpgoverhaul.models.ModelCrystalBase;
import com.github.thelonedevil.rpgoverhaul.tileentities.CrystalClusterTileEntity;

public class TileEntityCrystalRenderer extends TileEntitySpecialRenderer {
	private final ModelCrystalBase model = new ModelCrystalBase();

	private final RenderItem customRenderItem;

	public TileEntityCrystalRenderer() {
		customRenderItem = new RenderItem() {
			@Override
			public boolean shouldBob() {
				return false;
			}
		};

		customRenderItem.setRenderManager(RenderManager.instance);
	}

	@Override
	public void renderTileEntityAt(TileEntity var1, double x, double y, double z, float var8) {
		if (var1 instanceof CrystalClusterTileEntity) {
			CrystalClusterTileEntity TE = (CrystalClusterTileEntity) var1;
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);
			float scale = 1.0f;
			GL11.glScalef(scale, scale, scale);
			GL11.glTranslated((float) x + 0.4f, (float) y, (float) z + 0.4f);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			//GL11.glColor4f(1F, 1F, 1F, 0.75F);
			this.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/crystal.png"));
			switch (TE.Type) {
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
				this.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/fire_crystal.png"));
				break;
			case 5:
				this.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/fire_crystal.png"));
				break;
			case 6:
				this.bindTexture(new ResourceLocation(Ref.MODID, "textures/models/fire_crystal.png"));
				break;
			}
			model.render();
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();
		}

	}

}
