
package com.github.thelonedevil.rpgoverhaul.gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import org.lwjgl.input.Mouse;

import com.github.thelonedevil.rpgoverhaul.gui.button.GuiButtonBack;
import com.github.thelonedevil.rpgoverhaul.gui.button.GuiButtonInvisible;
import com.github.thelonedevil.rpgoverhaul.gui.button.GuiButtonPage;
import com.github.thelonedevil.rpgoverhaul.handlers.ClientTickHandler;
import com.github.thelonedevil.rpgoverhaul.quests.IParented;
import com.github.thelonedevil.rpgoverhaul.quests.IQuestBook;
import com.github.thelonedevil.rpgoverhaul.quests.QuestBookCategory;
import com.github.thelonedevil.rpgoverhaul.quests.QuestBookEntry;

public class GuiQuestBookIndex extends GuiQuestBook implements IParented {

	QuestBookCategory category;
	String title;
	int page = 0;

	GuiButton leftButton, rightButton, backButton;
	GuiQuestBook parent;

	List<QuestBookEntry> entriesToDisplay = new ArrayList();

	public GuiQuestBookIndex(QuestBookCategory category) {
		this.category = category;
		title = StatCollector.translateToLocal(category.getUnlocalizedName());
		parent = new GuiQuestBook();
	}

	@Override
	void drawHeader() {
		// NO-OP
	}

	@Override
	String getTitle() {
		return title;
	}

	@Override
	public void initGui() {
		super.initGui();
		buttonList.add(backButton = new GuiButtonBack(12, left + guiWidth / 2 - 8, top + guiHeight + 2));
		buttonList.add(leftButton = new GuiButtonPage(13, left, top + guiHeight - 10, false));
		buttonList.add(rightButton = new GuiButtonPage(14, left + guiWidth - 18, top + guiHeight - 10, true));

		entriesToDisplay.clear();
		IQuestBook lex = (IQuestBook) stackUsed.getItem();
		for(QuestBookEntry entry : category.entries) {
			if(lex.isKnowledgeUnlocked(stackUsed, entry.getKnowledgeType()))
				entriesToDisplay.add(entry);
		}
		Collections.sort(entriesToDisplay);

		updatePageButtons();
		populateIndex();
	}

	@Override
	void populateIndex() {
		for(int i = page * 12; i < (page + 1) * 12; i++) {
			GuiButtonInvisible button = (GuiButtonInvisible) buttonList.get(i - page * 12);
			QuestBookEntry entry = i >= entriesToDisplay.size() ? null : entriesToDisplay.get(i);
			if(entry != null)
				button.displayString = entry.getKnowledgeType().color + "" + (entry.isPriority() ? EnumChatFormatting.ITALIC : "") + StatCollector.translateToLocal(entry.getUnlocalizedName());
			else button.displayString = "";
		}
	}

	@Override
	protected void actionPerformed(GuiButton par1GuiButton) {
		if(par1GuiButton.id >= BOOKMARK_START)
			handleBookmark(par1GuiButton);
		else
			switch(par1GuiButton.id) {
			case 12 :
				mc.displayGuiScreen(parent);
				ClientTickHandler.notifyPageChange();
				break;
			case 13 :
				page--;
				updatePageButtons();
				populateIndex();
				ClientTickHandler.notifyPageChange();
				break;
			case 14 :
				page++;
				updatePageButtons();
				populateIndex();
				ClientTickHandler.notifyPageChange();
				break;
			default :
				int index = par1GuiButton.id + page * 12;
				if(index >= entriesToDisplay.size())
					return;

				QuestBookEntry entry = entriesToDisplay.get(index);
				mc.displayGuiScreen(new GuiQuestBookEntry(entry, this));
				ClientTickHandler.notifyPageChange();
			}
	}

	public void updatePageButtons() {
		leftButton.enabled = page != 0;
		rightButton.enabled = page < (entriesToDisplay.size() - 1) / 12;
	}

	@Override
	public void setParent(GuiQuestBook gui) {
		parent = gui;
	}

	int fx = 0;
	boolean swiped = false;

	@Override
	protected void mouseClickMove(int x, int y, int button, long time) {
		if(button == 0 && Math.abs(x - fx) > 100 && mc.gameSettings.touchscreen && !swiped) {
			double swipe = (x - fx) / Math.max(1, (double) time);
			if(swipe < 0.5) {
				nextPage();
				swiped = true;
			} else if(swipe > 0.5) {
				prevPage();
				swiped = true;
			}
		}
	}

	@Override
	protected void mouseClicked(int par1, int par2, int par3) {
		super.mouseClicked(par1, par2, par3);

		fx = par1;
		if(par3 == 1)
			back();
	}

	@Override
	public void handleMouseInput() {
		super.handleMouseInput();

		if(Mouse.getEventButton() == 0)
			swiped = false;

		int w = Mouse.getEventDWheel();
		if(w < 0)
			nextPage();
		else if(w > 0)
			prevPage();
	}

	@Override
	protected void keyTyped(char par1, int par2) {
		if(par2 == 203 || par2 == 200 || par2 == 201) // Left, Up, Page Up
			prevPage();
		else if(par2 == 205 || par2 == 208 || par2 == 209) // Right, Down Page Down
			nextPage();
		else if(par2 == 14) // Backspace
			back();
		else if(par2 == 199) { // Home
			mc.displayGuiScreen(new GuiQuestBook());
			ClientTickHandler.notifyPageChange();
		}

		super.keyTyped(par1, par2);
	}

	void back() {
		if(backButton.enabled)
			actionPerformed(backButton);
	}

	void nextPage() {
		if(rightButton.enabled)
			actionPerformed(rightButton);
	}

	void prevPage() {
		if(leftButton.enabled)
			actionPerformed(leftButton);
	}
}
