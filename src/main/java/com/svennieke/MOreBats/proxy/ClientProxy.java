package com.svennieke.MOreBats.proxy;

import com.svennieke.MOreBats.Reference;
import com.svennieke.MOreBats.block.GuanoState;
import com.svennieke.MOreBats.entities.entity.EntityGuanoProjectile;
import com.svennieke.MOreBats.entities.entity.EntityOreBat;
import com.svennieke.MOreBats.init.MOreBlocks;
import com.svennieke.MOreBats.init.MOreItems;
import com.svennieke.MOreBats.item.ItemOreChunk;
import com.svennieke.MOreBats.render.entity.RenderOreBat;
import com.svennieke.MOreBats.render.projectile.EntityGuanoRender;
import com.svennieke.MOreBats.util.OreColors;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy{

	@Override
	public void Preinit() {
		RenderingRegistry.registerEntityRenderingHandler(EntityGuanoProjectile.class, EntityGuanoRender.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityOreBat.class, RenderOreBat.FACTORY);
	}
	
	@Override
	public void Init() {
		
	}
	
	@Override
	public void PostInit() {
		
	}
	
	@SubscribeEvent
	public void registerBlockColors(ColorHandlerEvent.Item event) {
		ItemColors itemColors = event.getItemColors();
		
		for(Item item : MOreItems.ITEMS)
		{
			if(item instanceof ItemOreChunk)
			{
				itemColors.registerItemColorHandler(new IItemColor() {
					
					@Override
					public int colorMultiplier(ItemStack stack, int tintIndex) {
				        return OreColors.getColorInt(stack.getUnlocalizedName());
					}
				}, item);
			}
		}
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event)
    {
        for(Item item : MOreItems.ITEMS)
        {
        	if(item.getRegistryName().getResourcePath().contains("chunk"))
        	{
                ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, "ore_chunk"), "inventory"));
        	}
        	else if(item.getRegistryName().getResourcePath().contains("_guano"))
        	{
        		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, "ore_guano_item"), "inventory"));
        	}
        	else
        	{
                ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        	}
        }
        
        for(Block block : MOreBlocks.BLOCKS)
        {
        	Item item = Item.getItemFromBlock(block);
        	if(block.getRegistryName().getResourcePath().contains("_guano"))
        	{
        		ModelLoader.setCustomStateMapper(block, new GuanoState());
        	}
        	else
        	{
        		 ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        	}
        }
    }
}
