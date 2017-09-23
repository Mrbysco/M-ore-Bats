package com.svennieke.MOreBats.init;

import com.svennieke.MOreBats.block.BlockGuano;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class MOreBlocks {
	public static Block guano;
	
	public static void init()
	{
		guano = new BlockGuano("guano_block", "guano_block");
	}
	
	public static void register()
	{
		registerBlock(guano);
	}
	
	public static void registerBlock(Block block) 
	{
		registerBlock(block, new ItemBlock(block));
	}
	
	public static void registerBlock(Block block, ItemBlock item) 
	{
		ForgeRegistries.BLOCKS.register(block);
		item.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(item);
	}
	
	public static void registerRenders()
	{
		registerRender(guano);
	}
	
	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
}
}
