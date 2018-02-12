package com.svennieke.MOreBats.render.projectile;

import com.svennieke.MOreBats.entities.entity.EntityGuanoProjectile;

import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderGuanoProjectile implements IRenderFactory<EntityGuanoProjectile>{
	
	@Override
	public Render<? super EntityGuanoProjectile> createRenderFor(RenderManager manager) {
		RenderItem renderer = FMLClientHandler.instance().getClient().getRenderItem();
		return new EntityGuanoRender(manager, renderer);
	}
}
