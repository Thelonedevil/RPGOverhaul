
package com.github.thelonedevil.rpgoverhaul.gui.button;

import java.util.Arrays;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.github.thelonedevil.rpgoverhaul.gui.GuiQuestBook;
import com.github.thelonedevil.rpgoverhaul.gui.RenderHelper;

public class GuiButtonPage extends GuiButton {

	boolean right;

	public GuiButtonPage(int par1, int par2, int par3, boolean right) {
		super(par1, par2, par3, 18, 10, "");
		this.right = right;
	}

	@Override
	public void drawButton(Minecraft par1Minecraft, int par2, int par3) {
		if (enabled) {
			field_146123_n = par2 >= xPosition && par3 >= yPosition
					&& par2 < xPosition + width && par3 < yPosition + height;
			int k = getHoverState(field_146123_n);

			par1Minecraft.renderEngine.bindTexture(GuiQuestBook.texture);
			GL11.glColor4f(1F, 1F, 1F, 1F);
			drawTexturedModalRect(xPosition, yPosition, k == 2 ? 18 : 0,
					right ? 180 : 190, 18, 10);

			if (k == 2)
				RenderHelper
						.renderTooltip(
								par2,
								par3,
								Arrays.asList(StatCollector
										.translateToLocal(right ? "rpgo.nextPage"
												: "rpgo.prevPage")));
		}
	}

}
