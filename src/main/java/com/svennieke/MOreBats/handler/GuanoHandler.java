package com.svennieke.MOreBats.handler;

import java.util.List;

import com.svennieke.MOreBats.entities.entity.EntityOreBat;
import com.svennieke.MOreBats.init.MOreItems;
import com.svennieke.MOreBats.util.OreList;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class GuanoHandler 
{	
	@SubscribeEvent
	public void onLivingDrop(LivingDropsEvent event) {
		Entity entity = event.getEntity();
		if(entity instanceof EntityOreBat)
		{
			EntityOreBat bat = (EntityOreBat)entity;
			String ore = bat.getOre();
			ItemStack stack = new ItemStack(MOreItems.guano_projectile, 1);
			NBTTagCompound nbt;
	        if (stack.hasTagCompound())
	        {
	            nbt = stack.getTagCompound();
	        }
	        else
	        {
	            nbt = new NBTTagCompound();
	        }
		    
		    if (nbt.hasKey("Ore"))
		    {
		    	nbt.setString("Ore", ore);
		    }
		    else
		    {
		    	nbt.setString("Ore", ore);
		    }
	        stack.setTagCompound(nbt);
			
			ItemStack newStack = stack.copy();
			System.out.println(newStack);

			event.getDrops().add(new EntityItem(entity.world, entity.posX, entity.posY, entity.posZ, newStack));
		}
	}
	
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event) {
		
		Entity entity = event.getEntityLiving();
		
		if(entity instanceof EntityOreBat)
		{
			//System.out.println("IM ALIVE");
		}
	}
	
	@SubscribeEvent
	public void InWorldCrafting(TickEvent.PlayerTickEvent event) {
		if (event.phase.equals(TickEvent.Phase.START) && event.side.isServer())
		{
			EntityPlayer player = event.player;
			World world = player.world;
			
			List<Entity> entitylist = player.world.loadedEntityList;
			
			for (Entity entity : entitylist)
			{
				if (entity instanceof EntityItem) {
					EntityItem itemEntity = (EntityItem) entity;
					ItemStack stack = itemEntity.getItem();
					Item item = stack.getItem();
					
					if(item == MOreItems.guano_projectile || item == MOreItems.guano_projectile2 || 
							item == MOreItems.guano_projectile3 || item == MOreItems.guano_projectile4 )
					{	
						BlockPos pos = entity.getPosition();
						Block block = world.getBlockState(pos).getBlock();
						
						if(block == Blocks.WATER || block == Blocks.FLOWING_WATER)
						{
							NBTTagCompound nbt;
					        if (stack.hasTagCompound())
					        {
					            nbt = stack.getTagCompound();
					        }
					        else
					        {
					            nbt = new NBTTagCompound();
					        }
						    
						    if (nbt.hasKey("inWater"))
						    {
						    	nbt.setInteger("inWater", nbt.getInteger("inWater") + 1);
						    }
						    else
						    {
						    	nbt.setInteger("inWater", 1);
						    }
					        stack.setTagCompound(nbt);
					        							
							if(nbt.getInteger("inWater") == 120)
							{
								Item ore = OreList.getItemFromOre(nbt.getString("Ore"));
								ItemStack oreStack = new ItemStack(ore);
								itemEntity.setItem(oreStack);
							}
						}
					}
				}
			}	
		}
	}
}