package com.svennieke.MOreBats.util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;

import com.google.common.base.Preconditions;
import com.svennieke.MOreBats.config.MOreBatsConfigGen;
import com.svennieke.MOreBats.init.MOreBlocks;
import com.svennieke.MOreBats.init.MOreItems;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class OreList {
	public static final Random rand = new Random();
	
	public static List<String> getOreList()
	{
		String[] vanillaOres = MOreBatsConfigGen.ores.vanillaOres;
		String[] moddedOres = MOreBatsConfigGen.modded_ores.modOres;
		String[] allOres = (String[])ArrayUtils.addAll(vanillaOres, moddedOres);
		
		List<String> oreList = new ArrayList<String>(Arrays.asList(allOres));
		oreList.removeAll(Collections.singleton(""));
		
		return oreList;
	}
	
	public static String getRandomOre()
	{
		List<String> ores = new ArrayList<String>(getOreList());
		
		String randomOre = "";
		if(!ores.isEmpty())
		{
			int idx = rand.nextInt(ores.size());
			randomOre = (ores.get(idx));
		}
		return OreDict.OreExists(randomOre) ? randomOre : "";
	}
	
	public static <T> T getRandomFromList(List<T> list) {
        return getRandomFromList(list, rand);
    }

    public static <T> T getRandomFromList(List<T> list, Random rand) {
        final int size = list.size();
        Preconditions.checkArgument(size > 0, "Can't select from empty list");
        if (size == 0) return null;
        if (size == 1) return list.get(0);
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
    
    public static Item getItemFromOre(String ore)
    {
    	List<String> ores = new ArrayList<String>(getOreList());

    	Item oreItem = MOreItems.ore_chunk[0];

		for(int i = 0 ; i < ores.size(); i++)
		{
			oreItem = MOreItems.ore_chunk[i];
		}
    	
		return oreItem;
    }
    
    public static Block getBlockFromName(String blockName)
    {
    	List<String> ores = new ArrayList<String>(getOreList());
    	
    	Block guanoBlock = Blocks.SNOW;
    	
    	if(MOreBlocks.ore_guano.length != 0)
    	guanoBlock = MOreBlocks.ore_guano[0];

    	if(!ores.isEmpty())
    	{
    		for(int i = 0 ; i < ores.size(); i++)
    		{
    			guanoBlock = MOreBlocks.ore_guano[i];
    		}
    	}
    	
    	return guanoBlock;
    }
    
    public static String convertBlockName(String blockName)
    {
    	List<String> ores = new ArrayList<String>(getOreList());
    	String oreName = "oreCoal";
    	if(!ores.isEmpty())
    	{
	    	for(int i = 0 ; i < ores.size(); i++)
	    	{
	    		String ore = ores.get(i);
	    		if(blockName.contains(ore.replace("ore", "").toLowerCase()))
	    		{
	    			oreName = ores.get(i);
	    		}
	    	}
    	}
    	
    	return oreName;
    }
}
