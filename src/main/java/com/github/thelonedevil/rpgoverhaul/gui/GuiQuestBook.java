package com.github.thelonedevil.rpgoverhaul.gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.github.thelonedevil.rpgoverhaul.Ref;
import com.github.thelonedevil.rpgoverhaul.gui.button.GuiButtonBookmark;
import com.github.thelonedevil.rpgoverhaul.gui.button.GuiButtonInvisible;
import com.github.thelonedevil.rpgoverhaul.handlers.ClientTickHandler;
import com.github.thelonedevil.rpgoverhaul.quests.IParented;
import com.github.thelonedevil.rpgoverhaul.quests.QuestBookAPI;
import com.github.thelonedevil.rpgoverhaul.quests.QuestBookCategory;

public class GuiQuestBook extends GuiScreen {

	public static GuiQuestBook currentOpenQuestBook = new GuiQuestBook();
	public static ItemStack stackUsed;

	public static final int BOOKMARK_START = 1337;
	public static List<GuiQuestBook> bookmarks = new ArrayList();
	boolean bookmarksNeedPopulation = false;

	public static final ResourceLocation texture = new ResourceLocation(Ref.MODID + ":textures/gui/questbook.png");

	String title;
	int guiWidth = 146;
	int guiHeight = 180;
	int left, top;

	@Override
	public void initGui() {
		super.initGui();
		if(Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem() != null){
		title = Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem().getDisplayName();
		}else{
			title = StatCollector.translateToLocal("item.questbook.name");
		}
		
		currentOpenQuestBook = this;

		left = width / 2 - guiWidth / 2;
		top = height / 2 - guiHeight / 2;

		buttonList.clear();
		if (isIndex()) {
			int x = 18;
			for (int i = 0; i < 12; i++) {
				int y = 16 + i * 12;
				buttonList.add(new GuiButtonInvisible(i, left + x, top + y, 110, 10, ""));
			}
			populateIndex();
		}
		populateBookmarks();
	}

	@Override
	public void drawScreen(int par1, int par2, float par3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		mc.renderEngine.bindTexture(texture);
		drawTexturedModalRect(left, top, 0, 0, guiWidth, guiHeight);
		drawBookmark(left + guiWidth / 2, top - getTitleHeight(), getTitle(), true);
		String subtitle = getSubtitle();
		if (subtitle != null) {
			GL11.glScalef(0.5F, 0.5F, 1F);
			drawCenteredString(fontRendererObj, subtitle, left * 2 + guiWidth, (top - getTitleHeight() + 11) * 2, 0x00FF00);
			GL11.glScalef(2F, 2F, 1F);
		}

		drawHeader();

		if (bookmarksNeedPopulation) {
			populateBookmarks();
			bookmarksNeedPopulation = false;
		}

		super.drawScreen(par1, par2, par3);
	}

	public void drawBookmark(int x, int y, String s, boolean drawLeft) {
		// This function is called from the buttons so I can't use
		// fontRendererObj
		FontRenderer font = Minecraft.getMinecraft().fontRenderer;
		boolean unicode = font.getUnicodeFlag();
		font.setUnicodeFlag(true);
		int l = font.getStringWidth(s.trim());
		int fontOff = 0;

		if (!drawLeft) {
			x += l / 2;
			fontOff = 2;
		}

		Minecraft.getMinecraft().renderEngine.bindTexture(texture);

		GL11.glColor4f(1F, 1F, 1F, 1F);
		drawTexturedModalRect(x + l / 2 + 3, y - 1, 54, 180, 6, 11);
		if (drawLeft)
			drawTexturedModalRect(x - l / 2 - 9, y - 1, 61, 180, 6, 11);
		for (int i = 0; i < l + 6; i++)
			drawTexturedModalRect(x - l / 2 - 3 + i, y - 1, 60, 180, 1, 11);

		font.drawString(s, x - l / 2 + fontOff, y, 0xffffff, false);
		font.setUnicodeFlag(unicode);
	}

