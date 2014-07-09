package com.github.thelonedevil.rpgoverhaul.handlers;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import com.github.thelonedevil.rpgoverhaul.MyBlocks;
import com.github.thelonedevil.rpgoverhaul.RPGOMain;
import com.github.thelonedevil.rpgoverhaul.blocks.CustomChest;
import com.github.thelonedevil.rpgoverhaul.player.ExtendedPlayer;
import com.github.thelonedevil.rpgoverhaul.proxy.CommonProxy;
import com.github.thelonedevil.rpgoverhaul.util.LogHelper;
import com.github.thelonedevil.rpgoverhaul.util.Util;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class DeathHandler {
	@SubscribeEvent
	public void onDrops(LivingDropsEvent event) {
		// System.out.println("Get Actual World Height returned = "+event.entityLiving.worldObj.getActualHeight());
		if (!(event.entityLiving instanceof EntityPlayer)) {
			int x = MathHelper.floor_double(event.entity.posX);
			int y = MathHelper.floor_double(event.entity.posY);
			int z = MathHelper.floor_double(event.entity.posZ);
			World world = event.entityLiving.worldObj;
			Block block = world.getBlock(x, y, z);
			ItemStack loot = new ItemStack(Items.diamond, 12);
			boolean flag = false;
			for (int a = -3; a <= 3; a++) {
				for (int b = 0; b <= 5; b++) {
					for (int c = -3; c <= 3; c++) {
						Block block1 = world.getBlock(x + a, y + b, z + c);
						if (Block.isEqualTo(block1, MyBlocks.LootChest)) {
							if (flag == false) {
								this.addLootToChest(world, x + a, y + b, z + c,
										loot);
								flag = true;
							}
						}
					}
				}
			}
			if (flag == false) {
				if (block.isAir(world, x, y, z)
						|| block.equals(Blocks.tallgrass)) {
					setLootChest(world, x, y, z, event, loot);
				} else if (block.isAir(world, x + 1, y, z)
						|| block.equals(Blocks.tallgrass)) {
					setLootChest(world, x + 1, y, z, event, loot);
				} else if (block.isAir(world, x - 1, y, z)
						|| block.equals(Blocks.tallgrass)) {
					setLootChest(world, x - 1, y, z, event, loot);
				} else if (block.isAir(world, x, y, z + 1)
						|| block.equals(Blocks.tallgrass)) {
					setLootChest(world, x, y, z + 1, event, loot);
				} else if (block.isAir(world, x, y, z - 1)
						|| block.equals(Blocks.tallgrass)) {
					setLootChest(world, x, y, z - 1, event, loot);
				} else if (block.isAir(world, x, y + 1, z)
						|| block.equals(Blocks.tallgrass)) {
					setLootChest(world, x, y + 1, z, event, loot);
				} else if (block.isAir(world, x, y - 1, z)
						|| block.equals(Blocks.tallgrass)) {
					setLootChest(world, x, y - 1, z, event, loot);
				}
			}
		}
		event.setCanceled(true);
	}

	private void setLootChest(World world, int x, int y, int z,
			LivingDropsEvent event, ItemStack loot) {
		world.setBlock(x, y, z, MyBlocks.LootChest);

		addLootToChest(world, x, y, z, loot);
		for (int i = 0; i < event.drops.size(); i++) {
			addLootToChest(world, x, y, z, event.drops.get(i).getEntityItem());
			LogHelper.info(event.drops.get(i).getEntityItem().getDisplayName()
					+ event.drops.get(i).getEntityItem().stackSize);

		}

		world.markBlockForUpdate(x, y, z);
	}

	private void addLootToChest(World world, int x, int y, int z, ItemStack loot) {
		TileEntityChest chest = (TileEntityChest) world.getTileEntity(x, y, z);
		for (int i = 0; i < chest.getSizeInventory(); i++) {
			if (chest.getStackInSlot(i) != null) {
				if (chest.getStackInSlot(i).stackSize != 64) {
					if (chest.getStackInSlot(i).getItem() == loot.getItem()) {
						int size = chest.getStackInSlot(i).stackSize
								+ loot.stackSize;
						if (size < 65) {
							ItemStack newloot = new ItemStack(loot.getItem(),
									size);
							chest.setInventorySlotContents(i, newloot);
						} else {
							int size2 = size - 64;
							ItemStack newloot2 = new ItemStack(loot.getItem(),
									size2);
							ItemStack newloot = new ItemStack(loot.getItem(),
									64);
							chest.setInventorySlotContents(i, newloot);
							addLootToChest(world, x, y, z, newloot2);
							break;
						}
					}
				}
			} else {
				chest.setInventorySlotContents(i, loot);
				break;
			}
		}
		world.setTileEntity(x, y, z, chest);
	}

	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event) {
		if (!event.entity.worldObj.isRemote
				&& event.entity instanceof EntityPlayer) {

			ExtendedPlayer.saveProxyData((EntityPlayer) event.entity);
		}
	}

}
