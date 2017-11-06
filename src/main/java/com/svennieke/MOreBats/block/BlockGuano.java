package com.svennieke.MOreBats.block;

import java.util.Random;

import com.svennieke.MOreBats.MOreBats;
import com.svennieke.MOreBats.block.base.BlockBase;
import com.svennieke.MOreBats.init.MOreBlocks;
import com.svennieke.MOreBats.init.MOreItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockGuano extends BlockBase
{
	private int density;
	
	public BlockGuano(String unlocalised, String registry, int density) {
		super(Material.SNOW);
		setUnlocalizedName(unlocalised);
		setRegistryName(registry);
		this.density = density;
		setCreativeTab(MOreBats.instance.tabBats);
		setHarvestLevel("shovel", 0);
		setHardness(0.45F);
	}
	
	//Item dropped
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		if(this.density == 1)
		{
			return MOreItems.guano_projectile;
		}
		if(this.density == 2)
		{
			return MOreItems.guano_projectile2;
		}
		if(this.density == 3)
		{
			return MOreItems.guano_projectile3;
		}
		else
		{
			return MOreItems.guano_projectile4;
		}
	}
	
	//Start block placement logic
	@Override
	public void onEndFalling(World worldIn, BlockPos pos, IBlockState state1, IBlockState state2) {	
		Block block = worldIn.getBlockState(pos.down()).getBlock();
		
		if (block == MOreBlocks.guano && this.density == 1)
		{
			worldIn.setBlockState(pos.down(), MOreBlocks.guano2.getDefaultState());
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		}
		if (block == MOreBlocks.guano2 && this.density == 1)
		{
			worldIn.setBlockState(pos.down(), MOreBlocks.guano3.getDefaultState());
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		}
		if (block == MOreBlocks.guano3 && this.density == 1)
		{
			worldIn.setBlockState(pos.down(), MOreBlocks.guano4.getDefaultState());
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		}
		if (block == MOreBlocks.guano2 && this.density == 2)
		{
			worldIn.setBlockState(pos.down(), MOreBlocks.guano4.getDefaultState());
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		}
		if (block == MOreBlocks.guano && this.density == 2)
		{
			worldIn.setBlockState(pos.down(), MOreBlocks.guano3.getDefaultState());
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		}
		if (block == MOreBlocks.guano && this.density == 3)
		{
			worldIn.setBlockState(pos.down(), MOreBlocks.guano4.getDefaultState());
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		}
		if (block == Blocks.LAVA)
		{
			explode(worldIn, pos, state1, (EntityLivingBase)null);
		}
		if (block == Blocks.WATER)
		{
			worldIn.setBlockState(pos, Blocks.WATER.getDefaultState());
		}
		super.onEndFalling(worldIn, pos, state1, state2);
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		Block block = worldIn.getBlockState(pos.down()).getBlock();
		
		if (block == MOreBlocks.guano && this.density == 1)
		{
			worldIn.setBlockState(pos.down(), MOreBlocks.guano2.getDefaultState());
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		}
		if (block == MOreBlocks.guano2 && this.density == 1)
		{
			worldIn.setBlockState(pos.down(), MOreBlocks.guano3.getDefaultState());
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		}
		if (block == MOreBlocks.guano3 && this.density == 1)
		{
			worldIn.setBlockState(pos.down(), MOreBlocks.guano4.getDefaultState());
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		}
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
	}
	//End block place logic
}
