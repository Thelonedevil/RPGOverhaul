package com.github.thelonedevil.rpgoverhaul.weapons.swords.legendary;

import com.github.thelonedevil.rpgoverhaul.Ref;
import com.github.thelonedevil.rpgoverhaul.weapons.swords.Sword;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class LegendarySword extends Sword {
    String lore;

    public LegendarySword(String name, String lore, int[] stats) {
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
