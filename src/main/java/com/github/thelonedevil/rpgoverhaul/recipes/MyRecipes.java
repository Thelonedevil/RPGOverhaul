package com.github.thelonedevil.rpgoverhaul.recipes;

import com.github.thelonedevil.rpgoverhaul.MyBlocks;
import com.github.thelonedevil.rpgoverhaul.MyItems;
import com.github.thelonedevil.rpgoverhaul.MyWeapons;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.registry.GameRegistry;

public class MyRecipes {
	public static void init() {
		float xp = 1.0f;
		GameRegistry.addSmelting(MyBlocks.ore_xiatherium, new ItemStack(MyItems.ingot_xiatherium), xp);
		GameRegistry.addSmelting(MyBlocks.ore_farunese, new ItemStack(MyItems.ingot_farunese), xp);
		GameRegistry.addSmelting(MyBlocks.ore_orobalt, new ItemStack(MyItems.ingot_orobalt), xp);
		GameRegistry.addSmelting(MyBlocks.ore_kiritorium, new ItemStack(MyItems.ingot_kiritorium), xp);
		GameRegistry.addSmelting(MyBlocks.ore_asunalt, new ItemStack(MyItems.ingot_asunalt), xp);

		GameRegistry.addShapedRecipe(new ItemStack(MyItems.crystal_plasma), new Object[] { " A ", "BCD", " E ", 'A', MyItems.crystal_fire, 'B', MyItems.crystal_air, 'C', Items.diamond, 'D',
				MyItems.crystal_earth, 'E', MyItems.crystal_water });
		GameRegistry.addShapedRecipe(new ItemStack(MyBlocks.WeaponSmithblock), new Object[] {"ABA","ACA","AAA",'A',MyItems.ingot_kiritorium, 'B', MyItems.ingot_ketsuekium, 'C', Blocks.iron_block});
		
		CustomCrafting.getInstance().addShapelessRecipe(new ItemStack(MyItems.alloyIngot, 1), new Object[]{MyItems.mixedIngot,MyItems.crystal_smelting});
		CustomCrafting.getInstance().addRecipe(new ItemStack(MyWeapons.broadsword_bottom, 1), new Object[] { "AAAAA", "  A  ", "  A  ", "  A  ", "     ", 'A', MyItems.alloyIngot });
		CustomCrafting.getInstance().addRecipe(new ItemStack(MyWeapons.broadsword_top, 1), new Object[] { "  A  ", " AAA ", " AAA ", " AAA ", " AAA ", 'A', MyItems.alloyIngot });
		CustomCrafting.getInstance().addRecipe(new ItemStack(MyWeapons.broadsword, 1), new Object[] { "A", "B", 'A', MyWeapons.broadsword_top, 'B', MyWeapons.broadsword_bottom });
	}
}
