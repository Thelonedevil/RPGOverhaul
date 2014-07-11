package com.github.thelonedevil.rpgoverhaul.quests;

import java.util.ArrayList;
import java.util.List;

public final class QuestBookCategory {

	public final String unlocalizedName;
	public final List<QuestBookEntry> entries = new ArrayList<QuestBookEntry>();

	/**
	 * @param unlocalizedName
	 *            The unlocalized name of this category. This will be localized
	 *            by the client display.
	 */
	public QuestBookCategory(String unlocalizedName) {
		this.unlocalizedName = unlocalizedName;
	}

	public String getUnlocalizedName() {
		return unlocalizedName;
	}
}
