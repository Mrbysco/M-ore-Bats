package com.svennieke.MOreBats.item;

import com.svennieke.MOreBats.MOreBats;

import net.minecraft.item.Item;

public class ItemOreChunk extends Item
{
	public ItemOreChunk(String unlocalised, String registry) {
		setUnlocalizedName(unlocalised);
		setRegistryName(registry);
		setCreativeTab(MOreBats.instance.tabBats);
	}
}