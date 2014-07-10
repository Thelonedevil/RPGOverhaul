package com.github.thelonedevil.rpgoverhaul.quests;

import net.minecraft.item.ItemStack;

/**
 * Basic interface for the QuestBook.
 */
public interface IQuestBook {

	/**
	 * Gets if a specific knowledge is unlocked. Check the knowledge types in
	 * BotaniaAPI.
	 */
	public boolean isKnowledgeUnlocked(ItemStack stack, KnowledgeType knowledge);

	/**
	 * Unlocks a specfic type of knowledge.
	 */
	public void unlockKnowledge(ItemStack stack, KnowledgeType knowledge);

}
