package com.svennieke.MOreBats.render.entity;

import java.awt.Color;

import com.svennieke.MOreBats.entity.EntityOreBat;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

public class BatLayer implements LayerRenderer<EntityOreBat> 
{
	private final RenderOreBat renderer;
	
    private static final ResourceLocation BAT_OVERLAY = new ResourceLocation("textures/entity/bat.png");
	
	public BatLayer(RenderOreBat rendererIn)
    {
        this.renderer = rendererIn;
    }
	
	@Override
	public void doRenderLayer(EntityOreBat entitylivingbaseIn, float limbSwing, float limbSwingAmount,
			float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		if (BAT_OVERLAY != null)
		{
			this.renderer.bindTexture(BAT_OVERLAY);
			GlStateManager.disableBlend();
	        GlStateManager.enableAlpha();
	        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE_MINUS_DST_COLOR, GlStateManager.DestFactor.ONE);
	        
	        Color color = entitylivingbaseIn.overlayColor();
	        GlStateManager.color((float)color.getRed()/255F, (float)color.getGreen()/255F, (float)color.getBlue()/255F, 0.8F);
	        
	        this.renderer.getMainModel().render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); 
		}
		
	}

	@Override
	public boolean shouldCombineTextures() 
	{
		return false;
	}

}
