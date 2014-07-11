package com.github.thelonedevil.rpgoverhaul.quests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.util.EnumChatFormatting;

public final class QuestBookAPI {

	private static List<QuestBookCategory> categories = new ArrayList<QuestBookCategory>();
	private static List<QuestBookEntry> allEntries = new ArrayList<QuestBookEntry>();

	public static Map<String, KnowledgeType> knowledgeTypes = new HashMap<String, KnowledgeType>();

	public static KnowledgeType firstKnowledge, secondKnowledge;

	static {
		firstKnowledge = registerKnowledgeType("first", EnumChatFormatting.RESET, true);
		secondKnowledge = registerKnowledgeType("second", EnumChatFormatting.RESET, false);
	}

	/**
	 * Registers a new Knowledge Type.
	 * 
	 * @param id
	 *            The ID for this knowledge type.
	 * @param color
	 *            The color to display this knowledge type as.
	 */
	public static KnowledgeType registerKnowledgeType(String id, EnumChatFormatting color, boolean autoUnlock) {
		KnowledgeType type = new KnowledgeType(id, color, autoUnlock);
		knowledgeTypes.put(id, type);
		return type;
	}

	/**
	 * Adds a category to the list of registered categories to appear in the
	 * QuestBook.
	 */
	public static void addCategory(QuestBookCategory category) {
		categories.add(category);
	}

	/**
	 * Gets all registered categories.
	 */
	public static List<QuestBookCategory> getAllCategories() {
		return categories;
	}

	/**
	 * Registers a QuestBook Entry and adds it to the category passed in.
	 */
	public static void addEntry(QuestBookEntry entry, QuestBookCategory category) {
		allEntries.add(entry);
		category.entries.add(entry);
	}

}
