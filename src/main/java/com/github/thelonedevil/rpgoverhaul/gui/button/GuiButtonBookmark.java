package com.github.thelonedevil.rpgoverhaul.gui.button;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import com.github.thelonedevil.rpgoverhaul.gui.GuiQuestBook;
import com.github.thelonedevil.rpgoverhaul.gui.RenderHelper;

public class GuiButtonBookmark extends GuiButton {

	GuiQuestBook gui = new GuiQuestBook();

	public GuiButtonBookmark(int par1, int par2, int par3, GuiQuestBook gui, String str) {
		super(par1, par2, par3, gui.bookmarkWidth(str) + 5, 11, str);
	}

	@Override
	public void drawButton(Minecraft mc, int par2, int par3) {
		gui.drawBookmark(xPosition, yPosition, displayString, false);
		field_146123_n = par2 >= xPosition && par3 >= yPosition && par2 < xPosition + width && par3 < yPosition + height;
		int k = getHoverState(field_146123_n);

		List<String> tooltip = new ArrayList();
		if(displayString.equals("+"))
			tooltip.add(StatCollector.translateToLocal("botaniamisc.clickToAdd"));
		else {
			tooltip.add(String.format(StatCollector.translateToLocal("botaniamisc.bookmark"), id - GuiQuestBook.BOOKMARK_START + 1));
			tooltip.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("botaniamisc.clickToSee"));
			tooltip.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("botaniamisc.shiftToRemove"));
		}

		int tooltipY = (tooltip.size() + 1) * 5;
		if(k == 2)
			RenderHelper.renderTooltip(par2, par3 + tooltipY, tooltip);
	}

}
