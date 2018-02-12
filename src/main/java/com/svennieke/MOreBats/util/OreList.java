package com.svennieke.MOreBats.util;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.svennieke.MOreBats.block.BlockGuano;
import com.svennieke.MOreBats.config.MOreBatsConfigGen;
import com.svennieke.MOreBats.init.MOreBlocks;
import com.svennieke.MOreBats.init.MOreItems;

import net.minecraft.item.Item;

public class OreList {
public static final Random rand = new Random();
	
	public static List<String> vanillaOres = ImmutableList.of(
			"oreGold",
			"oreIron",
			"oreLapis",
			"oreDiamond",
			"oreRedstone",
			"oreEmerald",
			"oreQuartz",
			"oreCoal");
	
	public static final List<String> ores = new ArrayList<String>(vanillaOres);
	
	public static String getRandomOre()
	{
		if (MOreBatsConfigGen.modores.tinOre == true) {ores.add("oreTin");}
		if (MOreBatsConfigGen.modores.copperOre == true) {ores.add("oreCopper");}
		if (MOreBatsConfigGen.modores.silverOre == true) {ores.add("oreSilver");}
		if (MOreBatsConfigGen.modores.leadOre == true) {ores.add("oreLead");}
		if (MOreBatsConfigGen.modores.aluminumOre == true) {ores.add("oreAluminum");}
		if (MOreBatsConfigGen.modores.nickelOre == true) {ores.add("oreNickel");}
		if (MOreBatsConfigGen.modores.platinumOre == true) {ores.add("orePlatinum");}
		if (MOreBatsConfigGen.modores.iridiumOre == true) {ores.add("oreIridium");}
		if (MOreBatsConfigGen.modores.mithrilOre == true) {ores.add("oreMithril");}

		String ore = getRandomFromList(ores);
		return ore;
	}
	
	public static <T> T getRandomFromList(List<T> list) {
        return getRandomFromList(list, rand);
    }

    public static <T> T getRandomFromList(List<T> list, Random rand) {
        final int size = list.size();
        Preconditions.checkArgument(size > 0, "Can't select from empty list");
        if (size == 0) return null;
        if (size == 1) return list.get(0);
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
    
    public static Item getItemFromOre(String ore)
    {
    	//basic oreItem
    	Item oreItem = MOreItems.coal_chunk;
    	
    	if (ore.contains("gold"))
    		oreItem = MOreItems.gold_chunk;
    	if (ore.contains("iron"))
    		oreItem = MOreItems.iron_chunk;
    	if (ore.contains("lapis"))
    		oreItem = MOreItems.lapis_chunk;
    	if (ore.contains("diamond"))
    		oreItem = MOreItems.diamond_chunk;
    	if (ore.contains("redstone"))
    		oreItem = MOreItems.redstone_chunk;
    	if (ore.contains("emerald"))
    		oreItem = MOreItems.emerald_chunk;
    	if (ore.contains("quartz"))
    		oreItem = MOreItems.quartz_chunk;
    	if (ore.contains("coal"))
    		oreItem = MOreItems.coal_chunk;
    	
		return oreItem;
    }
    
    public static BlockGuano getBlockFromName(String blockName)
    {
    	BlockGuano guanoBlock = MOreBlocks.coal_guano;
    	
    	if (blockName.contains("Gold"))
    		guanoBlock = MOreBlocks.gold_guano;
    	if (blockName.contains("Iron"))
    		guanoBlock = MOreBlocks.iron_guano;
    	if (blockName.contains("Lapis"))
    		guanoBlock = MOreBlocks.lapis_guano;
    	if (blockName.contains("Diamond"))
    		guanoBlock = MOreBlocks.diamond_guano;
    	if (blockName.contains("Redstone"))
    		guanoBlock = MOreBlocks.redstone_guano;
    	if (blockName.contains("Emerald"))
    		guanoBlock = MOreBlocks.emerald_guano;
    	if (blockName.contains("Quartz"))
    		guanoBlock = MOreBlocks.quartz_guano;
    	if (blockName.contains("Coal"))
    		guanoBlock = MOreBlocks.coal_guano;
    	
    	return guanoBlock;
    }
    
    public static String convertBlockName(String blockName)
    {
    	String oreName = "oreCoal";
    	
    	if (blockName.contains("gold"))
    		oreName = "oreGold";
    	if (blockName.contains("iron"))
    		oreName = "oreIron";
    	if (blockName.contains("lapis"))
    		oreName = "oreLapis";
    	if (blockName.contains("diamond"))
    		oreName = "oreDiamond";
    	if (blockName.contains("redstone"))
    		oreName = "oreRedstone";
    	if (blockName.contains("emerald"))
    		oreName = "oreEmerald";
    	if (blockName.contains("quartz"))
    		oreName = "oreQuartz";
    	if (blockName.contains("coal"))
    		oreName = "oreCoal";
    	
    	return oreName;
    }
}
