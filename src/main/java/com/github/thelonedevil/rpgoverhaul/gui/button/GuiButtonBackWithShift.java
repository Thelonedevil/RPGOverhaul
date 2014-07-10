
package com.github.thelonedevil.rpgoverhaul.gui.button;

import java.util.Arrays;
import java.util.List;

import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class GuiButtonBackWithShift extends GuiButtonBack {

	public GuiButtonBackWithShift(int par1, int par2, int par3) {
		super(par1, par2, par3);
	}

	@Override
	public List<String> getTooltip() {
		return Arrays.asList(StatCollector.translateToLocal("botaniamisc.back"), EnumChatFormatting.GRAY + StatCollector.translateToLocal("botaniamisc.clickToIndex"));
	}

}
