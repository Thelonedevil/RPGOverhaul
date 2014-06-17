package com.github.thelonedevil.rpgoverhaul;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class MyRecipes {
	public static void init(){
		float xp = 1.0f;
		GameRegistry.addSmelting(MyBlocks.ore_xiatherium, new ItemStack(MyItems.ingot_xiatherium), xp);
		GameRegistry.addSmelting(MyBlocks.ore_farunese,new ItemStack(MyItems.ingot_farunese), xp);
		GameRegistry.addSmelting(MyBlocks.ore_orobalt, new ItemStack(MyItems.ingot_orobalt), xp);
		GameRegistry.addSmelting(MyBlocks.ore_kiritorium, new ItemStack(MyItems.ingot_kiritorium), xp);
		GameRegistry.addSmelting(MyBlocks.ore_asunalt, new ItemStack(MyItems.ingot_asunalt), xp);
		
		GameRegistry.addShapedRecipe(new ItemStack(MyItems.crystal_plasma), new Object[] {" A ","BCD"," E ",'A',MyItems.crystal_fire,'B',MyItems.crystal_air,'C',Items.diamond,'D',MyItems.crystal_earth,'E',MyItems.crystal_water} );
	}
}
