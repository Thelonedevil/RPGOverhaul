package com.github.thelonedevil.rpgoverhaul.weapons.hammer;

import com.github.thelonedevil.rpgoverhaul.weapons.Weapon;
import com.github.thelonedevil.rpgoverhaul.weapons.WeaponType;
import com.github.thelonedevil.rpgoverhaul.weapons.hammer.Legendary.LegendaryHammer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.util.List;

/**
 * Created by justin on 26/07/2014.
 */
public class Hammer extends Weapon {

    public Hammer(String name, int[] stats) {
        super(WeaponType.FIST, name, stats);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        super.addInformation(itemstack, par2EntityPlayer, par3List, par4);
        if (itemstack.getTagCompound() != null) {
            if (itemstack.getItem() instanceof LegendaryHammer) {
            }else{
               //TODO add display information for materials used
            }
            String s3 = "&9+" + itemstack.getTagCompound().getInteger("damage") + " Attack Damage";
            addStringToTooltip(StatCollector.translateToLocal(s3), par3List);
        }
    }

    private void addStringToTooltip(String s, List<String> tooltip) {
        tooltip.add(s.replaceAll("&", "\u00a7"));
    }
}
