package com.svennieke.MOreBats.init;

import com.svennieke.MOreBats.MOreBats;
import com.svennieke.MOreBats.item.ItemGuanoProjectile;
import com.svennieke.MOreBats.item.ItemOreChunk;
import com.svennieke.MOreBats.util.OreDict;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class MOreItems {
	public static Item guano_projectile;
	
	//Vanilla Ores
	public static Item gold_chunk, iron_chunk, lapis_chunk, diamond_chunk, redstone_chunk, emerald_chunk, quartz_chunk, coal_chunk;
	
	public static void init(){
		guano_projectile = new ItemGuanoProjectile("guano_projectile", "guano_projectile");
		
		//Registering chunks if vanilla ores still exist
		if(OreDict.OreExists("oreGold"))
		{
			MOreBats.logger.debug("Gold exists");
			gold_chunk = new ItemOreChunk("gold_chunk", "gold_chunk");
		}
		
		if(OreDict.OreExists("oreIron"))
		{
			MOreBats.logger.debug("Iron exists");
			iron_chunk = new ItemOreChunk("iron_chunk", "iron_chunk");
		}
		
		if(OreDict.OreExists("oreLapis"))
		{
			MOreBats.logger.debug("Lapis exists");
			lapis_chunk = new ItemOreChunk("lapis_chunk", "lapis_chunk");
		}
		
		if(OreDict.OreExists("oreDiamond"))
		{
			MOreBats.logger.debug("Diamond exists");
			diamond_chunk = new ItemOreChunk("diamond_chunk", "diamond_chunk");
		}
		
		if(OreDict.OreExists("oreRedstone"))
		{
			MOreBats.logger.debug("Redstone exists");
			redstone_chunk = new ItemOreChunk("redstone_chunk", "redstone_chunk");
		}
		
		if(OreDict.OreExists("oreEmerald"))
		{
			MOreBats.logger.debug("Emerald exists");
			emerald_chunk = new ItemOreChunk("emerald_chunk", "emerald_chunk");
		}
		
		if(OreDict.OreExists("oreQuartz"))
		{
			MOreBats.logger.debug("Quartz exists");
			quartz_chunk = new ItemOreChunk("quartz_chunk", "quartz_chunk");
		}
		
		if(OreDict.OreExists("oreCoal"))
		{
			MOreBats.logger.debug("Coal exists");
			coal_chunk = new ItemOreChunk("coal_chunk", "coal_chunk");
		}
	}
	
	public static void register()
	{
		ForgeRegistries.ITEMS.register(guano_projectile);
		
		if(OreDict.OreExists("oreGold"))
		{
			ForgeRegistries.ITEMS.register(gold_chunk);
		}
		
		if(OreDict.OreExists("oreIron"))
		{
			ForgeRegistries.ITEMS.register(iron_chunk);
		}
		
		if(OreDict.OreExists("oreLapis"))
		{
			ForgeRegistries.ITEMS.register(lapis_chunk);
		}
		
		if(OreDict.OreExists("oreDiamond"))
		{
			ForgeRegistries.ITEMS.register(diamond_chunk);
		}
		
		if(OreDict.OreExists("oreRedstone"))
		{
			ForgeRegistries.ITEMS.register(redstone_chunk);
		}
		
		if(OreDict.OreExists("oreEmerald"))
		{
			ForgeRegistries.ITEMS.register(emerald_chunk);
		}
		
		if(OreDict.OreExists("oreQuartz"))
		{
			ForgeRegistries.ITEMS.register(quartz_chunk);
		}
		
		if(OreDict.OreExists("oreCoal"))
		{
			ForgeRegistries.ITEMS.register(coal_chunk);
		}
	}
	
	public static void registerRenders()
	{
		registerRender(guano_projectile);
		
		if(OreDict.OreExists("oreGold"))
		{
			registerRender(gold_chunk);
		}
		
		if(OreDict.OreExists("oreIron"))
		{
			registerRender(iron_chunk);
		}
		
		if(OreDict.OreExists("oreLapis"))
		{
			registerRender(lapis_chunk);
		}
		
		if(OreDict.OreExists("oreDiamond"))
		{
			registerRender(diamond_chunk);
		}
		
		if(OreDict.OreExists("oreRedstone"))
		{
			registerRender(redstone_chunk);
		}
		
		if(OreDict.OreExists("oreEmerald"))
		{
			registerRender(emerald_chunk);
		}
		
		if(OreDict.OreExists("oreQuartz"))
		{
			registerRender(quartz_chunk);
		}
		
		if(OreDict.OreExists("oreCoal"))
		{
			registerRender(coal_chunk);
		}
	}
	
	public static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
