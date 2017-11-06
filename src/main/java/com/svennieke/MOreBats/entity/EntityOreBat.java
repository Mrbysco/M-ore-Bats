package com.svennieke.MOreBats.entity;

import java.awt.Color;

import com.svennieke.MOreBats.util.OreColors;
import com.svennieke.MOreBats.util.OreList;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.relauncher.Side;

public class EntityOreBat extends EntityBat{
		
	public static String ENTITY_NAME = "EntityOreBat";
	public static final String NBT_ORE_NAME = "OreName";
	private String ORE_NAME = "";
	
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
		compound.setString(NBT_ORE_NAME, getOre());
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.ORE_NAME = compound.getString(NBT_ORE_NAME);
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
		return this.ORE_NAME;
	}
	
	public void setOre(String oreName)
	{
		this.ORE_NAME = oreName;
	}
	
	public Color overlayColor()
	{
		return OreColors.getColor(getOre());
	}
}