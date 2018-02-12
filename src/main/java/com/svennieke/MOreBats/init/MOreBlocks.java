package com.svennieke.MOreBats.init;

import java.util.ArrayList;

import com.svennieke.MOreBats.block.BlockGuano;
import com.svennieke.MOreBats.config.MOreBatsConfigGen;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class MOreBlocks {
	public static BlockGuano gold_guano, iron_guano, lapis_guano, diamond_guano, redstone_guano, emerald_guano, quartz_guano, coal_guano;
	
	public static ArrayList<Block> BLOCKS = new ArrayList<>();
	
	@SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
		IForgeRegistry<Block> registry = event.getRegistry();

		//Registering ore guano if ores exist
		if(MOreBatsConfigGen.ores.goldOre)
		{
			gold_guano = registerBlock(new BlockGuano("gold_guano"));
		}
		
		if(MOreBatsConfigGen.ores.ironOre)
		{
			iron_guano = registerBlock(new BlockGuano("iron_guano"));
		}
		
		if(MOreBatsConfigGen.ores.lapisOre)
		{
			lapis_guano = registerBlock(new BlockGuano("lapis_guano"));
		}
		
		if(MOreBatsConfigGen.ores.diamondOre)
		{
			diamond_guano = registerBlock(new BlockGuano("diamond_guano"));
		}
		
		if(MOreBatsConfigGen.ores.redstoneOre)
		{
			redstone_guano = registerBlock(new BlockGuano("redstone_guano"));
		}
		
		if(MOreBatsConfigGen.ores.emeraldOre)
		{
			emerald_guano = registerBlock(new BlockGuano("emerald_guano"));
		}
		
		if(MOreBatsConfigGen.ores.quartzOre)
		{
			quartz_guano = registerBlock(new BlockGuano("quartz_guano"));
		}
		
		if(MOreBatsConfigGen.ores.coalOre)
		{
			coal_guano = registerBlock(new BlockGuano("coal_guano"));
		}
		
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
