package com.github.thelonedevil.rpgoverhaul.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import org.lwjgl.input.Mouse;

import com.github.thelonedevil.rpgoverhaul.gui.button.GuiButtonBackWithShift;
import com.github.thelonedevil.rpgoverhaul.gui.button.GuiButtonPage;
import com.github.thelonedevil.rpgoverhaul.handlers.ClientTickHandler;
import com.github.thelonedevil.rpgoverhaul.quests.IParented;
import com.github.thelonedevil.rpgoverhaul.quests.QuestBookEntry;
import com.github.thelonedevil.rpgoverhaul.quests.QuestBookPage;

public class GuiQuestBookEntry extends GuiQuestBook implements IGuiQuestBookEntry, IParented {

	public int page = 0;
	QuestBookEntry entry;
	GuiScreen parent;
	String title;
	String subtitle;

	GuiButton leftButton, rightButton, backButton;

	public GuiQuestBookEntry(QuestBookEntry entry, GuiScreen parent) {
		this.entry = entry;
		this.parent = parent;

		title = StatCollector.translateToLocal(entry.getUnlocalizedName());
	}

	@SuppressWarnings("unchecked")
    @Override
	public void initGui() {
		super.initGui();

		buttonList.add(backButton = new GuiButtonBackWithShift(0, left + guiWidth / 2 - 8, top + guiHeight + 2));
		buttonList.add(leftButton = new GuiButtonPage(1, left, top + guiHeight - 10, false));
		buttonList.add(rightButton = new GuiButtonPage(2, left + guiWidth - 18, top + guiHeight - 10, true));

		updatePageButtons();
	}

	@Override
	public QuestBookEntry getEntry() {
		return entry;
	}

	@Override
	public int getPageOn() {
		return page;
	}

	@Override
	boolean isIndex() {
		return false;
	}

	@Override
	void drawHeader() {
		// NO-OP
	}

	@Override
	String getTitle() {
		return String.format("%s " + EnumChatFormatting.ITALIC + "(%s/%s)", title, page + 1, entry.pages.size());
	}

	@Override
	String getSubtitle() {
		return subtitle;
	}

	@Override
	protected void actionPerformed(GuiButton par1GuiButton) {
		if (par1GuiButton.id >= BOOKMARK_START)
			handleBookmark(par1GuiButton);
		else
			switch (par1GuiButton.id) {
			case 0:
				mc.displayGuiScreen(GuiScreen.isShiftKeyDown() ? new GuiQuestBook() : parent);
				ClientTickHandler.notifyPageChange();
				break;
			case 1:
				page--;
				ClientTickHandler.notifyPageChange();
				break;
			case 2:
				page++;
				ClientTickHandler.notifyPageChange();
				break;
			}
		updatePageButtons();
	}

	public void updatePageButtons() {
		leftButton.enabled = page != 0;
		rightButton.enabled = page + 1 < entry.pages.size();
	}

	@Override
	public void drawScreen(int par1, int par2, float par3) {
		super.drawScreen(par1, par2, par3);

		QuestBookPage page = entry.pages.get(this.page);
		page.renderScreen(this, par1, par2);
	}

	@Override
	public void updateScreen() {
		QuestBookPage page = entry.pages.get(this.page);
		page.updateScreen();
	}

	@Override
	public int getLeft() {
		return left;
	}

	@Override
	public int getTop() {
		return top;
	}

	@Override
	public int getWidth() {
		return guiWidth;
	}

	@Override
	public int getHeight() {
		return guiHeight;
	}

	@Override
	public float getZLevel() {
		return zLevel;
	}

	@Override
	public void setParent(GuiQuestBook gui) {
		parent = gui;
	}

	int fx = 0;
	boolean swiped = false;

	@Override
	protected void mouseClickMove(int x, int y, int button, long time) {
		if (button == 0 && Math.abs(x - fx) > 100 && mc.gameSettings.touchscreen && !swiped) {
			double swipe = (x - fx) / Math.max(1, (double) time);
			if (swipe < 0.5) {
				nextPage();
				swiped = true;
			} else if (swipe > 0.5) {
				prevPage();
				swiped = true;
			}
		}
	}

	@Override
	protected void mouseClicked(int par1, int par2, int par3) {
		super.mouseClicked(par1, par2, par3);

		fx = par1;
		if (par3 == 1)
			back();
	}

	@Override
	public void handleMouseInput() {
		super.handleMouseInput();

		if (Mouse.getEventButton() == 0)
			swiped = false;

		int w = Mouse.getEventDWheel();
		if (w < 0)
			nextPage();
		else if (w > 0)
			prevPage();
	}

	@Override
	protected void keyTyped(char par1, int par2) {
		if (par2 == 203 || par2 == 200 || par2 == 201) // Left, Up, Page Up
			prevPage();
		else if (par2 == 205 || par2 == 208 || par2 == 209) // Right, Down Page
															// Down
			nextPage();
		else if (par2 == 14) // Backspace
			back();
		else if (par2 == 199) { // Home
			mc.displayGuiScreen(new GuiQuestBook());
			ClientTickHandler.notifyPageChange();
		}

		super.keyTyped(par1, par2);
	}

	void back() {
		if (backButton.enabled)
			actionPerformed(backButton);
	}

	void nextPage() {
		if (rightButton.enabled)
			actionPerformed(rightButton);
	}

	void prevPage() {
		if (leftButton.enabled)
			actionPerformed(leftButton);
	}
}
