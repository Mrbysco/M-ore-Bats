package com.svennieke.MOreBats.proxy;

import com.svennieke.MOreBats.entities.entity.EntityGuanoProjectile;
import com.svennieke.MOreBats.entities.entity.EntityOreBat;
import com.svennieke.MOreBats.render.entity.RenderOreBat;
import com.svennieke.MOreBats.render.projectile.RenderGuanoProjectile;

import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy{

	@Override
	public void Preinit() {
		RenderingRegistry.registerEntityRenderingHandler(EntityGuanoProjectile.class, new RenderGuanoProjectile());
		RenderingRegistry.registerEntityRenderingHandler(EntityOreBat.class, RenderOreBat.FACTORY);
	}
	
	@Override
	public void Init() {
		
	}
	
	@Override
	public void PostInit() {
		
	}
}
