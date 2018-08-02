package com.svennieke.MOreBats.item;

import com.svennieke.MOreBats.MOreBats;
import com.svennieke.MOreBats.Reference;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemOreChunk extends Item
{
	public ItemOreChunk(String registry) {
		this.setUnlocalizedName(Reference.MOD_PREFIX + registry.replaceAll("_", ""));
		this.setRegistryName(registry);
		this.setCreativeTab(MOreBats.instance.tabBats);
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		String name = this.getRegistryName().getResourcePath().replace("_chunk", "");
		String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);
		return I18n.format("item.morebats:orechunk.name", new Object[] {capitalizedName});
	}
}