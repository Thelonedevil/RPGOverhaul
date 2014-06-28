package com.github.thelonedevil.rpgoverhaul;

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

		ItemStack stack1 = new ItemStack(MyItems.ingot_xiatherium);
		ItemStack stack2 = new ItemStack(MyItems.ingot_farunese);
		ItemStack stack3 = new ItemStack(MyItems.ingot_orobalt);
		ItemStack stack4 = new ItemStack(MyItems.ingot_kiritorium);
		ItemStack stack5 = new ItemStack(MyItems.ingot_asunalt);
		ItemStack stack6 = new ItemStack(MyItems.ingot_eruslalt);
		ItemStack stack7 = new ItemStack(MyItems.ingot_ithasium);
		ItemStack stack8 = new ItemStack(MyItems.ingot_ozestum);
		ItemStack stack9 = new ItemStack(MyItems.ingot_emodralt);
		ItemStack stack10 = new ItemStack(MyItems.ingot_evosum);
		ItemStack stack11 = new ItemStack(MyItems.ingot_nautrenese);
		ItemStack stack12 = new ItemStack(MyItems.ingot_axespium);
		ItemStack stack13 = new ItemStack(MyItems.ingot_ketsuekium);
		ItemStack stack14 = new ItemStack(MyItems.ingot_shikyolt);
		ItemStack stack15 = new ItemStack(MyItems.ingot_sakuralt);
		ItemStack stack16 = new ItemStack(MyItems.ingot_ayagrese);
		ItemStack stack17 = new ItemStack(MyItems.ingot_tenshirium);
		ItemStack stack18 = new ItemStack(MyItems.ingot_onecrum);
		ItemStack stack19 = new ItemStack(Items.gold_ingot);
		ItemStack stack20 = new ItemStack(Items.iron_ingot);

		/*
		 * List<ItemStack> ingots = OreDictionary.getOres("mixedIngot"); for()
		 * 
		 * 
		 * GameRegistry.addShapelessRecipe(new
		 * ItemStack(MixedIngotSmart.mixedIngot,1), new Object[]{});
		 */
		/*ItemStack input = new ItemStack(MyItems.mixedIngot);
		ItemStack output = new ItemStack(MyItems.alloyIngot);
		GameRegistry.addSmelting(input, output, xp);*/
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.alloyIngot,1), new Object[] {new ItemStack(MyItems.crystal_smelting), new ItemStack(MyItems.mixedIngot)}  );
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack1, stack2 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack1, stack3 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack1, stack4 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack1, stack5 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack1, stack6 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack1, stack7 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack1, stack8 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack1, stack9 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack1, stack10 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack1, stack11 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack1, stack12 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack1, stack13 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack1, stack14 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack1, stack15 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack1, stack16 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack1, stack17 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack1, stack18 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack1, stack19 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack1, stack20 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack2, stack3 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack2, stack4 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack2, stack5 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack2, stack6 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack2, stack7 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack2, stack8 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack2, stack9 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack2, stack10 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack2, stack11 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack2, stack12 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack2, stack13 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack2, stack14 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack2, stack15 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack2, stack16 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack2, stack17 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack2, stack18 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack2, stack19 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack2, stack20 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack3, stack4 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack3, stack5 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack3, stack6 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack3, stack7 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack3, stack8 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack3, stack9 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack3, stack10 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack3, stack11 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack3, stack12 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack3, stack13 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack3, stack14 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack3, stack15 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack3, stack16 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack3, stack17 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack3, stack18 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack3, stack19 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack3, stack20 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack4, stack5 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack4, stack6 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack4, stack7 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack4, stack8 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack4, stack9 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack4, stack10 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack4, stack11 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack4, stack12 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack4, stack13 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack4, stack14 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack4, stack15 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack4, stack16 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack4, stack17 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack4, stack18 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack4, stack19 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack4, stack20 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack5, stack6 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack5, stack7 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack5, stack9 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack5, stack9 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack5, stack10 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack5, stack11 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack5, stack12 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack5, stack13 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack5, stack14 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack5, stack15 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack5, stack16 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack5, stack17 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack5, stack18 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack5, stack19 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack5, stack20 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack6, stack7 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack6, stack8 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack6, stack9 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack6, stack10 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack6, stack11 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack6, stack12 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack6, stack13 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack6, stack14 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack6, stack15 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack6, stack16 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack6, stack17 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack6, stack18 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack6, stack19 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack6, stack20 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack7, stack8 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack7, stack9 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack7, stack10 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack7, stack11 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack7, stack12 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack7, stack13 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack7, stack14 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack7, stack15 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack7, stack16 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack7, stack17 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack7, stack18 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack7, stack19 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack7, stack20 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack8, stack9 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack8, stack10 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack8, stack11 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack8, stack12 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack8, stack13 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack8, stack14 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack8, stack15 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack8, stack16 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack8, stack17 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack8, stack18 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack8, stack19 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack8, stack20 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack9, stack10 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack9, stack11 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack9, stack12 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack9, stack13 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack9, stack14 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack9, stack15 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack9, stack16 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack9, stack17 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack9, stack18 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack9, stack19 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack9, stack20 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack10, stack11 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack10, stack12 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack10, stack13 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack10, stack14 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack10, stack15 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack10, stack16 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack10, stack17 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack10, stack18 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack10, stack19 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack10, stack20 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack11, stack12 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack11, stack13 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack11, stack14 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack11, stack15 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack11, stack16 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack11, stack17 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack11, stack18 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack11, stack19 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack11, stack20 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack12, stack13 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack12, stack14 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack12, stack15 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack12, stack16 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack12, stack17 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack12, stack18 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack12, stack19 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack12, stack20 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack13, stack14 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack13, stack15 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack13, stack16 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack13, stack17 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack13, stack18 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack13, stack19 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack13, stack20 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack14, stack15 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack14, stack16 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack14, stack17 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack14, stack18 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack14, stack19 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack14, stack20 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack15, stack16 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack15, stack17 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack15, stack18 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack15, stack19 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack15, stack20 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack16, stack17 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack16, stack18 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack16, stack19 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack16, stack20 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack17, stack18 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack17, stack19 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack17, stack20 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack18, stack19 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack18, stack20 });
		GameRegistry.addShapelessRecipe(new ItemStack(MyItems.mixedIngot, 1), new Object[] { stack19, stack20 });
	}
}
