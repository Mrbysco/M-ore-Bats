package com.svennieke.MOreBats.init;

import java.util.ArrayList;
import java.util.List;

import com.svennieke.MOreBats.util.OreList;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MOreCrafting 
{
	public static void init()
	{
    	List<String> ores = new ArrayList<String>(OreList.getOreList());

    	if(!ores.isEmpty())
    	{
    		for(int i = 0; i < ores.size(); i++)
    		{
    			String ore = ores.get(i);
    			String[] splitOre = ore.split(",");
    			if(splitOre[1].contains("Lapis"))
    			{
    				if(splitOre.length > 1)
    				{
    					String chunk = splitOre[1];
    					String outputOre = splitOre[2];
    					Item oreChunk = OreList.getItemFromOre(chunk);
    					
    					GameRegistry.addSmelting(new ItemStack(oreChunk), outputStack(outputOre), 0.2F);
    				}
    			}
    		}
    	}
	}
	
	public static ItemStack outputStack(String splitItem) {
		ItemStack output = new ItemStack(Items.COAL);
		
		String[] splitOutput = splitItem.split("|");
		if(splitOutput.length > 1)
		{
			if(splitOutput.length == 2)
			{
				return output = new ItemStack(Item.getByNameOrId(splitOutput[1]), Integer.valueOf(splitOutput[2]));
			}
			else if(splitOutput.length == 3)
			{
				return output = new ItemStack(Item.getByNameOrId(splitOutput[1]), Integer.valueOf(splitOutput[2], Integer.valueOf(splitOutput[3])));
			}
		}
		return output;
	}
}