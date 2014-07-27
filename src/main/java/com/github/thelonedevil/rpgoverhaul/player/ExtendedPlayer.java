package com.github.thelonedevil.rpgoverhaul.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import com.github.thelonedevil.rpgoverhaul.util.LogHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

import com.github.thelonedevil.rpgoverhaul.RPGOMain;
import com.github.thelonedevil.rpgoverhaul.Ref;
import com.github.thelonedevil.rpgoverhaul.armour.Armour;
import com.github.thelonedevil.rpgoverhaul.inventory.ArmourInventory;
import com.github.thelonedevil.rpgoverhaul.network.SyncPlayerProps;
import com.github.thelonedevil.rpgoverhaul.network.UpdateXpPacket;
import com.github.thelonedevil.rpgoverhaul.proxy.CommonProxy;
import com.github.thelonedevil.rpgoverhaul.util.Util;

public class ExtendedPlayer implements IExtendedEntityProperties {

	public final static String EXT_PROP_NAME = Ref.MODID + "ExtendedPlayer";
	private final EntityPlayer player;
	public final static ArmourInventory customInventory = new ArmourInventory();
	public List<Boolean> equippedModifiers = new ArrayList<Boolean>();
	public List<Armour> EquippedLastTick = new ArrayList<Armour>();
	private int[] skills = {};
	private HashMap<Perks, Boolean> perks = new HashMap<Perks, Boolean>();
	private double xp = 0;
	private int skillPoints = 0;

	public ExtendedPlayer(EntityPlayer player) {
		this.player = player;
		for (int i = 0; i < 12; i++) {
			equippedModifiers.add(false);
		}
		for (int i = 0; i < 12; i++) {
			EquippedLastTick.add(null);
		}

	}

	public static final void register(EntityPlayer player) {
		player.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer(player));
	}

	public static final ExtendedPlayer get(EntityPlayer player) {
		return (ExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
	}

	public static ArmourInventory getInv(EntityPlayer player) {
		if (customInventory != null) {
			return customInventory;
		} else
			return new ArmourInventory();
	}

	@Override
	public void saveNBTData(NBTTagCompound tag) {
        customInventory.writeToNBT(tag);
        tag.setDouble("xp",xp);
	}

	@Override
	public void loadNBTData(NBTTagCompound tag) {
        customInventory.readFromNBT(tag);
        this.xp = tag.getDouble("xp");
        UUID uuid = player.getUniqueID();
        EntityPlayerMP epmp = Util.getPlayerFromUUID(uuid);
        ExtendedPlayer.get(epmp).addXp(xp);
        RPGOMain.network.sendTo(new UpdateXpPacket( tag.getDouble("xp")), epmp);
	}

	@Override
	public void init(Entity entity, World world) {

	}

	public boolean addPerk(Perks perk1) {
		if (!perks.containsKey(perk1)) {
			perks.put(perk1, true);
			return true;
		} else if (perks.get(perk1) == false) {
			perks.put(perk1, true);
			return true;
		} else {
			return false;
		}
	}

	public boolean removePerk(Perks perk) {
		if (perks.containsKey(perk)) {
			perks.put(perk, false);
			return true;
		} else {
			return false;
		}
	}

	public boolean hasPerk(String perk) {
		return perks.containsKey(perk);
	}

	public int getSkill(int skill) {
		return skills[skill];
	}

	public void setSkill(int skill, int value) {
		skills[skill] = value;
	}

	public void addXp(double xp) {
		int oldlvl = this.getLevel();
		this.xp += xp;
		int newlvl = this.getLevel();
		if (newlvl > oldlvl) {
			levelUp(newlvl);
		}
	}

	public double getXp() {
		return this.xp;
	}

	public int getLevel() {
		return MathHelper.floor_double(Math.pow(xp / 100.0, 0.6));
	}

	private void levelUp(int newLvl) {
		skillPoints++;
		switch (newLvl) {
		case 50:
			addPerk(Perks.UPHILLSTEP);
			break;
		case 60:
			addPerk(Perks.RESPIRATION);
			break;
		}
	}
}
