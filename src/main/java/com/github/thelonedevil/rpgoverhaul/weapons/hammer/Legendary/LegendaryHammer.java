package com.github.thelonedevil.rpgoverhaul.weapons.hammer.Legendary;

import com.github.thelonedevil.rpgoverhaul.Ref;
import com.github.thelonedevil.rpgoverhaul.weapons.hammer.Hammer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

/**
 * Created by justin on 26/07/2014.
 */
public class LegendaryHammer extends Hammer {
    String lore;

    public LegendaryHammer(String name, String lore, int[] stats) {
        super(name, stats);
        this.lore = lore;
        this.setTextureName(Ref.MODID + ":" + name);
    }

    public String getLore() {
        return lore;
    }

    @Override
    public EnumRarity getRarity(ItemStack par1ItemStack) {
        return EnumRarity.epic;

    }
}
