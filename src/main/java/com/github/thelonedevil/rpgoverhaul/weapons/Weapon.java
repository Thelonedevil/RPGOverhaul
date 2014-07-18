package com.github.thelonedevil.rpgoverhaul.weapons;

import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import com.github.thelonedevil.rpgoverhaul.RPGOMain;
import com.github.thelonedevil.rpgoverhaul.Ref;
import com.github.thelonedevil.rpgoverhaul.weapons.swords.LegendarySword;

public class Weapon extends Item {
	int attackDamage;
	int attackSpeed;
	WeaponType type;
	CrystalType crystal = CrystalType.NONE;

	public Weapon(WeaponType type, String name, int[] stats) {
		super();
		this.setUnlocalizedName(name);
		this.type = type;
		this.attackDamage = stats[0];
		this.attackSpeed = stats[1];
		this.setCreativeTab(RPGOMain.myTab).setMaxStackSize(1);

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

	public int getAttackDamage() {
		return attackDamage;
	}

	public int getAttackSpeed() {
		return attackSpeed;
	}

}
