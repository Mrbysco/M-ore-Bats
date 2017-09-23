package com.svennieke.MOreBats.init;

import com.svennieke.MOreBats.MOreBats;
import com.svennieke.MOreBats.Reference;
import com.svennieke.MOreBats.entity.EntityGuanoProjectile;
import com.svennieke.MOreBats.entity.EntityOreBat;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class MOreEntities {

	public static void register() {		
		System.out.println("Registering Ore Bat");
		EntityRegistry.registerModEntity(ORE_BAT_REGISTRY, EntityOreBat.class, ORE_BAT, 0, MOreBats.instance, 80, 3, true, 3421236, 3556687);
		
		EntityRegistry.registerModEntity(GUANO_REGISTRY, EntityGuanoProjectile.class, GUANO, 1, MOreBats.instance, 80, 3, true);
	}
	
	public static final String ORE_BAT = Reference.MOD_PREFIX + "OreBat";
	public static final String GUANO = Reference.MOD_PREFIX + "Guano";
		
	public static final ResourceLocation ORE_BAT_REGISTRY = Name("ore_bat");
	public static final ResourceLocation GUANO_REGISTRY = Name("guano");
		
	private static ResourceLocation Name(String s) {
			return new ResourceLocation(Reference.MOD_ID, s);
	}
}
