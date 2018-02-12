package com.svennieke.MOreBats.init;

import java.util.ArrayList;

import com.svennieke.MOreBats.MOreBats;
import com.svennieke.MOreBats.config.MOreBatsConfigGen;
import com.svennieke.MOreBats.item.ItemGuanoProjectile;
import com.svennieke.MOreBats.item.ItemOreChunk;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class MOreItems {
	public static Item guano_projectile, guano_projectile2, guano_projectile3, guano_projectile4;
	
	//Vanilla Ores
	public static Item gold_chunk, iron_chunk, lapis_chunk, diamond_chunk, redstone_chunk, emerald_chunk, quartz_chunk, coal_chunk;
	
	public static ArrayList<Item> ITEMS = new ArrayList<>();
	
	@SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> registry = event.getRegistry();

        guano_projectile = registerItem(new ItemGuanoProjectile("guano_projectile", 1));
		guano_projectile2 = registerItem(new ItemGuanoProjectile("guano_projectile2", 2));
		guano_projectile3 = registerItem(new ItemGuanoProjectile("guano_projectile3", 3));
		guano_projectile4 = registerItem(new ItemGuanoProjectile("guano_projectile4", 4));
		
		//Registering chunks if vanilla ores still exist
		if(MOreBatsConfigGen.ores.goldOre)
		{
			gold_chunk = registerItem(new ItemOreChunk("gold_chunk"));
		}
		
		if(MOreBatsConfigGen.ores.ironOre)
		{
			MOreBats.logger.debug("Iron exists");
			iron_chunk = registerItem(new ItemOreChunk("iron_chunk"));
		}
		
		if(MOreBatsConfigGen.ores.lapisOre)
		{
			MOreBats.logger.debug("Lapis exists");
			lapis_chunk = registerItem(new ItemOreChunk("lapis_chunk"));
		}
		
		if(MOreBatsConfigGen.ores.diamondOre)
		{
			MOreBats.logger.debug("Diamond exists");
			diamond_chunk = registerItem(new ItemOreChunk("diamond_chunk"));
		}
		
		if(MOreBatsConfigGen.ores.redstoneOre)
		{
			MOreBats.logger.debug("Redstone exists");
			redstone_chunk = registerItem(new ItemOreChunk("redstone_chunk"));
		}
		
		if(MOreBatsConfigGen.ores.emeraldOre)
		{
			MOreBats.logger.debug("Emerald exists");
			emerald_chunk = registerItem(new ItemOreChunk("emerald_chunk"));
		}
		
		if(MOreBatsConfigGen.ores.quartzOre)
		{
			MOreBats.logger.debug("Quartz exists");
			quartz_chunk = registerItem(new ItemOreChunk("quartz_chunk"));
		}
		
		if(MOreBatsConfigGen.ores.coalOre)
		{
			MOreBats.logger.debug("Coal exists");
			coal_chunk = registerItem(new ItemOreChunk("coal_chunk"));
		}
		
        registry.registerAll(ITEMS.toArray(new Item[0]));
    }
	
	public static <T extends Item> T registerItem(T item)
    {
        ITEMS.add(item);
        return item;
    }
}
