package com.github.thelonedevil.rpgoverhaul.renderer.item;

import com.github.thelonedevil.rpgoverhaul.models.ModelArm;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

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
                float var7 = 0.8F;
                GL11.glPushMatrix();
                if (mc.gameSettings.thirdPersonView == 0) {
                    GL11.glTranslatef(1.0F, 0.75F, -1.0F);
                    GL11.glRotatef(135.0F, 0.0F, -1.0F, 0.0F);

                    GL11.glTranslatef(-0.7F * var7, -(-0.65F * var7) + (1.0F) * 1.5F, 0.9F * var7);
                    GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
                    GL11.glTranslatef(0.0F, 0.0F * var7, -0.9F * var7);
                    GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(0.0F, 0.0F, 0.0F, 1.0F);
                    GL11.glEnable(32826);
                    GL11.glPushMatrix();
                    GL11.glScalef(5.0F, 5.0F, 5.0F);
                    mc.renderEngine.bindTexture(mc.thePlayer.getLocationSkin());
                    for (int var9 = 1; var9 < 2; var9++) {
                        GL11.glPushMatrix();
                        GL11.glTranslatef(-0.0F, -1.4F, 1.1F );
                        GL11.glRotatef(15.0f, 1.0F, 0.0F, 0.0F);
                        GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
                        GL11.glRotatef(59.0F, 0.0F, 0.0F, 1.0F);
                        GL11.glRotatef(-65 , 0.0F, 1.0F, 0.0F);
                        Render var24 = RenderManager.instance.getEntityRenderObject(mc.thePlayer);
                        RenderPlayer var26 = (RenderPlayer) var24;
                        float var13 = 1.0F;
                        GL11.glScalef(var13, var13, var13);
                        var26.renderFirstPersonArm(mc.thePlayer);
                        GL11.glPopMatrix();
                    }
                    GL11.glPopMatrix();
                    GL11.glTranslatef(0.4F, -0.4F, 0.0F);
                    GL11.glEnable(32826);
                    GL11.glScalef(2.0F, 2.0F, 2.0F);
                }
                GL11.glPopMatrix();
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