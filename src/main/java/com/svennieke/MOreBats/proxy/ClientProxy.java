package com.svennieke.MOreBats.proxy;

import com.svennieke.MOreBats.entity.EntityGuanoProjectile;
import com.svennieke.MOreBats.entity.EntityOreBat;
import com.svennieke.MOreBats.init.MOreBlocks;
import com.svennieke.MOreBats.init.MOreItems;
import com.svennieke.MOreBats.render.entity.RenderOreBat;
import com.svennieke.MOreBats.render.projectile.RenderGuanoProjectile;

import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy{

	@Override
	public void Preinit() {
		MOreBlocks.registerRenders();
		MOreItems.registerRenders();
		
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
