package com.svennieke.MOreBats.init;

import com.svennieke.MOreBats.MOreBats;
import com.svennieke.MOreBats.config.MOreBatsConfigGen;
import com.svennieke.MOreBats.item.ItemGuanoProjectile;
import com.svennieke.MOreBats.item.ItemOreChunk;
import com.svennieke.MOreBats.util.OreDict;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class MOreItems {
	public static Item guano_projectile, guano_projectile2, guano_projectile3, guano_projectile4;
	
	//Vanilla Ores
	public static Item gold_chunk, iron_chunk, lapis_chunk, diamond_chunk, redstone_chunk, emerald_chunk, quartz_chunk, coal_chunk;
	
	public static void init(){
		guano_projectile = new ItemGuanoProjectile("guano_projectile", "guano_projectile", 1);
		guano_projectile2 = new ItemGuanoProjectile("guano_projectile2", "guano_projectile2", 2);
		guano_projectile3 = new ItemGuanoProjectile("guano_projectile3", "guano_projectile3", 3);
		guano_projectile4 = new ItemGuanoProjectile("guano_projectile4", "guano_projectile4", 4);
		
		//Registering chunks if vanilla ores still exist
		if(MOreBatsConfigGen.ores.goldOre)
		{
			gold_chunk = new ItemOreChunk("gold_chunk", "gold_chunk");
		}
		
		if(MOreBatsConfigGen.ores.ironOre)
		{
			MOreBats.logger.debug("Iron exists");
			iron_chunk = new ItemOreChunk("iron_chunk", "iron_chunk");
		}
		
		if(MOreBatsConfigGen.ores.lapisOre)
		{
			MOreBats.logger.debug("Lapis exists");
			lapis_chunk = new ItemOreChunk("lapis_chunk", "lapis_chunk");
		}
		
		if(MOreBatsConfigGen.ores.diamondOre)
		{
			MOreBats.logger.debug("Diamond exists");
			diamond_chunk = new ItemOreChunk("diamond_chunk", "diamond_chunk");
		}
		
		if(MOreBatsConfigGen.ores.redstoneOre)
		{
			MOreBats.logger.debug("Redstone exists");
			redstone_chunk = new ItemOreChunk("redstone_chunk", "redstone_chunk");
		}
		
		if(MOreBatsConfigGen.ores.emeraldOre)
		{
			MOreBats.logger.debug("Emerald exists");
			emerald_chunk = new ItemOreChunk("emerald_chunk", "emerald_chunk");
		}
		
		if(MOreBatsConfigGen.ores.quartzOre)
		{
			MOreBats.logger.debug("Quartz exists");
			quartz_chunk = new ItemOreChunk("quartz_chunk", "quartz_chunk");
		}
		
		if(MOreBatsConfigGen.ores.coalOre)
		{
			MOreBats.logger.debug("Coal exists");
			coal_chunk = new ItemOreChunk("coal_chunk", "coal_chunk");
		}
	}
	
	public static void register()
	{
		ForgeRegistries.ITEMS.register(guano_projectile);
		ForgeRegistries.ITEMS.register(guano_projectile2);
		ForgeRegistries.ITEMS.register(guano_projectile3);
		ForgeRegistries.ITEMS.register(guano_projectile4);
		
		if(MOreBatsConfigGen.ores.goldOre)
		{
			ForgeRegistries.ITEMS.register(gold_chunk);
		}
		
		if(MOreBatsConfigGen.ores.ironOre)
		{
			ForgeRegistries.ITEMS.register(iron_chunk);
		}
		
		if(MOreBatsConfigGen.ores.lapisOre)
		{
			ForgeRegistries.ITEMS.register(lapis_chunk);
		}
		
		if(MOreBatsConfigGen.ores.diamondOre)
		{
			ForgeRegistries.ITEMS.register(diamond_chunk);
		}
		
		if(MOreBatsConfigGen.ores.redstoneOre)
		{
			ForgeRegistries.ITEMS.register(redstone_chunk);
		}
		
		if(MOreBatsConfigGen.ores.emeraldOre)
		{
			ForgeRegistries.ITEMS.register(emerald_chunk);
		}
		
		if(MOreBatsConfigGen.ores.quartzOre)
		{
			ForgeRegistries.ITEMS.register(quartz_chunk);
		}
		
		if(MOreBatsConfigGen.ores.coalOre)
		{
			ForgeRegistries.ITEMS.register(coal_chunk);
		}
	}
	
	public static void registerRenders()
	{
		registerRender(guano_projectile);
		registerRender(guano_projectile2);
		registerRender(guano_projectile3);
		registerRender(guano_projectile4);
		
		if(MOreBatsConfigGen.ores.goldOre)
		{
			registerRender(gold_chunk);
		}
		
		if(MOreBatsConfigGen.ores.ironOre)
		{
			registerRender(iron_chunk);
		}
		
		if(MOreBatsConfigGen.ores.lapisOre)
		{
			registerRender(lapis_chunk);
		}
		
		if(MOreBatsConfigGen.ores.diamondOre)
		{
			registerRender(diamond_chunk);
		}
		
		if(MOreBatsConfigGen.ores.redstoneOre)
		{
			registerRender(redstone_chunk);
		}
		
		if(MOreBatsConfigGen.ores.emeraldOre)
		{
			registerRender(emerald_chunk);
		}
		
		if(MOreBatsConfigGen.ores.quartzOre)
		{
			registerRender(quartz_chunk);
		}
		
		if(MOreBatsConfigGen.ores.coalOre)
		{
			registerRender(coal_chunk);
		}
	}
	
	public static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
