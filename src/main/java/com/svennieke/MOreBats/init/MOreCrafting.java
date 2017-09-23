package com.svennieke.MOreBats.init;

import com.svennieke.MOreBats.util.OreDict;

import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MOreCrafting 
{
	public static void init()
	{
		if(OreDict.OreExists("oreGold"))
		{
			GameRegistry.addSmelting(new ItemStack(MOreItems.gold_chunk), new ItemStack(Items.GOLD_INGOT), 0.2F);
		}
		
		if(OreDict.OreExists("oreIron"))
		{
			GameRegistry.addSmelting(new ItemStack(MOreItems.iron_chunk), new ItemStack(Items.IRON_INGOT), 0.2F);
		}
		
		if(OreDict.OreExists("oreLapis"))
		{
			GameRegistry.addSmelting(new ItemStack(MOreItems.lapis_chunk), new ItemStack(Items.DYE, 5, EnumDyeColor.BLUE.getDyeDamage()), 0.2F);
		}
		
		if(OreDict.OreExists("oreDiamond"))
		{
			GameRegistry.addSmelting(new ItemStack(MOreItems.diamond_chunk), new ItemStack(Items.DIAMOND), 0.2F);
		}
		
		if(OreDict.OreExists("oreRedstone"))
		{
			GameRegistry.addSmelting(new ItemStack(MOreItems.redstone_chunk), new ItemStack(Items.REDSTONE, 4), 0.2F);
		}
		
		if(OreDict.OreExists("oreEmerald"))
		{
			GameRegistry.addSmelting(new ItemStack(MOreItems.emerald_chunk), new ItemStack(Items.EMERALD), 0.2F);
		}
		
		if(OreDict.OreExists("oreQuartz"))
		{
			GameRegistry.addSmelting(new ItemStack(MOreItems.quartz_chunk), new ItemStack(Items.QUARTZ), 0.2F);
		}
		
		if(OreDict.OreExists("oreCoal"))
		{
			GameRegistry.addSmelting(new ItemStack(MOreItems.coal_chunk), new ItemStack(Items.COAL), 0.2F);
		}
	}
}