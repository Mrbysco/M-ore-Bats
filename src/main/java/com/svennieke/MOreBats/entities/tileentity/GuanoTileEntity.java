package com.svennieke.MOreBats.entities.tileentity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class GuanoTileEntity extends TileEntity implements ITickable{
	private int density;
	private String ore;
	
	public GuanoTileEntity() {
		this.ore = "";
	}
	
	public void setDensity(int densityIn) {
		this.density = densityIn;
	}
	
	public int getDensity() {
		return this.density;
	}
	
	public void setOre(String oreName) {
		this.ore = oreName;
	}
	
	public String getOre() {
		return this.ore;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.density = compound.getInteger("Density");
		this.ore = compound.getString("OreName");
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
        compound.setInteger("Density", this.density);
        compound.setString("OreName", this.ore);
        return compound;
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		NBTTagCompound tag = super.getUpdateTag();
		tag.setInteger("Density", this.density);
		tag.setString("OreName", this.ore);
		return tag;
	}
    
    @Override
    public void handleUpdateTag(NBTTagCompound tag) {
    	super.handleUpdateTag(tag);
    	this.density = tag.getInteger("Density");
    	this.ore = tag.getString("OreName");
    }
    
    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
    	super.onDataPacket(net, pkt);
    	readFromNBT(pkt.getNbtCompound());
    	
    	final IBlockState state = getWorld().getBlockState(getPos());
    	getWorld().notifyBlockUpdate(getPos(), state, state, 3);
    	
    }
    
    @Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		return new SPacketUpdateTileEntity(pos, 0, getUpdateTag());
    }
    
	@Override
	public void update() {
	}
	
}
