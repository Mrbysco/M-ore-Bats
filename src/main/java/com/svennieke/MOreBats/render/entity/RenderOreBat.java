package com.svennieke.MOreBats.render.entity;

import com.svennieke.MOreBats.entity.EntityOreBat;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBat;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderOreBat extends RenderBat{
	
	public static final Factory FACTORY = new Factory();
	
	public RenderOreBat(RenderManager renderManagerIn) {
		super(renderManagerIn);
	}
	
	public static class Factory implements IRenderFactory<EntityOreBat> {
		
		@Override
		public Render<? super EntityOreBat> createRenderFor(RenderManager renderManager) {
			return new RenderOreBat(renderManager);
		}
	}
}
