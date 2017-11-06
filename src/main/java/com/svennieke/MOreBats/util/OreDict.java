package com.svennieke.MOreBats.util;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDict {
	public static boolean OreExists(String orename)
	{
		if(OreDictionary.doesOreNameExist(orename) == true)
		{
			return true;
		}
		else
		return false;
	}
	
	public static ItemStack GetOreStack(String orename)
	{
		return OreDictionary.getOres(orename).get(0);
	}
}
