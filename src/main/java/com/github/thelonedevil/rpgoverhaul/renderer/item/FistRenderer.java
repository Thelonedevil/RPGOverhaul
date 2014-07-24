package com.github.thelonedevil.rpgoverhaul.renderer.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class FistRenderer implements IItemRenderer {
    public FistRenderer() {

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
                GL11.glPushMatrix();
                if (mc.gameSettings.thirdPersonView == 0) {
                    mc.renderEngine.bindTexture(mc.thePlayer.getLocationSkin());
                    GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(45.0f, 1.0F, 0.0F, 0.0F);
                    GL11.glTranslatef(0F, -0.7F, 0F);
                    GL11.glScalef(2.5F, 2.5F, 2.5F);
                    Render render = RenderManager.instance.getEntityRenderObject(mc.thePlayer);
                    RenderPlayer player = (RenderPlayer) render;
                    player.renderFirstPersonArm(mc.thePlayer);
                }
                GL11.glPopMatrix();

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