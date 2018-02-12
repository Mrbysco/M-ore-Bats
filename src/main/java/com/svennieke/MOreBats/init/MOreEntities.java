package com.svennieke.MOreBats.init;

import com.svennieke.MOreBats.MOreBats;
import com.svennieke.MOreBats.Reference;
import com.svennieke.MOreBats.entities.entity.EntityGuanoProjectile;
import com.svennieke.MOreBats.entities.entity.EntityOreBat;

import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MOreEntities {

	static int ID = 0;
	
	public static void register() {		
		MOreBats.logger.debug("Registering Ore Bat");
		registerEntity("ore_bat", EntityOreBat.class, "OreBat", 80, 3, true, 3421236, 3556687);
		registerEntity("guano", EntityGuanoProjectile.class, "Guano", 80, 3, true);
	}
	
	public static void registerEntity(String registryName, Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates, int eggPrimary, int eggSecondary) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, registryName), entityClass, Reference.MOD_PREFIX + entityName, ID, MOreBats.instance, trackingRange, updateFrequency, sendsVelocityUpdates, eggPrimary, eggSecondary);
		ID++;
	}
	
	public static void registerEntity(String registryName, Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, registryName), entityClass, Reference.MOD_PREFIX + entityName, ID, MOreBats.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
		ID++;
	}
	
	public static void registerTileEntity(Class<? extends TileEntity> tileentityClass, String tilename) {
		GameRegistry.registerTileEntity(tileentityClass, Reference.MOD_ID + tilename);
	}
}
