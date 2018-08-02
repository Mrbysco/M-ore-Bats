package com.svennieke.MOreBats.config;

import com.svennieke.MOreBats.Reference;
import com.svennieke.MOreBats.util.OreDict;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Reference.MOD_ID)
@Config.LangKey("morebats.config.title")
public class MOreBatsConfigGen {

	@Config.Comment({"General settings"})
	public static General general = new General();
	
	@Config.Comment({"Ore settings"})
	public static Ores ores = new Ores();
	
	@Config.Comment({"Modded Ore settings"})
	public static ModOres modded_ores = new ModOres();
	
	public static class General{
		public int guanochance = 10;
	}

	public static class Ores{
		@Config.Comment("Removing an ore from this list will remove the specified ore from being given by a bat.")
		public String[] vanillaOres = new String[]
				{
					OreDict.OreExists("oreGold") ? "oreGold,minecraft:gold_ingot,16766720" : "",
					OreDict.OreExists("oreIron") ? "oreIron,minecraft:iron_ingot,8329497" : "",
					OreDict.OreExists("oreLapis") ? "oreLapis,minecraft:dye|5|4,2515356" : "",
					OreDict.OreExists("oreDiamond") ? "oreDiamond,minecraft:diamond,12186367" : "",
					OreDict.OreExists("oreRedstone") ? "oreRedstone,minecraft:redstone,16724530" : "",
					OreDict.OreExists("oreEmerald") ? "oreEmerald,minecraft:emerald,5294200" : "",
					OreDict.OreExists("oreQuartz") ? "oreQuartz,minecraft:quartz,12895428" : "",
					OreDict.OreExists("oreCoal") ? "oreCoal,minecraft:coal,6052701" : ""
				};
	}
	
	public static class ModOres{
		@Config.Comment("Removing an ore from this list will remove the specified ore from being given by a bat.")
		public String[] modOres = new String[]
				{
					OreDict.OreExists("oreTin") ? "oreTin," + OreDict.getItemInfo("oreTin") + ",13882581" : "",
					OreDict.OreExists("oreCopper") ? "oreCopper," + OreDict.getItemInfo("oreCopper") + ",12088115" : "",
					OreDict.OreExists("oreLead") ? "oreLead," + OreDict.getItemInfo("oreLead") + ",12632256" : "",
					OreDict.OreExists("oreAluminum") ? "oreAluminum," + OreDict.getItemInfo("oreAluminum") + ",7170661" : "",
					OreDict.OreExists("oreNickel") ? "oreNickel," + OreDict.getItemInfo("oreNickel") + ",11383485" : "",
					OreDict.OreExists("orePlatinum") ? "orePlatinum," + OreDict.getItemInfo("orePlatinum") + ",15066338" : "",
					OreDict.OreExists("oreIridium") ? "oreIridium," + OreDict.getItemInfo("oreIridium") + ",16777215" : "",
					OreDict.OreExists("oreMithril") ? "oreMithril," + OreDict.getItemInfo("oreMithril") + ",11451355" : ""
				};
	}
	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	private static class EventHandler {

		@SubscribeEvent
		public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(Reference.MOD_ID)) {
				ConfigManager.sync(Reference.MOD_ID, Config.Type.INSTANCE);
			}
		}
	}
}
