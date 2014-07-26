package com.github.thelonedevil.rpgoverhaul;

import com.github.thelonedevil.rpgoverhaul.weapons.scythes.Scythe;
import net.minecraft.item.Item;

import com.github.thelonedevil.rpgoverhaul.util.WeaponUtil;
import com.github.thelonedevil.rpgoverhaul.weapons.fist.Fist;
import com.github.thelonedevil.rpgoverhaul.weapons.swords.Sword;
import com.github.thelonedevil.rpgoverhaul.weapons.swords.legendary.Zangetsu;

import cpw.mods.fml.common.registry.GameRegistry;

public class MyWeapons {
	public static Item broadSword;
	public static Item longSword;
	public static Item greatSword;
	public static Item fist;
    public static Item scythe;

	public static Item Zangetsu;
	public static Item TensaZangetsu;
	public static Item HandSonicv1;
	public static Item HandSonicv2;
	public static Item HandSonicv3;
	public static Item HandSonicv4;
	public static Item HandSonicv5;

	public static void init() {
		Zangetsu = new Zangetsu();
		GameRegistry.registerItem(Zangetsu, "Zangetsu");

		broadSword = new Sword(WeaponUtil.BROADSWORD, new int[] {20, 4 });
		GameRegistry.registerItem(broadSword, "broadsword");
		longSword = new Sword(WeaponUtil.LONGSWORD, new int[] {20, 6 });
		GameRegistry.registerItem(longSword, "longsword");
		greatSword = new Sword(WeaponUtil.GREATSWORD, new int[] {15, 8 });
		GameRegistry.registerItem(greatSword, "greatsword");
		fist = new Fist(WeaponUtil.FIST, new int[]{20});
		GameRegistry.registerItem(fist, "fist");
        scythe = new Scythe(WeaponUtil.SCYTHE, new int[]{20,6});
        GameRegistry.registerItem(scythe, "scythe");
	}
}
