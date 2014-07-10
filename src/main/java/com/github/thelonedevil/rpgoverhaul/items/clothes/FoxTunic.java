package com.github.thelonedevil.rpgoverhaul.items.clothes;

import com.github.thelonedevil.rpgoverhaul.Ref;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FoxTunic extends ItemArmor{

	public FoxTunic(ArmorMaterial p_i45325_1_, int p_i45325_2_, int p_i45325_3_) {
		super(p_i45325_1_, p_i45325_2_, p_i45325_3_);
		// TODO Auto-generated constructor stub
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon){
		this.itemIcon = icon.registerIcon(Ref.MODID+":foxTunic");
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){

		return Ref.MODID+":textures/models/armor/fox_Layer1.png";
		
	}

}