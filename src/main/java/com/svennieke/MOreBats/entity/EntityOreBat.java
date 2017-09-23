package com.svennieke.MOreBats.entity;

import net.minecraft.entity.passive.EntityBat;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityOreBat extends EntityBat{
	
	public static String ENTITY_NAME = "EntityOreBat";
	
	public EntityOreBat(World worldIn) {
		super(worldIn);
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
	}
	
	@Override
	public String getName() {
		return ENTITY_NAME;
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
	}
}