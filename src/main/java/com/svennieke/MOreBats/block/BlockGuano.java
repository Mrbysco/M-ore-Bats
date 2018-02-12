package com.svennieke.MOreBats.block;

import com.svennieke.MOreBats.MOreBats;
import com.svennieke.MOreBats.Reference;
import com.svennieke.MOreBats.block.base.BlockBase;
import com.svennieke.MOreBats.entities.tileentity.GuanoTileEntity;
import com.svennieke.MOreBats.init.MOreBlocks;
import com.svennieke.MOreBats.init.MOreItems;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGuano extends BlockBase implements ITileEntityProvider
{
	private int density;
	private String type;
	
	public BlockGuano(String registry, int density) {
		super(Material.SNOW);
		this.setUnlocalizedName(Reference.MOD_PREFIX + registry.replaceAll("_", ""));
		this.setRegistryName(registry);
		this.density = density;
		setCreativeTab(MOreBats.instance.tabBats);
		setHarvestLevel("shovel", 0);
		setHardness(0.45F);
	}
	
	@Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
    	GuanoTileEntity te = world.getTileEntity(pos) instanceof GuanoTileEntity ? (GuanoTileEntity) world.getTileEntity(pos) : null;
		if (te != null && te.isInvalid()) {
			drops.add(ItemStack.EMPTY);
		} 
		else if (te != null && !te.isInvalid()) 
		{
			System.out.println("Guano");
			String guanoOre = te.getOre();
			
			ItemStack guanoStack;

			switch(this.density)
			{
				case 1:
					guanoStack = new ItemStack(MOreItems.guano_projectile);
					System.out.println("HI");
					break;
				case 2:
					guanoStack = new ItemStack(MOreItems.guano_projectile2);
					break;
				case 3:
					guanoStack = new ItemStack(MOreItems.guano_projectile3);
					break;
				case 4:
					guanoStack = new ItemStack(MOreItems.guano_projectile4);
					break;
				default:
					guanoStack = new ItemStack(MOreItems.guano_projectile);
					break;
			}
			
			NBTTagCompound nbt;
		    if (guanoStack.hasTagCompound())
		    {
		        nbt = guanoStack.getTagCompound();
		    }
		    else
		    {
		        nbt = new NBTTagCompound();
		    }
		    
			if (nbt.hasKey("Ore"))
		    {
		    	nbt.setString("Ore", guanoOre);
		    }
		    else
		    {
		    	nbt.setString("Ore", guanoOre);
		    }
			
			guanoStack.setTagCompound(nbt);
			
			drops.remove(0);
			drops.add(guanoStack);
		}

    }
	
	//Start block placement logic
	@Override
	public void onEndFalling(World worldIn, BlockPos pos, IBlockState state1, IBlockState state2) {	
		Block block = worldIn.getBlockState(pos.down()).getBlock();
		setGuanoInfo(worldIn, pos);
		
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
		setGuanoInfo(worldIn, pos);
		
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

	private GuanoTileEntity getTE(World world, BlockPos pos) {
        return (GuanoTileEntity) world.getTileEntity(pos);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new GuanoTileEntity();
	}
	
	public void setGuanoInfo(World worldIn, BlockPos pos)
	{
		int guanoDensity = getTE(worldIn, pos).getDensity();
    	if(guanoDensity != this.density)
    	{
    		getTE(worldIn, pos).setDensity(density);
    	}
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
        	int actualDensity = getTE(worldIn, pos).getDensity();
        	String actualOre = getTE(worldIn, pos).getOre();

        	System.out.println(actualDensity);
        	System.out.println(actualOre);
        }
        
		return true;
	}
}