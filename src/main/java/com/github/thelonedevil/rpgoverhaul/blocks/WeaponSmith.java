package com.github.thelonedevil.rpgoverhaul.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.github.thelonedevil.rpgoverhaul.RPGOMain;
import com.github.thelonedevil.rpgoverhaul.Ref;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WeaponSmith extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon field_150035_a;
	@SideOnly(Side.CLIENT)
	private IIcon field_150034_b;

	public WeaponSmith() {
		super(Material.iron);
		this.setBlockTextureName(Ref.MODID + ":weapon_smith");
		// TODO Auto-generated constructor stub
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return side == 1 ? this.field_150035_a : (side == 0 ? Blocks.iron_block.getBlockTextureFromSide(side) : (side == 3 ? this.blockIcon : this.field_150034_b));
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconreg) {
		this.blockIcon = iconreg.registerIcon(this.getTextureName() + "_side");
		this.field_150035_a = iconreg.registerIcon(this.getTextureName() + "_top");
		this.field_150034_b = iconreg.registerIcon(this.getTextureName() + "_front");
	}

	/**
	 * Called upon block activation (right click on the block.)
	 */
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		if (world.isRemote) {
			return true;
		} else {
			player.openGui(RPGOMain.instance, Ref.WEAPON_SMITH_GUI, world, x, y, z);
			return true;
		}
	}

}
