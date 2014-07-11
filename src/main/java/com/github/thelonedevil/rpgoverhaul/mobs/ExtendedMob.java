package com.github.thelonedevil.rpgoverhaul.mobs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

import com.github.thelonedevil.rpgoverhaul.Ref;

public class ExtendedMob implements IExtendedEntityProperties {
	public final static String EXT_PROP_NAME = Ref.MODID + "ExtendedMob";

	private final EntityMob Mob;
	private int lvl = 1;

	public ExtendedMob(EntityMob mob) {
		this.Mob = mob;
	}

	public static final void register(EntityMob mob) {
		mob.registerExtendedProperties(ExtendedMob.EXT_PROP_NAME, new ExtendedMob(mob));
	}

	public static final ExtendedMob get(EntityMob mob) {
		return (ExtendedMob) mob.getExtendedProperties(EXT_PROP_NAME);
	}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();
		properties.setInteger("level", lvl);
		compound.setTag(EXT_PROP_NAME, properties);

	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		this.lvl = properties.getInteger("level");

	}

	public void setLevel(int level) {
		this.lvl = level;
	}

	public int getLevel() {
		return this.lvl;
	}

	@Override
	public void init(Entity entity, World world) {
		// TODO Auto-generated method stub

	}

}
