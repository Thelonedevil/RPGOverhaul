package com.github.thelonedevil.rpgoverhaul.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import javax.imageio.ImageIO;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;

public class Util {
	public static ItemStack[] mergeItemStacks(ItemStack stack1, ItemStack stack2) {
		int size1 = stack1.stackSize;
		int size2 = stack2.stackSize;
		if (size1 < 64 && size2 < 64) {
			int fsize = size1 + size2;
			if (fsize > 64) {
				int size3 = fsize - 64;
				ItemStack stack3 = new ItemStack(stack1.getItem(), 64);
				ItemStack stack4 = new ItemStack(stack1.getItem(), size3);
				return new ItemStack[] { stack3, stack4 };
			} else
				return new ItemStack[] { new ItemStack(stack1.getItem(), fsize) };
		} else
			return new ItemStack[] { stack1, stack2 };
	}

	public static int findEmptySlot(IInventory inv) {
		for (int i = 0; i < inv.getSizeInventory(); i++) {
			if (inv.getStackInSlot(i) == null) {
				return i;
			}
		}
		return -1;

	}

	public static HashMap<String, BufferedImage> getImages(File file1) {
		HashMap<String, BufferedImage> imgs = new HashMap<String, BufferedImage>();
		for (File file : file1.listFiles()) {
			if (file.getName().endsWith(".png")) {
				try {
					BufferedImage img = ImageIO.read(file);
					if (img != null) {
						imgs.put(file.getName(), img);
					}
				} catch (IOException e) {
				}
			}
		}

		return imgs;
	}

	public static EntityPlayerMP getPlayerFromUUID(UUID uuid) {
		for (int i = 0; i < MinecraftServer.getServer().getConfigurationManager().playerEntityList.size(); ++i) {
			EntityPlayerMP entityplayermp = (EntityPlayerMP) MinecraftServer.getServer().getConfigurationManager().playerEntityList.get(i);

			if (entityplayermp.getUniqueID().equals(uuid)) {
				return entityplayermp;
			}
		}
		return null;
	}
}
