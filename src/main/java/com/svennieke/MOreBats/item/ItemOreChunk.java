package com.svennieke.MOreBats.item;

import com.svennieke.MOreBats.MOreBats;
import com.svennieke.MOreBats.Reference;

import net.minecraft.item.Item;

public class ItemOreChunk extends Item
{
	public ItemOreChunk(String registry) {
		this.setUnlocalizedName(Reference.MOD_PREFIX + registry.replaceAll("_", ""));
		this.setRegistryName(registry);
		setCreativeTab(MOreBats.instance.tabBats);
	}
}