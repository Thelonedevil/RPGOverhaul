package com.github.thelonedevil.rpgoverhaul.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.github.thelonedevil.rpgoverhaul.MyBlocks;
import com.github.thelonedevil.rpgoverhaul.MyItems;
import com.github.thelonedevil.rpgoverhaul.MyMetals;
import com.github.thelonedevil.rpgoverhaul.MyWeapons;

import cpw.mods.fml.common.registry.GameRegistry;

public class MyRecipes {
	public static void init() {
		float xp = 1.0f;
		GameRegistry.addSmelting(MyBlocks.ore_xiatherium, new ItemStack(MyMetals.ingot_xiatherium), xp);
		GameRegistry.addSmelting(MyBlocks.ore_farunese, new ItemStack(MyMetals.ingot_farunese), xp);
		GameRegistry.addSmelting(MyBlocks.ore_orobalt, new ItemStack(MyMetals.ingot_orobalt), xp);
		GameRegistry.addSmelting(MyBlocks.ore_kiritorium, new ItemStack(MyMetals.ingot_kiritorium), xp);
		GameRegistry.addSmelting(MyBlocks.ore_asunalt, new ItemStack(MyMetals.ingot_asunalt), xp);
		GameRegistry.addSmelting(MyBlocks.ore_axespium, new ItemStack(MyMetals.ingot_axespium), xp);
		GameRegistry.addSmelting(MyBlocks.ore_ayagrese, new ItemStack(MyMetals.ingot_ayagrese), xp);
		GameRegistry.addSmelting(MyBlocks.ore_emodralt, new ItemStack(MyMetals.ingot_emodralt), xp);
		GameRegistry.addSmelting(MyBlocks.ore_eruslalt, new ItemStack(MyMetals.ingot_eruslalt), xp);
		GameRegistry.addSmelting(MyBlocks.ore_evosum, new ItemStack(MyMetals.ingot_evosum), xp);
		GameRegistry.addSmelting(MyBlocks.ore_ithasium, new ItemStack(MyMetals.ingot_ithasium), xp);
		GameRegistry.addSmelting(MyBlocks.ore_ketsuekium, new ItemStack(MyMetals.ingot_ketsuekium), xp);
		GameRegistry.addSmelting(MyBlocks.ore_nautrenese, new ItemStack(MyMetals.ingot_nautrenese), xp);
		GameRegistry.addSmelting(MyBlocks.ore_onecrum, new ItemStack(MyMetals.ingot_onecrum), xp);
		GameRegistry.addSmelting(MyBlocks.ore_ozestum, new ItemStack(MyMetals.ingot_ozestum), xp);
		GameRegistry.addSmelting(MyBlocks.ore_sakuralt, new ItemStack(MyMetals.ingot_sakuralt), xp);
		GameRegistry.addSmelting(MyBlocks.ore_shikyolt, new ItemStack(MyMetals.ingot_shikyolt), xp);
		GameRegistry.addSmelting(MyBlocks.ore_tenshirium, new ItemStack(MyMetals.ingot_tenshirium), xp);

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.book), new Object[] { "materialPaper", "materialPaper", "materialPaper", Items.leather }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MyItems.questBook), new Object[] { "KLK", "PIP", "KLK", 'K', MyMetals.ingot_ketsuekium, 'L', Items.leather, 'P', "materialPaper", 'I',
				"dyeBlack" }));
		GameRegistry.addShapedRecipe(new ItemStack(MyItems.crystal_plasma), new Object[] { " A ", "BCD", " E ", 'A', MyItems.crystal_fire, 'B', MyItems.crystal_air, 'C', Items.diamond, 'D',
				MyItems.crystal_earth, 'E', MyItems.crystal_water });
		GameRegistry.addShapedRecipe(new ItemStack(MyBlocks.WeaponSmithblock),
				new Object[] { "ABA", "ACA", "AAA", 'A', MyMetals.ingot_kiritorium, 'B', MyMetals.ingot_ketsuekium, 'C', Blocks.iron_block });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.Parchment, 1), new Object[] { MyItems.goatSkin, Items.flint });

		CustomCrafting.getInstance().addShapelessRecipe(new ItemStack(MyMetals.alloyIngot, 1), new Object[] { MyMetals.mixedIngot, MyItems.crystal_smelting });

		CustomCrafting.getInstance().addShapedOreRecipe(new ItemStack(MyWeapons.broadSword, 1), new Object[] {"A","A","B",'A',"ingotMetal",'B',Items.stick});
		CustomCrafting.getInstance().addShapedOreRecipe(new ItemStack(MyWeapons.longSword, 1), new Object[] {"A","A","A","B",'A',"ingotMetal",'B',Items.stick});
	}
}
