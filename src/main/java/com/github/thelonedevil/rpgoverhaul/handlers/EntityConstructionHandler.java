package com.github.thelonedevil.rpgoverhaul.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;

import com.github.thelonedevil.rpgoverhaul.player.ExtendedPlayer;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EntityConstructionHandler {
	
	@SubscribeEvent
	public void onConstruction(EntityConstructing event){
		if (event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer) event.entity) == null){
			ExtendedPlayer.register((EntityPlayer) event.entity);
			
		}
		if(event.entity instanceof EntityPlayer){
			event.entity.stepHeight = 1F;
			System.out.println("Stepheight changed to :"+ event.entity.stepHeight);
		}
	}

}
