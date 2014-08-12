package com.github.thelonedevil.rpgoverhaul;

import com.github.thelonedevil.rpgoverhaul.armour.Belt;
import com.github.thelonedevil.rpgoverhaul.armour.Helmet;
import com.github.thelonedevil.rpgoverhaul.util.ArmourUtil;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

/**
 * Created by justin on 04/08/2014.
 */
public class MyArmour {

    public static Item TestHelmet;
    public static Item TestPauldronL;
    public static Item TestPauldronR;
    public static Item TestCuirass;
    public static Item TestBracerL;
    public static Item TestBracerR;
    public static Item TestBelt;
    
    public static void init(){
        TestHelmet = new Helmet().setCreativeTab(RPGOMain.myTab).setUnlocalizedName(ArmourUtil.HELMET);
        GameRegistry.registerItem(TestHelmet, "testhelmet");
        TestBelt = new Belt().setCreativeTab(RPGOMain.myTab).setUnlocalizedName("testbelt");
        GameRegistry.registerItem(TestBelt, "testbelt");
    }
}
