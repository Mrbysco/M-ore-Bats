package com.svennieke.MOreBats.init;

import java.util.ArrayList;
import java.util.List;

import com.svennieke.MOreBats.item.ItemGuanoProjectile;
import com.svennieke.MOreBats.item.ItemOreChunk;
import com.svennieke.MOreBats.util.OreDict;
import com.svennieke.MOreBats.util.OreList;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class MOreItems {
	public static Item guano_projectile, guano_projectile2, guano_projectile3, guano_projectile4;
	
	//Vanilla Ores
	public static Item ore_chunk[];
	
	public static ArrayList<Item> ITEMS = new ArrayList<>();
	
	@SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> registry = event.getRegistry();

        guano_projectile = registerItem(new ItemGuanoProjectile("guano_projectile", 1));
		guano_projectile2 = registerItem(new ItemGuanoProjectile("guano_projectile2", 2));
		guano_projectile3 = registerItem(new ItemGuanoProjectile("guano_projectile3", 3));
		guano_projectile4 = registerItem(new ItemGuanoProjectile("guano_projectile4", 4));
		
    	List<String> ores = new ArrayList<String>(OreList.getOreList());
    	if(!ores.isEmpty())
    	{
    		ore_chunk = registerOreChunks(ores);
    	}
		
        registry.registerAll(ITEMS.toArray(new Item[0]));
    }
	
	public static <T extends Item> Item[] registerOreChunks(List<String> ores)
	{
		Item[] allBlocks = new Item[ores.size()];

	    for(int i = 0 ; i < ores.size(); i++)
		{
	    	String oreName = ores.get(i);
			String[] splitOre = oreName.split(",");
			
			try {
				if(splitOre[0] != null && OreDict.OreExists(splitOre[0]))
				{
					allBlocks[i] = registerItem(new ItemOreChunk(splitOre[0].replace("ore","").toLowerCase() + "_chunk"));
				}
	    	} catch (IllegalArgumentException | SecurityException e) {
	    		e.printStackTrace();
	        }
		}
	   
	    return allBlocks;
	}
	
	public static <T extends Item> T registerItem(T item)
    {
        ITEMS.add(item);
        return item;
    }
}
