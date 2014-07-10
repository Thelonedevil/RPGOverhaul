package com.github.thelonedevil.rpgoverhaul.quests;

import com.github.thelonedevil.rpgoverhaul.quests.pages.PageText;

public final class QuestBookData {
	
	public static QuestBookCategory categoryStarter;
	public static QuestBookEntry quest1;
	public static void init() {
		QuestBookAPI.addCategory(categoryStarter = new QuestBookCategory("rpgo.category.starter"));
		quest1 = new BQuestBookEntry("quest1",categoryStarter);
		quest1.setPriority().setQuestBookPages(new PageText("0"));
	}

}
