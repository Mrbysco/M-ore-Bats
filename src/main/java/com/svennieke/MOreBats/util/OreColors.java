package com.svennieke.MOreBats.util;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.svennieke.MOreBats.MOreBats;

public class OreColors {
	
	public static Color getColor(String name) {	
    	List<String> ores = new ArrayList<String>(OreList.getOreList());
    	Color unknownColor = createColor(5577355);
    	
    	if(!ores.isEmpty())
    	{
    		for(int i = 0; i < ores.size(); i++)
    		{
    			String ore = ores.get(i);
    			String[] splitOre = ore.split(",");
    			if(name.equals(splitOre[0]))
    			{
    				if(splitOre.length >= 3)
    					return createColor(Integer.valueOf(splitOre[2]));
    			}
    		}
    	}
    	
    	MOreBats.logger.warn(name + " does not have a color specified");
    	return unknownColor;
	}
	
	public static int getColorInt(String name) {	
    	List<String> ores = new ArrayList<String>(OreList.getOreList());
    	int unknownColor = 5577355;
    	
    	if(!ores.isEmpty())
    	{
    		for(int i = 0; i < ores.size(); i++)
    		{
    			String ore = ores.get(i);
    			String[] splitOre = ore.split(",");
    			if(name.contains(splitOre[0].replaceAll("ore", "").toLowerCase()))
    			{
    				if(splitOre.length >= 3)
    					return Integer.valueOf(splitOre[2]);
    			}
    		}
    	}
    	
    	MOreBats.logger.warn(name + " does not have a color specified");
    	return unknownColor;
	}
	
	public static Color createColor(int color)
	{
		return new Color(color);
	}
}
