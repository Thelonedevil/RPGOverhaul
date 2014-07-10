package com.github.thelonedevil.rpgoverhaul.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.github.thelonedevil.rpgoverhaul.MyBlocks;
import com.github.thelonedevil.rpgoverhaul.MyItems;
import com.github.thelonedevil.rpgoverhaul.MyWeapons;

import cpw.mods.fml.common.registry.GameRegistry;

public class MyRecipes {
	public static void init() {
		float xp = 1.0f;
		GameRegistry.addSmelting(MyBlocks.ore_xiatherium, new ItemStack(MyItems.ingot_xiatherium), xp);
		GameRegistry.addSmelting(MyBlocks.ore_farunese, new ItemStack(MyItems.ingot_farunese), xp);
		GameRegistry.addSmelting(MyBlocks.ore_orobalt, new ItemStack(MyItems.ingot_orobalt), xp);
		GameRegistry.addSmelting(MyBlocks.ore_kiritorium, new ItemStack(MyItems.ingot_kiritorium), xp);
		GameRegistry.addSmelting(MyBlocks.ore_asunalt, new ItemStack(MyItems.ingot_asunalt), xp);
		GameRegistry.addSmelting(MyBlocks.ore_axespium, new ItemStack(MyItems.ingot_axespium), xp);
		GameRegistry.addSmelting(MyBlocks.ore_ayagrese, new ItemStack(MyItems.ingot_ayagrese), xp);
		GameRegistry.addSmelting(MyBlocks.ore_emodralt, new ItemStack(MyItems.ingot_emodralt), xp);
		GameRegistry.addSmelting(MyBlocks.ore_eruslalt, new ItemStack(MyItems.ingot_eruslalt), xp);
		GameRegistry.addSmelting(MyBlocks.ore_evosum, new ItemStack(MyItems.ingot_evosum), xp);
		GameRegistry.addSmelting(MyBlocks.ore_ithasium, new ItemStack(MyItems.ingot_ithasium), xp);
		GameRegistry.addSmelting(MyBlocks.ore_ketsuekium, new ItemStack(MyItems.ingot_ketsuekium), xp);
		GameRegistry.addSmelting(MyBlocks.ore_nautrenese, new ItemStack(MyItems.ingot_nautrenese), xp);
		GameRegistry.addSmelting(MyBlocks.ore_onecrum, new ItemStack(MyItems.ingot_onecrum), xp);
		GameRegistry.addSmelting(MyBlocks.ore_ozestum, new ItemStack(MyItems.ingot_ozestum), xp);
		GameRegistry.addSmelting(MyBlocks.ore_sakuralt, new ItemStack(MyItems.ingot_sakuralt), xp);
		GameRegistry.addSmelting(MyBlocks.ore_shikyolt, new ItemStack(MyItems.ingot_shikyolt), xp);
		GameRegistry.addSmelting(MyBlocks.ore_tenshirium, new ItemStack(MyItems.ingot_tenshirium), xp);

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.book), new Object[] { "materialPaper", "materialPaper", "materialPaper", Items.leather }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MyItems.questBook), new Object[]{"KLK","PIP","KLK",'K', MyItems.ingot_ketsuekium, 'L',Items.leather, 'P',"materialPaper", 'I',"dyeBlack"}));
		GameRegistry.addShapedRecipe(new ItemStack(MyItems.crystal_plasma), new Object[] { " A ", "BCD", " E ", 'A', MyItems.crystal_fire, 'B', MyItems.crystal_air, 'C', Items.diamond, 'D',
				MyItems.crystal_earth, 'E', MyItems.crystal_water });
		GameRegistry.addShapedRecipe(new ItemStack(MyBlocks.WeaponSmithblock),
				new Object[] { "ABA", "ACA", "AAA", 'A', MyItems.ingot_kiritorium, 'B', MyItems.ingot_ketsuekium, 'C', Blocks.iron_block });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.Parchment, 1), new Object[] { MyItems.goatSkin, Items.flint });

		CustomCrafting.getInstance().addShapelessRecipe(new ItemStack(MyItems.alloyIngot, 1), new Object[] { MyItems.mixedIngot, MyItems.crystal_smelting });

		CustomCrafting.getInstance().addShapedOreRecipe(new ItemStack(MyWeapons.broadsword_bottom, 1), new Object[] { "AAAAA", "  A  ", "  A  ", "  A  ", "     ", 'A', "ingotMetal" });
		CustomCrafting.getInstance().addShapedOreRecipe(new ItemStack(MyWeapons.broadsword_top, 1), new Object[] { "  A  ", " AAA ", " AAA ", " AAA ", " AAA ", 'A', "ingotMetal" });
		/*CustomCrafting.getInstance().addRecipe(new ItemStack(MyItems.questBook, 1),
				new Object[] { "KLKLK", "LPPPL", "KPIPK", "LPPPL", "KLKLK", 'K', MyItems.ingot_ketsuekium, 'L', Items.leather, 'P', MyItems.Parchment, 'I', Items.coal });*/
		CustomCrafting.getInstance().addRecipe(new ItemStack(MyWeapons.broadsword, 1), new Object[] { "A", "B", 'A', MyWeapons.broadsword_top, 'B', MyWeapons.broadsword_bottom });
	}
}
