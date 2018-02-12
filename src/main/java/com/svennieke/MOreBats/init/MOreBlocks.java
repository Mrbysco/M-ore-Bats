package com.svennieke.MOreBats.init;

import java.util.ArrayList;

import com.svennieke.MOreBats.block.BlockGuano;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class MOreBlocks {
	public static Block guano, guano2, guano3, guano4;
	public static Block washer, washer_running;
	
	public static ArrayList<Block> BLOCKS = new ArrayList<>();
	
	@SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
		IForgeRegistry<Block> registry = event.getRegistry();
		
		guano = registerBlock(new BlockGuano("guano_block", 1));
		guano2 = registerBlock(new BlockGuano("guano_block2", 2));
		guano3 = registerBlock(new BlockGuano("guano_block3", 3));
		guano4 = registerBlock(new BlockGuano("guano_block4", 4));
		
		registry.registerAll(BLOCKS.toArray(new Block[0]));
    }
	
	public static <T extends Block> T registerBlock(T block)
    {
        return registerBlock(block, new ItemBlock(block));
    }
    
    public static <T extends Block> T registerBlock(T block, ItemBlock item)
    {
    	item.setRegistryName(block.getRegistryName());
    	MOreItems.ITEMS.add(item);
        BLOCKS.add(block);
        return block;
    }
}
