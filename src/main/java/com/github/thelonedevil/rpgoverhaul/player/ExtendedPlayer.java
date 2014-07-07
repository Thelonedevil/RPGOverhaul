package com.github.thelonedevil.rpgoverhaul.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

import com.github.thelonedevil.rpgoverhaul.RPGOMain;
import com.github.thelonedevil.rpgoverhaul.Ref;
import com.github.thelonedevil.rpgoverhaul.armour.Armour;
import com.github.thelonedevil.rpgoverhaul.inventory.ArmourInventory;
import com.github.thelonedevil.rpgoverhaul.network.SyncPlayerProps;
import com.github.thelonedevil.rpgoverhaul.proxy.CommonProxy;

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
	private ContainerWorkbench openContainer;

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
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();
		customInventory.writeToNBT(properties);
		properties.setDouble("xp", xp);
		properties.setIntArray("Skills", skills);
		for (Perks key : perks.keySet()) {
			properties.setBoolean(key.toString(), perks.get(key));
		}

		compound.setTag(EXT_PROP_NAME, properties);

	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		customInventory.readFromNBT(properties);
		xp = properties.getDouble("xp");
		skills = properties.getIntArray("Skills");
		Perks[] perklist = Perks.values();
		for (int i = 0; i < perklist.length; i++) {
			if (properties.getBoolean(perklist[i].toString())) {
				addPerk(perklist[i]);
			}
		}

	}

	private static String getSaveKey(EntityPlayer player) {
		return player.getUniqueID() + ":" + EXT_PROP_NAME;
	}

	/**
	 * Does everything I did in onLivingDeathEvent and it's static, so you now
	 * only need to use the following in the above event:
	 * ExtendedPlayer.saveProxyData((EntityPlayer) event.entity));
	 */
	public static void saveProxyData(EntityPlayer player) {
		ExtendedPlayer playerData = ExtendedPlayer.get(player);
		NBTTagCompound savedData = new NBTTagCompound();

		playerData.saveNBTData(savedData);
		// Note that we made the CommonProxy method storeEntityData static,
		// so now we don't need an instance of CommonProxy to use it! Great!
		CommonProxy.storeEntityData(getSaveKey(player), savedData);
	}

	/**
	 * This cleans up the onEntityJoinWorld event by replacing most of the code
	 * with a single line: ExtendedPlayer.loadProxyData((EntityPlayer)
	 * event.entity));
	 */
	public static void loadProxyData(EntityPlayer player) {
		ExtendedPlayer playerData = ExtendedPlayer.get(player);
		NBTTagCompound savedData = CommonProxy.getEntityData(getSaveKey(player));

		if (savedData != null) {
			playerData.loadNBTData(savedData);
		}
		// note we renamed 'syncExtendedProperties' to 'syncProperties' because
		// yay, it's shorter
		RPGOMain.network.sendTo(new SyncPlayerProps(player), (EntityPlayerMP) player);

	}

	@Override
	public void init(Entity entity, World world) {
		// TODO Auto-generated method stub

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
		System.out.println("Xp added, xp is now " + this.xp);
		System.out.println("Level is now " + getLevel());
		System.out.println(" add player is " + player.getCommandSenderName());
		ExtendedPlayer.saveProxyData(player);
		ExtendedPlayer.loadProxyData(player);
	}

	public double getXp() {
		// System.out.println("xp got and is " + this.xp);
		// System.out.println("get player is " + player.getCommandSenderName());
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

	public void openWeaponSmith() {
		player.openGui(RPGOMain.instance, Ref.WEAPON_SMITH_GUI, player.getEntityWorld(), MathHelper.floor_double(player.posX), MathHelper.floor_double(player.posY), MathHelper.floor_double(player.posZ));
		
		// this.openContainer.windowId = this.currentWindowId;
		// this.openContainer.addCraftingToCrafters(this);

	}
}
