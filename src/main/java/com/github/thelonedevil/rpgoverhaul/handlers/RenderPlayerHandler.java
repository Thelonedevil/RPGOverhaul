package com.github.thelonedevil.rpgoverhaul.handlers;


import com.github.thelonedevil.rpgoverhaul.Ref;
import com.github.thelonedevil.rpgoverhaul.inventory.ArmourInventory;
import com.github.thelonedevil.rpgoverhaul.models.ModelHelmet;
import com.github.thelonedevil.rpgoverhaul.player.ExtendedPlayer;
import com.github.thelonedevil.rpgoverhaul.util.ArmourUtil;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;
import org.lwjgl.opengl.GL11;

/**
 * Created by justin on 30/07/2014.
 */
public class RenderPlayerHandler {
    @SubscribeEvent
    public void onPlayerRender(RenderPlayerEvent.Pre event) {
        EntityPlayer player = event.entityPlayer;
        ArmourInventory inv = ExtendedPlayer.get(player).armour;
        for (int i = 0; i < inv.getSizeInventory(); i++) {
            if(inv.getStackInSlot(i)!= null){
                switch(inv.getStackInSlot(i).getUnlocalizedName().substring(5)){
                    case ArmourUtil.HELMET:
                        GL11.glPushMatrix();
                        float yaw =  player.getRotationYawHead();
                        float pitch = player.rotationPitch;


                        GL11.glRotatef(-yaw,0f,1f,0f);
                        GL11.glRotatef(pitch,1f,0f,0f);
                        GL11.glRotatef(180f,1f,0f,0f);
                        Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Ref.MODID, "models/helmet.png"));
                        new ModelHelmet().render(player,0,0,0,0,0,0.0625f);
                        GL11.glPopMatrix();
                }
            }
        }
    }
}
