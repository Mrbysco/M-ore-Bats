package com.svennieke.MOreBats.util;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.svennieke.MOreBats.config.MOreBatsConfigGen;

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
}
