
package com.github.thelonedevil.rpgoverhaul.quests;


import com.github.thelonedevil.rpgoverhaul.gui.IGuiQuestBookEntry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class QuestBookPage {

	public String unlocalizedName;

	public QuestBookPage(String unlocalizedName) {
		this.unlocalizedName = unlocalizedName;
	}

	/**
	 * Does the rendering for this page.
	 * @param gui The active GuiScreen
	 * @param mx The mouse's relative X position.
	 * @param my The mouse's relative Y position.
	 */
	@SideOnly(Side.CLIENT)
	public abstract void renderScreen(IGuiQuestBookEntry gui, int mx, int my);

	/**
	 * Called per update tick.
	 */
	@SideOnly(Side.CLIENT)
	public void updateScreen() {
		// NO-OP
	}

	/**
	 * Called when {@link QuestBookEntry#setQuestBookPages(QuestBookPage...)} is called.
	 */
	public void onPageAdded(QuestBookEntry entry, int index) {
		// NO-OP
	}

	public String getUnlocalizedName() {
		return unlocalizedName;
	}
}
