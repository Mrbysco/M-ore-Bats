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
	public static Block guano, guano2, guano3, guano4;
	
	public static void init()
	{
		guano = new BlockGuano("guano_block", "guano_block", 1);
		guano2 = new BlockGuano("guano_block2", "guano_block2", 2);
		guano3 = new BlockGuano("guano_block3", "guano_block3", 3);
		guano4 = new BlockGuano("guano_block4", "guano_block4", 4);
	}
	
	public static void register()
	{
		registerBlock(guano);
		registerBlock(guano2);
		registerBlock(guano3);
		registerBlock(guano4);
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
		registerRender(guano2);
		registerRender(guano3);
		registerRender(guano4);
	}
	
	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
}
}
