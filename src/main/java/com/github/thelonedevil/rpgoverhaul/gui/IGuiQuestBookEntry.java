
package com.github.thelonedevil.rpgoverhaul.gui;

import com.github.thelonedevil.rpgoverhaul.quests.QuestBookEntry;

/**
 * Internal interface for the QuestBook Entry GUI. This contains
 * everything that can be accessed from it. It's safe to cast
 * this type to GuiScreen.
 */
public interface IGuiQuestBookEntry {

	/**
	 * Gets the entry currently portrayed in this gui.
	 */
	public QuestBookEntry getEntry();

	/**
	 * Gets the current page the lexicon GUI is browsing.
	 */
	public int getPageOn();

	/**
	 * Gets the leftmost part of the GUI.
	 */
	public int getLeft();

	/**
	 * Gets the topmost part of the GUI.
	 */
	public int getTop();

	/**
	 * Gets the GUI's width.
	 */
	public int getWidth();

	/**
	 * Gets the GUI's height
	 */
	public int getHeight();

	/**
	 * Gets the GUI's Z level for rendering.
	 */
	public float getZLevel();
}
