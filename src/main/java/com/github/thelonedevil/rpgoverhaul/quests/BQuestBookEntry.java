package com.github.thelonedevil.rpgoverhaul.quests;

public class BQuestBookEntry extends QuestBookEntry {

	public BQuestBookEntry(String unlocalizedName, QuestBookCategory category) {
		super(unlocalizedName, category);
		QuestBookAPI.addEntry(this, category);
	}

	@Override
	public QuestBookEntry setQuestBookPages(QuestBookPage... pages) {
		for (QuestBookPage page : pages)
			page.unlocalizedName = "botania.page." + getLazyUnlocalizedName()
					+ page.unlocalizedName;

		return super.setQuestBookPages(pages);
	}

	@Override
	public String getUnlocalizedName() {
		return "botania.entry." + super.getUnlocalizedName();
	}

	public String getLazyUnlocalizedName() {
		return super.getUnlocalizedName();
	}

}
