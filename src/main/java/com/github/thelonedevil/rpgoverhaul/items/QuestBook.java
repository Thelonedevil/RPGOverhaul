package com.github.thelonedevil.rpgoverhaul.items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import com.github.thelonedevil.rpgoverhaul.RPGOMain;
import com.github.thelonedevil.rpgoverhaul.Ref;
import com.github.thelonedevil.rpgoverhaul.quests.IQuestBook;
import com.github.thelonedevil.rpgoverhaul.quests.KnowledgeType;
import com.github.thelonedevil.rpgoverhaul.quests.QuestBookAPI;

public class QuestBook extends Item implements IQuestBook {

	private static final String TAG_KNOWLEDGE_PREFIX = "knowledge.";
	private static final String TAG_FORCED_MESSAGE = "forcedMessage";

	public QuestBook() {
		super();
		setMaxStackSize(1);
		setUnlocalizedName("questbook");
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		list.add(new ItemStack(item));
		ItemStack creative = new ItemStack(item);
		for(String s : QuestBookAPI.knowledgeTypes.keySet()) {
			KnowledgeType type = QuestBookAPI.knowledgeTypes.get(s);
			unlockKnowledge(creative, type);
		}
		list.add(creative);
	}

	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		if(GuiScreen.isShiftKeyDown()) {
			String edition = EnumChatFormatting.GOLD + String.format(StatCollector.translateToLocal("botaniamisc.edition"));
			if(!edition.isEmpty())
				par3List.add(edition);

			List<KnowledgeType> typesKnown = new ArrayList();
			for(String s : QuestBookAPI.knowledgeTypes.keySet()) {
				KnowledgeType type = QuestBookAPI.knowledgeTypes.get(s);
				if(isKnowledgeUnlocked(par1ItemStack, type))
					typesKnown.add(type);
			}

			for(KnowledgeType type : typesKnown)
				addStringToTooltip(" \u2022 " + StatCollector.translateToLocal(type.getUnlocalizedName()), par3List);

		} else addStringToTooltip(StatCollector.translateToLocal("rpgo.shiftinfo"), par3List);
	}

	private void addStringToTooltip(String s, List<String> tooltip) {
		tooltip.add(s.replaceAll("&", "\u00a7"));
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		
		par3EntityPlayer.openGui(RPGOMain.instance, Ref.QUESTBOOK_GUI, par2World, 0, 0, 0);
		return par1ItemStack;
	}

	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.uncommon;
	}

	@Override
	public boolean isKnowledgeUnlocked(ItemStack stack, KnowledgeType knowledge) {
		return knowledge.autoUnlock;
	}

	@Override
	public void unlockKnowledge(ItemStack stack, KnowledgeType knowledge) {
		
	}

	public static void forceMessage(ItemStack stack, boolean forced) {
		
	}

	public static boolean isMessageForced(ItemStack stack) {
		return false;
		
	}



}