	void drawHeader() {
		boolean unicode = fontRendererObj.getUnicodeFlag();
		fontRendererObj.setUnicodeFlag(true);
		fontRendererObj.drawSplitString(String.format(StatCollector.translateToLocal("rpgo.questbook")), left + 18, top + 14, 110, 0);
		fontRendererObj.setUnicodeFlag(unicode);
	}

	@Override
	protected void actionPerformed(GuiButton par1GuiButton) {
		if (par1GuiButton.id >= BOOKMARK_START)
			handleBookmark(par1GuiButton);
		else {
			int i = par1GuiButton.id - 3;
			if (i < 0)
				return;

			List<QuestBookCategory> categoryList = QuestBookAPI.getAllCategories();
			QuestBookCategory category = i >= categoryList.size() ? null : categoryList.get(i);

			if (category != null) {
				mc.displayGuiScreen(new GuiQuestBookIndex(category));
				ClientTickHandler.notifyPageChange();
			}
		}
	}

	public void handleBookmark(GuiButton par1GuiButton) {
		int i = par1GuiButton.id - BOOKMARK_START;
		if (i == bookmarks.size()) {
			if (!bookmarks.contains(this))
				bookmarks.add(this);
		} else {
			if (isShiftKeyDown())
				bookmarks.remove(i);
			else {
				GuiQuestBook bookmark = bookmarks.get(i);
				Minecraft.getMinecraft().displayGuiScreen(bookmark);
				if (!bookmark.getTitle().equals(getTitle())) {
					if (bookmark instanceof IParented)
						((IParented) bookmark).setParent(this);
					ClientTickHandler.notifyPageChange();
				}
			}
		}

		bookmarksNeedPopulation = true;
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	public int bookmarkWidth(String b) {
		boolean unicode = fontRendererObj.getUnicodeFlag();
		fontRendererObj.setUnicodeFlag(true);
		int width = fontRendererObj.getStringWidth(b) + 15;
		fontRendererObj.setUnicodeFlag(unicode);
		return width;
	}

	String getTitle() {
		return title;
	}

	String getSubtitle() {
		return null;
	}

	int getTitleHeight() {
		return getSubtitle() == null ? 12 : 16;
	}

	boolean isIndex() {
		return true;
	}

	void populateIndex() {
		List<QuestBookCategory> categoryList = QuestBookAPI.getAllCategories();
		for (int i = 3; i < 12; i++) {
			int i_ = i - 3;
			GuiButtonInvisible button = (GuiButtonInvisible) buttonList.get(i);
			QuestBookCategory category = i_ >= categoryList.size() ? null : categoryList.get(i_);
			if (category != null)
				button.displayString = StatCollector.translateToLocal(category.getUnlocalizedName());
			else
				button.displayString = "";
		}
	}

	void populateBookmarks() {
		List remove = new ArrayList();
		List<GuiButton> buttons = buttonList;
		for (GuiButton button : buttons)
			if (button.id >= BOOKMARK_START)
				remove.add(button);
		buttonList.removeAll(remove);

		int len = bookmarks.size();
		boolean thisExists = false;
		for (GuiQuestBook lex : bookmarks)
			if (lex.getTitle().equals(getTitle()))
				thisExists = true;

		boolean addEnabled = len < 10 && this instanceof IParented && !thisExists;
		for (int i = 0; i < len + (addEnabled ? 1 : 0); i++) {
			boolean isAdd = i == bookmarks.size();
			GuiQuestBook gui = isAdd ? null : bookmarks.get(i);
			buttonList.add(new GuiButtonBookmark(BOOKMARK_START + i, left + 138, top + 18 + 14 * i, gui == null ? this : gui, gui == null ? "+" : gui.getTitle()));
		}
	}

	@Override
	protected void keyTyped(char par1, int par2) {
		if (mc.gameSettings.keyBindInventory.getKeyCode() == par2) {
			mc.displayGuiScreen(null);
			mc.setIngameFocus();
		}

		super.keyTyped(par1, par2);
	}

}
