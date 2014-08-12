package com.github.thelonedevil.rpgoverhaul.quests.pages;

import com.github.thelonedevil.rpgoverhaul.gui.IGuiQuestBookEntry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

/**
 * Created by justin on 31/07/2014.
 */
public class PageQuest extends PageText {
    public PageQuest(String unlocalizedName) {
        super(unlocalizedName);
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void renderScreen(IGuiQuestBookEntry gui, int mx, int my) {
        int width = gui.getWidth() - 34;
        int x = gui.getLeft() + 16;
        int y = gui.getTop() + 2;

        renderText(x, y, width, gui.getHeight(), getUnlocalizedName());
    }

    @SideOnly(Side.CLIENT)
    public static void renderButton(int x, int y, int width, int height, String unlocalizedText, IGuiQuestBookEntry entry) {
    }
}
