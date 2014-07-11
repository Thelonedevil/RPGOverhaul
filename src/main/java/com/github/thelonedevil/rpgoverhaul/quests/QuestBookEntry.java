package com.github.thelonedevil.rpgoverhaul.quests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.util.StatCollector;

public class QuestBookEntry implements Comparable<QuestBookEntry> {

	public final String unlocalizedName;
	public final QuestBookCategory category;

	private KnowledgeType type = QuestBookAPI.firstKnowledge;

	public List<QuestBookPage> pages = new ArrayList<QuestBookPage>();
	private boolean priority = false;

	/**
	 * @param unlocalizedName
	 *            The unlocalized name of this entry. This will be localized by
	 *            the client display.
	 */
	public QuestBookEntry(String unlocalizedName, QuestBookCategory category) {
		this.unlocalizedName = unlocalizedName;
		this.category = category;
	}

	/**
	 * Sets this page as prioritized, as in, will appear before others in the
	 * lexicon.
	 */
	public QuestBookEntry setPriority() {
		priority = true;
		return this;
	}

	/**
	 * Sets the Knowledge type of this entry.
	 */
	public QuestBookEntry setKnowledgeType(KnowledgeType type) {
		this.type = type;
		return this;
	}

	public KnowledgeType getKnowledgeType() {
		return type;
	}

	public boolean isPriority() {
		return priority;
	}

	public String getUnlocalizedName() {
		return unlocalizedName;
	}

	/**
	 * Sets what pages you want this entry to have.
	 */
	public QuestBookEntry setQuestBookPages(QuestBookPage... pages) {
		this.pages.addAll(Arrays.asList(pages));

		for (int i = 0; i < this.pages.size(); i++)
			this.pages.get(i).onPageAdded(this, i);

		return this;
	}

	/**
	 * Adds a page to the list of pages.
	 */
	public void addPage(QuestBookPage page) {
		pages.add(page);
	}

	public final String getNameForSorting() {
		return (priority ? 0 : 1) + StatCollector.translateToLocal(getUnlocalizedName());
	}

	@Override
	public int compareTo(QuestBookEntry o) {
		return getNameForSorting().compareTo(o.getNameForSorting());
	}
}