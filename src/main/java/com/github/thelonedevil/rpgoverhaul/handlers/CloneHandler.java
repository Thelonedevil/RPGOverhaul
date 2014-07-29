package com.github.thelonedevil.rpgoverhaul.handlers;


import com.github.thelonedevil.rpgoverhaul.player.ExtendedPlayer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.PlayerEvent;

/**
 * Created by justin on 29/07/2014.
 */
public class CloneHandler {

    @SubscribeEvent
    public void onClone(PlayerEvent.Clone event) {
        ExtendedPlayer oldP = ExtendedPlayer.get(event.original);
        ExtendedPlayer newP = ExtendedPlayer.get(event.entity);
        NBTTagCompound nbt = new NBTTagCompound();
        oldP.saveNBTData(nbt);
        newP.loadNBTData(nbt);

    }
}
