package com.svennieke.MOreBats;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.svennieke.MOreBats.config.MOreBatsConfigGen;
import com.svennieke.MOreBats.entities.entity.EntityOreBat;
import com.svennieke.MOreBats.handler.GuanoHandler;
import com.svennieke.MOreBats.init.MOreCrafting;
import com.svennieke.MOreBats.init.MOreEntities;
import com.svennieke.MOreBats.init.MOreTab;
import com.svennieke.MOreBats.proxy.CommonProxy;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, 
	name = Reference.MOD_NAME, 
	version = Reference.VERSION, 
	acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS,
	dependencies = Reference.DEPENDENCIES)

public class MOreBats {
	@Instance(Reference.MOD_ID)
	public static MOreBats instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final Logger logger = LogManager.getLogger(Reference.MOD_ID);
	
	public static MOreTab tabBats = new MOreTab();
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event)
	{
		logger.debug("Registering config / checking config");
		MinecraftForge.EVENT_BUS.register(new MOreBatsConfigGen());
		
		MOreEntities.register();
		proxy.Preinit();
	}
	
	@EventHandler
    public void init(FMLInitializationEvent event)
	{
		logger.debug("Registering Ore Bat Spawn");
		for (Biome biome : Biome.REGISTRY) {
		    biome.getSpawnableList(EnumCreatureType.AMBIENT).add(new SpawnListEntry(EntityOreBat.class, 4, 1, 2));
		}
		
		logger.debug("Registering Event");
		MinecraftForge.EVENT_BUS.register(new GuanoHandler());
		proxy.Init();
		
		MOreCrafting.init();
    }
	
	@EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
		proxy.PostInit();
    }
}
