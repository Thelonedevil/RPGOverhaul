package com.github.thelonedevil.rpgoverhaul.renderer.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBook;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.github.thelonedevil.rpgoverhaul.MyItems;
import com.github.thelonedevil.rpgoverhaul.Ref;
import com.github.thelonedevil.rpgoverhaul.handlers.ClientTickHandler;
import com.github.thelonedevil.rpgoverhaul.util.LogHelper;

public class RenderQuestBook implements IItemRenderer {

	ModelBook model = new ModelBook();
	ResourceLocation texture = new ResourceLocation(Ref.MODID + ":textures/models/QuestBook.png");

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return type == ItemRenderType.EQUIPPED_FIRST_PERSON;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		GL11.glPushMatrix();
		Minecraft mc = Minecraft.getMinecraft();
		mc.renderEngine.bindTexture(texture);
		float opening = 0F;
		float pageFlip = 0F;

		int ticks = ClientTickHandler.ticksWithLexicaOpen;
		GL11.glTranslatef(0.3F + 0.02F * ticks, 0.475F + 0.01F * ticks, -0.2F - 0.01F * ticks);
		GL11.glRotatef(87.5F + ticks * 5, 0F, 1F, 0F);
		GL11.glRotatef(ticks * 2.5F, 0F, 0F, 1F);
		GL11.glScalef(0.9F, 0.9F, 0.9F);
		opening = ticks / 12F;
		pageFlip = ClientTickHandler.pageFlipTicks / 5F;

		model.render(null, 0F, 0F, pageFlip, opening, 0F, 1F / 16F);
		if (ticks < 3) {
			FontRenderer font = Minecraft.getMinecraft().fontRenderer;
			GL11.glRotatef(180F, 0F, 0F, 0F);
			GL11.glTranslatef(-0.3F, -0.2F, 0.07F);
			GL11.glScalef(0.0035F, 0.0035F, 0.0035F);

			String title = MyItems.questBook.getItemStackDisplayName(null);
			String origTitle = title;

			if (Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem() != null)
				title = Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem().getDisplayName();

			font.drawString(font.trimStringToWidth(title, 80), 0, 0, 0xD69700);
			GL11.glTranslatef(0F, 10F, 0F);
			GL11.glScalef(0.6F, 0.6F, 0.6F);

			GL11.glTranslatef(0F, 15F, 0F);
			ItemStack stack = Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem() !=null?Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem():null;
			String line1 = stack!=null && stack.getTagCompound() != null ?stack.getTagCompound().getString("player"): "rpgo.creativespawn";
			font.drawString(StatCollector.translateToLocal(line1), 0, 0, 0x79ff92);

			GL11.glTranslatef(0F, 10F, 0F);
			font.drawString(EnumChatFormatting.UNDERLINE + StatCollector.translateToLocal("rpgo.questbook.cover.crafted"), 0, 0, 0x79ff92);

			GL11.glTranslatef(0F, 25F, 0F);
			GL11.glPushMatrix();
			GL11.glScalef(6F, 6F, 6F);
			GL11.glTranslatef(5F, -0.3F, 0F);
			font.drawString(EnumChatFormatting.BOLD + "~", 0, 0, 0x820000);
			GL11.glPopMatrix();

			GL11.glTranslatef(0F, 25F, 0F);
			font.drawString(StatCollector.translateToLocal("rpgo.questbook.cover.line3"), 0, 0, 0x79ff92);
			GL11.glTranslatef(0F, 10F, 0F);
			font.drawString(EnumChatFormatting.ITALIC + StatCollector.translateToLocal("rpgo.questbook.cover.line4"), 0, 0, 0x79ff92);
		}

		GL11.glPopMatrix();
	}

}
