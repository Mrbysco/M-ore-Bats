package com.svennieke.MOreBats.render.projectile;

import com.svennieke.MOreBats.entity.EntityGuanoProjectile;
import com.svennieke.MOreBats.init.MOreItems;

import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;

public class EntityGuanoRender extends RenderSnowball<EntityGuanoProjectile>{

	public EntityGuanoRender(RenderManager renderManagerIn, RenderItem renderItem) {
		super(renderManagerIn, MOreItems.guano_projectile, renderItem);
	}

}
