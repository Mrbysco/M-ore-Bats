package com.svennieke.MOreBats.render.projectile;

import com.svennieke.MOreBats.entities.entity.EntityGuanoProjectile;
import com.svennieke.MOreBats.init.MOreItems;

import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class EntityGuanoRender extends RenderSnowball<EntityGuanoProjectile>{
	public static final Factory FACTORY = new Factory();
	
	public EntityGuanoRender(RenderManager renderManagerIn, RenderItem renderItem) {
		super(renderManagerIn, MOreItems.guano_projectile, renderItem);
	}

	public static class Factory implements IRenderFactory<EntityGuanoProjectile> {
	    @Override
	    public Render<? super EntityGuanoProjectile> createRenderFor(RenderManager manager) {
			RenderItem renderer = FMLClientHandler.instance().getClient().getRenderItem();
			return new EntityGuanoRender(manager, renderer);
		}
	}
}
