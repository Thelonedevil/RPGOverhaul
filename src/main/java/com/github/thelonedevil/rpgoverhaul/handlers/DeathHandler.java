package com.github.thelonedevil.rpgoverhaul.handlers;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
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
import com.github.thelonedevil.rpgoverhaul.Util;

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
								this.addLootToChest(world, x + a, y + b, z + c, event, loot);
								flag = true;
							}
						}
					}
				}
			}
			if (flag == false) {
				if (block.isAir(world, x, y, z)) {
					setLootChest(world, x, y, z, event, loot);
				} else if (block.isAir(world, x + 1, y, z)) {
					setLootChest(world, x + 1, y, z, event, loot);
				} else if (block.isAir(world, x - 1, y, z)) {
					setLootChest(world, x - 1, y, z, event, loot);
				} else if (block.isAir(world, x, y, z + 1)) {
					setLootChest(world, x, y, z + 1, event, loot);
				} else if (block.isAir(world, x, y, z - 1)) {
					setLootChest(world, x, y, z - 1, event, loot);
				} else if (block.isAir(world, x, y + 1, z)) {
					setLootChest(world, x, y + 1, z, event, loot);
				} else if (block.isAir(world, x, y - 1, z)) {
					setLootChest(world, x, y - 1, z, event, loot);
				}
			}
		}/*
		 * else if(event.entityLiving instanceof EntityPlayer){ EntityPlayer
		 * player = (EntityPlayer)event.entityLiving; IInventory dead =
		 * player.inventory; double x = event.entity.posX; double y =
		 * event.entity.posY; double z = event.entity.posZ; World world =
		 * event.entityLiving.worldObj;
		 * world.setBlock(MathHelper.floor_double(x),
		 * MathHelper.floor_double(y), MathHelper.floor_double(z),
		 * MyBlocks.LootChest); TileEntityChest chest = (TileEntityChest)
		 * world.getTileEntity(MathHelper.floor_double(x),
		 * MathHelper.floor_double(y), MathHelper.floor_double(z)); for(int i =
		 * 0; i<dead.getSizeInventory();i++){ if(dead.getStackInSlot(i)!=null){
		 * chest.setInventorySlotContents(i, dead.getStackInSlot(i)); } }
		 * world.setTileEntity(MathHelper.floor_double(x),
		 * MathHelper.floor_double(y), MathHelper.floor_double(z), chest); }
		 */
	}

	private void setLootChest(World world, int x, int y, int z, LivingDropsEvent event, ItemStack loot) {
		world.setBlock(x, y, z, MyBlocks.LootChest);
		TileEntityChest chest = (TileEntityChest) world.getTileEntity(x, y, z);

		int slot = 0;
		chest.setInventorySlotContents(slot, loot);
		slot++;
		for (int i = 0; i < event.drops.size(); i++) {
			chest.setInventorySlotContents(slot, event.drops.get(i).getEntityItem());
			event.drops.remove(event.drops.get(i));
			slot++;
		}
		world.setTileEntity(x, y, z, chest);
		world.markBlockForUpdate(x, y, z);
	}

	private void addLootToChest(World world, int x, int y, int z, LivingDropsEvent event, ItemStack loot) {
		TileEntityChest chest = (TileEntityChest) world.getTileEntity(x, y, z);
		boolean flag = false;
		for (int j = 0; j < event.drops.size(); j++) {
			for (int i = 0; i < chest.getSizeInventory(); i++) {
				if (chest.getStackInSlot(i) != null) {
					if (chest.getStackInSlot(i).isItemEqual(event.drops.get(j).getEntityItem())) {
						ItemStack[] stacks = Util.mergeItemStacks(chest.getStackInSlot(i), event.drops.get(j).getEntityItem());
						event.drops.remove(event.drops.get(j));
						chest.setInventorySlotContents(i, stacks[0]);
						int emptySlot = Util.findEmptySlot(chest);
						if (emptySlot != -1 && stacks.length == 2) {
							chest.setInventorySlotContents(emptySlot, stacks[1]);
						}
					}
				}
			}
		}
		for (int i = 0; i < chest.getSizeInventory(); i++) {

			if (flag == false) {
				if (chest.getStackInSlot(i) != null) {
					if (chest.getStackInSlot(i).isItemEqual(loot)) {
						if (chest.getStackInSlot(i).stackSize != 64) {
							ItemStack[] stacks = Util.mergeItemStacks(chest.getStackInSlot(i), loot);
							chest.setInventorySlotContents(i, stacks[0]);
							int emptySlot = Util.findEmptySlot(chest);
							if (emptySlot != -1 && stacks.length == 2) {
								chest.setInventorySlotContents(emptySlot, stacks[1]);
							}
							flag = true;
						}
					}
				}
			}
		}
		world.setTileEntity(x, y, z, chest);
	}

	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event) {
		// we only want to save data for players (most likely, anyway)
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) {

			ExtendedPlayer.saveProxyData((EntityPlayer) event.entity);
		}
	}

}
