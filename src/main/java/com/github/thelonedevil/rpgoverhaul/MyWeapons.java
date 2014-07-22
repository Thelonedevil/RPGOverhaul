package com.github.thelonedevil.rpgoverhaul;

import net.minecraft.item.Item;

import com.github.thelonedevil.rpgoverhaul.weapons.swords.LegendarySword;
import com.github.thelonedevil.rpgoverhaul.weapons.swords.Sword;

import cpw.mods.fml.common.registry.GameRegistry;

public class MyWeapons {
	public static Item broadSword;
	public static Item longSword;
	public static Item greatSword;

	public static Item Zangetsu;
	public static Item TensaZangetsu;
	public static Item HandSonicv1;
	public static Item HandSonicv2;
	public static Item HandSonicv3;
	public static Item HandSonicv4;
	public static Item HandSonicv5;

	public static void init() {
		Zangetsu = new LegendarySword("Zangetsu", "The Slaying Moon", new int[] { 20, 4 });
		GameRegistry.registerItem(Zangetsu, "Zangetsu");

		broadSword = new Sword("BroadSword", new int[] {20, 4 });
		GameRegistry.registerItem(broadSword, "broadsword");
		longSword = new Sword("longSword", new int[] {20, 6 });
		GameRegistry.registerItem(longSword, "longsword");
		greatSword = new Sword("greatSword", new int[] {15, 8 });
		GameRegistry.registerItem(greatSword, "greatsword");
	}
}
