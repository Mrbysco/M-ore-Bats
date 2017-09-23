package com.svennieke.MOreBats.handler;

import com.svennieke.MOreBats.entity.EntityOreBat;

import net.minecraft.entity.Entity;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GuanoHandler 
{	
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event) {
		Entity entity = event.getEntityLiving();
		
		if(entity instanceof EntityOreBat)
		{
			System.out.println("IM ALIVE");
		}
	}
}
