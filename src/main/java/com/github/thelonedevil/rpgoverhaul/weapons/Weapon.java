package com.github.thelonedevil.rpgoverhaul.weapons;

import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import com.github.thelonedevil.rpgoverhaul.MyWeapons;
import com.github.thelonedevil.rpgoverhaul.RPGOMain;
import com.github.thelonedevil.rpgoverhaul.Ref;
import com.github.thelonedevil.rpgoverhaul.util.LogHelper;
import com.github.thelonedevil.rpgoverhaul.util.MetalUtil;
import com.github.thelonedevil.rpgoverhaul.util.WeaponUtil;
import com.github.thelonedevil.rpgoverhaul.weapons.swords.legendary.LegendarySword;

public class Weapon extends Item {

	int attackSpeed;
	WeaponType type;
	CrystalType crystal = CrystalType.NONE;

	public Weapon(WeaponType type, String name, int[] stats) {
		super();
		this.setUnlocalizedName(name);
		this.type = type;
		this.attackSpeed = stats[0];
		this.setCreativeTab(RPGOMain.WeaponTab).setMaxStackSize(1);


	}

	public void addCrystal(CrystalType newCrystal) {
		if (this.crystal.equals(CrystalType.NONE) && !newCrystal.equals(CrystalType.NONE)) {
			this.crystal = newCrystal;
		}
	}

	public CrystalType getCrystal() {
		return this.crystal;
	}

	public boolean removeCrystal() {
		if (!this.crystal.equals(CrystalType.NONE)) {
			this.crystal = CrystalType.NONE;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		if (GuiScreen.isShiftKeyDown()) {
			addStringToTooltip(StatCollector.translateToLocal(Ref.MODID + ".weapon." + type), par3List);
			addStringToTooltip(StatCollector.translateToLocal(Ref.MODID + ".crystal.info") + " " + StatCollector.translateToLocal("item.crystal_" + crystal.toString().toLowerCase() + ".name"),
					par3List);
			if (itemstack.getItem() instanceof LegendarySword) {
				addStringToTooltip(((LegendarySword) itemstack.getItem()).getLore(), par3List);
			}
		} else
			addStringToTooltip(StatCollector.translateToLocal(Ref.MODID + ".shiftinfo"), par3List);
	}

	private void addStringToTooltip(String s, List<String> tooltip) {
		tooltip.add(s.replaceAll("&", "\u00a7"));
	}

	public int getAttackSpeed() {
		return attackSpeed;
	}
	
    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.block;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 72000;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        p_77659_3_.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
        return p_77659_1_;
    }

}
