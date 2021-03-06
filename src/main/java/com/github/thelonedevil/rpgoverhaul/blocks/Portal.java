package com.github.thelonedevil.rpgoverhaul.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.github.thelonedevil.rpgoverhaul.MyItems;
import com.github.thelonedevil.rpgoverhaul.RPGOMain;
import com.github.thelonedevil.rpgoverhaul.Ref;
import com.github.thelonedevil.rpgoverhaul.tileentities.PortalTileEntity;
import com.github.thelonedevil.rpgoverhaul.util.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Portal extends Block implements ITileEntityProvider {
	private final Random random = new Random();
	@SideOnly(Side.CLIENT)
	private static IIcon top;

	public Portal() {
		super(Material.anvil);
		this.setCreativeTab(RPGOMain.myTab);
		this.setBlockName("Portal");
		this.setBlockTextureName(Ref.MODID + ":portal");
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new PortalTileEntity();
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister) {
		this.blockIcon = iconregister.registerIcon(Ref.MODID + ":portal_side");
		this.top = iconregister.registerIcon(Ref.MODID + ":portal_top");
	}

	public IIcon getIcon(int side, int meta) {
		if (side == 1) {
			return top;
		} else if (side == 0) {
			return Blocks.end_stone.getBlockTextureFromSide(side);
		} else {
			return this.blockIcon;
		}
	}

	public boolean isOpaqueCube() {
		return false;
	}

	/**
	 * Sets the block's bounds for rendering it as an item
	 */
	public void setBlockBoundsForItemRender() {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
	}

	public void addCollisionBoxesToList(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
		super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
		this.setBlockBoundsForItemRender();
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == MyItems.questBook) {
			PortalTileEntity tile = (PortalTileEntity) world.getTileEntity(x, y, z);
			tile.setInventorySlotContents(0, player.getCurrentEquippedItem());
			tile.book = true;
			tile.markDirty();
			world.setTileEntity(x, y, z, tile);
			player.destroyCurrentEquippedItem();
		} else if (player.getCurrentEquippedItem() == null) {
			PortalTileEntity tile = (PortalTileEntity) world.getTileEntity(x, y, z);
			ItemStack itemstack = tile.getStackInSlot(0);
			if (itemstack != null) {
				if (player.isSneaking()) {
					tile.book = false;
					tile.setInventorySlotContents(0, null);
					tile.markDirty();
					world.setTileEntity(x, y, z, tile);
					float f = this.random.nextFloat() * 0.6F + 0.1F;
					float f1 = this.random.nextFloat() * 0.6F + 0.1F;
					float f2 = this.random.nextFloat() * 0.6F + 0.1F;
					EntityItem entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), 1,
							itemstack.getItemDamage()));

					if (itemstack.hasTagCompound()) {
						entityitem.getEntityItem().setTagCompound(((NBTTagCompound) itemstack.getTagCompound().copy()));
					}

					float f3 = 0.025F;
					entityitem.motionX = (double) ((float) this.random.nextGaussian() * f3);
					entityitem.motionY = (double) ((float) this.random.nextGaussian() * f3 + 0.1F);
					entityitem.motionZ = (double) ((float) this.random.nextGaussian() * f3);
					if (!world.isRemote)
						world.spawnEntityInWorld(entityitem);
				} else {
					player.openGui(RPGOMain.instance, Ref.QUESTBOOK_GUI, world, 0, 0, 0);
					LogHelper.info("Gui Opened");
				}
			}
		}
		return true;

	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		PortalTileEntity tile = (PortalTileEntity) world.getTileEntity(x, y, z);
		if (tile != null) {
			for (int i = 0; i < tile.getSizeInventory(); i++) {
				ItemStack itemstack = tile.getStackInSlot(i);

				if (itemstack != null) {
					float f = this.random.nextFloat() * 0.6F + 0.1F;
					float f1 = this.random.nextFloat() * 0.6F + 0.1F;
					float f2 = this.random.nextFloat() * 0.6F + 0.1F;

					while (itemstack.stackSize > 0) {
						int j = this.random.nextInt(21) + 10;

						if (j > itemstack.stackSize) {
							j = itemstack.stackSize;
						}

						itemstack.stackSize -= j;
						EntityItem entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j,
								itemstack.getItemDamage()));

						if (itemstack.hasTagCompound()) {
							entityitem.getEntityItem().setTagCompound(((NBTTagCompound) itemstack.getTagCompound().copy()));
						}

						float f3 = 0.025F;
						entityitem.motionX = (double) ((float) this.random.nextGaussian() * f3);
						entityitem.motionY = (double) ((float) this.random.nextGaussian() * f3 + 0.1F);
						entityitem.motionZ = (double) ((float) this.random.nextGaussian() * f3);
						world.spawnEntityInWorld(entityitem);
					}
				}
			}
			world.func_147453_f(x, y, z, block);
		}

		super.breakBlock(world, x, y, z, block, meta);
	}

}
