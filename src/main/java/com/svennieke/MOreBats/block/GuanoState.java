package com.svennieke.MOreBats.block;

import com.svennieke.MOreBats.Reference;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.util.ResourceLocation;

public class GuanoState extends StateMapperBase{
	
	public GuanoState() {
		
	}
	
	@Override
	protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
		return new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, "ore_guano"), this.getPropertyString(state.getProperties()));
	}
}