package com.github.thelonedevil.rpgoverhaul.weapons.swords.legendary;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.List;

public class Zangetsu extends LegendarySword {

    public Zangetsu() {
        super("Zangetsu", "The Slaying Moon", new int[]{20, 4});
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        ItemStack stack = new ItemStack(item);
        NBTTagCompound tag = new NBTTagCompound();
        tag.setInteger("damage", 40);
        stack.setTagCompound(tag);
        list.add(stack);
    }

}
