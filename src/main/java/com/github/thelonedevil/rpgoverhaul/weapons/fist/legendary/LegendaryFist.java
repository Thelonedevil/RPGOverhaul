package com.github.thelonedevil.rpgoverhaul.weapons.fist.legendary;

import com.github.thelonedevil.rpgoverhaul.Ref;
import com.github.thelonedevil.rpgoverhaul.weapons.fist.Fist;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

/**
 * Created by justin on 26/07/2014.
 */
public class LegendaryFist extends Fist{
    String lore;

    public LegendaryFist(String name, String lore, int[] stats) {
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
