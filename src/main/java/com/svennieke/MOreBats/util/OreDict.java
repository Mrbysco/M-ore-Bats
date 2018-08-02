package com.svennieke.MOreBats.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
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
	
	public static String getItemInfo(String oreName)
	{
		NonNullList<ItemStack> ingotList = OreDictionary.getOres(oreName.replace("ore", "ingot"));
		NonNullList<ItemStack> genList = OreDictionary.getOres(oreName.replace("ore", "gem"));
		if(!ingotList.isEmpty())
		{
			ItemStack ingotStack = ingotList.get(0);
			Item ingot = ingotStack.getItem();
			String ingotInfo = ingot.getRegistryName().getResourceDomain() + ":" + ingot.getRegistryName().getResourcePath();
			if(ingotStack.getMetadata() > 0)
			{
				ingotInfo = ingotInfo + "|" + ingotStack.getCount() + "|" + ingotStack.getMetadata();
			}
			else if(ingotStack.getCount() > 1)
			{
				ingotInfo = ingotInfo + "|" + ingotStack.getCount();
			}
			
			return ingotInfo;
		}
		else if(!genList.isEmpty())
		{
			ItemStack gemStack = genList.get(0);
			Item gem = gemStack.getItem();
			String gemInfo = gem.getRegistryName().getResourceDomain() + ":" + gem.getRegistryName().getResourcePath();
			if(gemStack.getMetadata() > 0)
			{
				gemInfo = gemInfo + "|" + gemStack.getCount() + "|" + gemStack.getMetadata();
			}
			else if(gemStack.getCount() > 1)
			{
				gemInfo = gemInfo + "|" + gemStack.getCount();
			}
			
			return gemInfo;
		}
		else
		{
			return "";
		}
	}
}
