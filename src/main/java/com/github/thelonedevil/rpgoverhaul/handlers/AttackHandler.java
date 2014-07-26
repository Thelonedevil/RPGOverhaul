package com.github.thelonedevil.rpgoverhaul.handlers;

import com.github.thelonedevil.rpgoverhaul.weapons.Weapon;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

public class AttackHandler {

    @SubscribeEvent
    public void onPlayerAttack(AttackEntityEvent event) {
        ItemStack stack = event.entityPlayer.getHeldItem();
        if (stack != null) {
            Item item = stack.getItem();
            if (item instanceof Weapon) {
                int damage = 6;
                NBTTagCompound tag = stack.getTagCompound();
                if (tag != null) {
                    damage = tag.getInteger("damage");
                }
                if (event.target instanceof EntityLivingBase) {
                    EntityLivingBase target = (EntityLivingBase) event.target;
                    target.attackEntityFrom(new EntityDamageSource(item.getItemStackDisplayName(event.entityPlayer.getHeldItem()), event.entityPlayer), damage);
                }
            }

        }

    }
}
