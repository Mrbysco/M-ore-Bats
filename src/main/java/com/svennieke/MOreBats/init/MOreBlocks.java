package com.svennieke.MOreBats.init;

import java.util.ArrayList;
import java.util.List;

import com.svennieke.MOreBats.block.BlockGuano;
import com.svennieke.MOreBats.util.OreDict;
import com.svennieke.MOreBats.util.OreList;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class MOreBlocks {
	public static BlockGuano[] ore_guano;
	
	public static ArrayList<Block> BLOCKS = new ArrayList<>();
	
	@SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
		IForgeRegistry<Block> registry = event.getRegistry();

    	List<String> ores = new ArrayList<String>(OreList.getOreList());    	
    	if(!ores.isEmpty())
    	{
    		ore_guano = registerGuano(ores);
    	}
		
		registry.registerAll(BLOCKS.toArray(new Block[0]));
    }
	
	public static <T extends Block> BlockGuano[] registerGuano(List<String> ores)
	{
	    BlockGuano[] allBlocks = new BlockGuano[ores.size()];

	    for(int i = 0 ; i < ores.size(); i++)
		{
	    	String oreName = ores.get(i);
			String[] splitOre = oreName.split(",");
			
			try {
				if(splitOre[0] != null && OreDict.OreExists(splitOre[0]))
				{
					allBlocks[i] = registerBlock(new BlockGuano(splitOre[0].replace("ore","").toLowerCase() + "_guano"));
				}
	    	} catch (IllegalArgumentException | SecurityException e) {
	    		e.printStackTrace();
	        }
		}
	   
	    return allBlocks;
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
