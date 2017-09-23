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
	
	@Config.Comment({"General settings"})
	public static Ores ores = new Ores();
	
	public static class General{
		public int guanochance = 10;
	}

	public static class Ores{
		@Config.Comment("Setting this to false removes the specified Ore from being given by a bat.")
		public boolean goldOre = OreDict.OreExists("oreGold");
		
		@Config.Comment("Setting this to false removes the specified Ore from being given by a bat.")
		public boolean ironOre = OreDict.OreExists("oreIron");
		
		@Config.Comment("Setting this to false removes the specified Ore from being given by a bat.")
		public boolean lapisOre = OreDict.OreExists("oreLapis");
		
		@Config.Comment("Setting this to false removes the specified Ore from being given by a bat.")
		public boolean diamondOre = OreDict.OreExists("oreDiamond");
		
		@Config.Comment("Setting this to false removes the specified Ore from being given by a bat.")
		public boolean RedstoneOre = OreDict.OreExists("oreRedstone");
		
		@Config.Comment("Setting this to false removes the specified Ore from being given by a bat.")
		public boolean EmeraldOre = OreDict.OreExists("oreEmerald");
		
		@Config.Comment("Setting this to false removes the specified Ore from being given by a bat.")
		public boolean quartzOre = OreDict.OreExists("oreQuartz");
		
		@Config.Comment("Setting this to false removes the specified Ore from being given by a bat.")
		public boolean coalOre = OreDict.OreExists("oreCoal");
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
