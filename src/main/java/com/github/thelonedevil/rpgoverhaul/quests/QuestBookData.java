package com.github.thelonedevil.rpgoverhaul.quests;

import java.util.ArrayList;
import java.util.List;

import com.github.thelonedevil.rpgoverhaul.quests.pages.PageText;

public final class QuestBookData {
	
	public static QuestBookCategory categoryStarter;
	public static QuestBookEntry quest1;
	public static QuestBookEntry quest2;
	public static List<QuestBookEntry> quests = new ArrayList<QuestBookEntry>();
	public static void init() {
		QuestBookAPI.addCategory(categoryStarter = new QuestBookCategory("rpgo.category.starter"));
		quests.add(new BQuestBookEntry("quest1",categoryStarter).setPriority().setQuestBookPages(new PageText(".0"),new PageText(".1")));
		quests.add(new BQuestBookEntry("quest2",categoryStarter).setPriority().setQuestBookPages(new PageText(".0"),new PageText(".1")));
	}
	
	public static void addQuest(String questName,QuestBookCategory cat){
		quests.add(new BQuestBookEntry(questName,cat).setPriority().setQuestBookPages(new PageText(".0"),new PageText(".1")));

	}

}
