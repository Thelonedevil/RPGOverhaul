package com.github.thelonedevil.rpgoverhaul.world;

import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.client.ForgeHooksClient;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomWorldProvider extends WorldProvider {

	public CustomWorldProvider() {
		super();

	}

	@Override
	public String getDimensionName() {
		return "OverWorld";
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Vec3 getFogColor(float var1, float var2) {

		return this.worldObj.getWorldVec3Pool().getVecFromPool((double) 0F / 255F, (double) 0F / 255F, (double) 0F / 255F);
	}

	@Override
	// @SideOnly(Side.CLIENT)
	public Vec3 getSkyColor(Entity cameraEntity, float partialTicks) {
		{
			float f1 = this.worldObj.getCelestialAngle(partialTicks);
			float f2 = MathHelper.cos(f1 * (float) Math.PI * 2.0F) * 2.0F + 0.5F;

			if (f2 < 0.0F) {
				f2 = 0.0F;
			}

			if (f2 > 1.0F) {
				f2 = 1.0F;
			}

			int i = MathHelper.floor_double(cameraEntity.posX);
			int j = MathHelper.floor_double(cameraEntity.posY);
			int k = MathHelper.floor_double(cameraEntity.posZ);
			int l = ForgeHooksClient.getSkyBlendColour(this.worldObj, i, j, k);
			float f4 = (float) (l & 255) / 255.0F;
			float f5 = (float) (l >> 8 & 255) / 255.0F;
			float f6 = (float) (l >> 16 & 255) / 255.0F;
			f4 *= f2;
			f5 *= f2;
			f6 *= f2;
			float f7 = this.worldObj.getRainStrength(partialTicks);
			float f8;
			float f9;

			if (f7 > 0.0F) {
				f8 = (f4 * 0.3F + f5 * 0.59F + f6 * 0.11F) * 0.6F;
				f9 = 1.0F - f7 * 0.75F;
				f4 = f4 * f9 + f8 * (1.0F - f9);
				f5 = f5 * f9 + f8 * (1.0F - f9);
				f6 = f6 * f9 + f8 * (1.0F - f9);
			}

			f8 = this.worldObj.getWeightedThunderStrength(partialTicks);

			if (f8 > 0.0F) {
				f9 = (f4 * 0.3F + f5 * 0.59F + f6 * 0.11F) * 0.2F;
				float f10 = 1.0F - f8 * 0.75F;
				f4 = f4 * f10 + f9 * (1.0F - f10);
				f5 = f5 * f10 + f9 * (1.0F - f10);
				f6 = f6 * f10 + f9 * (1.0F - f10);
			}

			if (this.worldObj.lastLightningBolt > 0) {
				f9 = (float) this.worldObj.lastLightningBolt - partialTicks;

				if (f9 > 1.0F) {
					f9 = 1.0F;
				}

				f9 *= 0.45F;
				f4 = f4 * (1.0F - f9) + 0.8F * f9;
				f5 = f5 * (1.0F - f9) + 0.8F * f9;
				f6 = f6 * (1.0F - f9) + 1.0F * f9;
			}

			return this.worldObj.getWorldVec3Pool().getVecFromPool((double) f4, (double) f5, (double) f6);

		}
	}
	@Override
	@SideOnly(Side.CLIENT)
    public float getStarBrightness(float par1)
    {
		return par1 *0.5F *6F;
    }
	@Override
    public int getMoonPhase(long par1)
    {
        return 4;
    }
}
