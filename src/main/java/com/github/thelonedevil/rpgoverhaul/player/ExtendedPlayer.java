package com.github.thelonedevil.rpgoverhaul.player;

import com.github.thelonedevil.rpgoverhaul.inventory.ArmourInventory;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

import java.util.HashMap;


public class ExtendedPlayer implements IExtendedEntityProperties {

    public static String ID = "RPGO";
    public ArmourInventory armour = new ArmourInventory();
    public double xp = 0;
    private int skillPoints = 0;
    private HashMap<Perks, Boolean> perks = new HashMap<Perks, Boolean>();
    private boolean hasChanges;

    public static ExtendedPlayer get(Entity entity) {
        if (entity != null) {
            return (ExtendedPlayer) entity.getExtendedProperties(ID);
        }

        return null;
    }

    public static void register(Entity entity) {
        entity.registerExtendedProperties(ID, new ExtendedPlayer());
    }

    @Override
    public void saveNBTData(NBTTagCompound tag) {
        tag.setTag("rpgoData", createNBTTagCompound());
    }

    @Override
    public void loadNBTData(NBTTagCompound tag) {
        readFromNBT(tag.getCompoundTag("rpgoData"), true);
    }

    @Override
    public void init(Entity entity, World world) {

    }

    public void readFromNBT(NBTTagCompound tag, boolean fromPacket) {
        armour.readFromNBT(tag);
        xp = tag.getDouble("xp");

        if (fromPacket) {
            hasChanges = true;
        }
    }

    public void writeToNBT(NBTTagCompound tag) {
        armour.writeToNBT(tag);
        tag.setDouble("xp", xp);
    }

    public NBTTagCompound createNBTTagCompound() {
        NBTTagCompound tagCompound = new NBTTagCompound();
        writeToNBT(tagCompound);
        return tagCompound;
    }

    public int getLevel() {
        return MathHelper.floor_double(Math.pow(xp / 100.0, 0.6));
    }
    public double getXp(){
        return xp;
    }

    public void addXp(double xp) {
        int oldlvl = this.getLevel();
        this.xp += xp;
        int newlvl = this.getLevel();
        if (newlvl > oldlvl) {
            levelUp(newlvl);
        }
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

}
