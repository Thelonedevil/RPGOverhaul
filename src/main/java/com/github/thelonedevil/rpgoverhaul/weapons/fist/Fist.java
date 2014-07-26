package com.github.thelonedevil.rpgoverhaul.weapons.fist;

import com.github.thelonedevil.rpgoverhaul.weapons.Weapon;
import com.github.thelonedevil.rpgoverhaul.weapons.WeaponType;
import com.github.thelonedevil.rpgoverhaul.weapons.fist.legendary.LegendaryFist;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.util.List;

public class Fist extends Weapon {

	public Fist(String name, int[] stats) {
		super(WeaponType.FIST, name, stats);
		// TODO Auto-generated constructor stub
	}
    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        super.addInformation(itemstack, par2EntityPlayer, par3List, par4);
        if (itemstack.getTagCompound() != null) {
            if (itemstack.getItem() instanceof LegendaryFist) {
            }else{
                String s = itemstack.getTagCompound().getString("bottom");
                String s1 = itemstack.getTagCompound().getString("blade");
                String s2 = "Made from " + s + " and " + s1;
                addStringToTooltip(StatCollector.translateToLocal(s2), par3List);
            }
            String s3 = "&9+" + itemstack.getTagCompound().getInteger("damage") + " Attack Damage";
            addStringToTooltip(StatCollector.translateToLocal(s3), par3List);
        }
    }

    private void addStringToTooltip(String s, List<String> tooltip) {
        tooltip.add(s.replaceAll("&", "\u00a7"));
    }

}
