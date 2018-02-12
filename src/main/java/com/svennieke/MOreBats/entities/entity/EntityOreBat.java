package com.svennieke.MOreBats.entities.entity;

import java.awt.Color;

import com.svennieke.MOreBats.util.OreColors;
import com.svennieke.MOreBats.util.OreList;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityOreBat extends EntityBat{
	
	private static final DataParameter<String> ORE_NAME = EntityDataManager.<String>createKey(EntityOreBat.class, DataSerializers.STRING);
	public static String ENTITY_NAME = "EntityOreBat";
	public static final String NBT_ORE_NAME = "OreName";
	//private String ORE_NAME = "";
	
	public EntityOreBat(World worldIn) {
		super(worldIn);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(ORE_NAME, String.valueOf(""));
	}
	
	@Override
	public String getName() {
		return ENTITY_NAME;
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setString(NBT_ORE_NAME, getOre());
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.dataManager.set(ORE_NAME, compound.getString(NBT_ORE_NAME));
	}
	
	@Override
	public void onEntityUpdate() {
		super.onEntityUpdate();
		if(!world.isRemote)
		{
			//DEBUG
			//System.out.println(getOre());
		}
	}
	
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) 
	{
		IEntityLivingData entityData = super.onInitialSpawn(difficulty, livingdata);

		if(!world.isRemote)
		{
			configureOre();
		}

		return entityData;
	}
	
	public void configureOre()
	{
		if (getOre() == null || getOre().isEmpty())
		{
			String randomOreName = OreList.getRandomOre();

			setOre(randomOreName);
		}
	}
	
	public String getOre()
	{
		if (this.dataManager.get(ORE_NAME) == null || this.dataManager.get(ORE_NAME).isEmpty())
			return null;
		
		return this.dataManager.get(ORE_NAME);
	}
	
	public void setOre(String oreName)
	{
		this.dataManager.set(ORE_NAME, oreName);
	}
	
	public Color overlayColor()
	{
		return OreColors.getColor(getOre());
	}
}