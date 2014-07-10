
package com.github.thelonedevil.rpgoverhaul.quests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.util.EnumHelper;


import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public final class QuestBookAPI {

	private static List<QuestBookCategory> categories = new ArrayList<QuestBookCategory>();
	private static List<QuestBookEntry> allEntries = new ArrayList<QuestBookEntry>();

	public static Map<String, KnowledgeType> knowledgeTypes = new HashMap<String, KnowledgeType>();


	public static KnowledgeType basicKnowledge, elvenKnowledge;

	static {
		basicKnowledge = registerKnowledgeType("minecraft", EnumChatFormatting.RESET, true);
		elvenKnowledge = registerKnowledgeType("alfheim", EnumChatFormatting.DARK_GREEN, false);
	}


	/**
	 * Registers a new Knowledge Type.
	 * @param id The ID for this knowledge type.
	 * @param color The color to display this knowledge type as.
	 */
	public static KnowledgeType registerKnowledgeType(String id, EnumChatFormatting color, boolean autoUnlock) {
		KnowledgeType type = new KnowledgeType(id, color, autoUnlock);
		knowledgeTypes.put(id, type);
		return type;
	}






	/**
	 * Adds a category to the list of registered categories to appear in the QuestBook.
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
