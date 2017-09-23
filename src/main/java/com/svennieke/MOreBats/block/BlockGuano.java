package com.svennieke.MOreBats.block;

import java.util.Random;

import com.svennieke.MOreBats.MOreBats;
import com.svennieke.MOreBats.init.MOreItems;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGuano extends BlockFalling
{
	public static final PropertyBool EXPLODE = PropertyBool.create("explode");
	
	public BlockGuano(String unlocalised, String registry) {
		super(Material.SNOW);
		setUnlocalizedName(unlocalised);
		setRegistryName(registry);
		setCreativeTab(MOreBats.instance.tabBats);
		setHarvestLevel("shovel", 0);
		setHardness(0.45F);
	}
	
	//Start Normal Block info
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isTranslucent(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isBlockNormalCube(IBlockState state) {
		return false;
	}
	//End Normal Block Info
	
	//Start Explosive side
	@Override
	public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return true;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		
		if (!itemstack.isEmpty() && (itemstack.getItem() == Items.FLINT_AND_STEEL || itemstack.getItem() == Items.FIRE_CHARGE))
        {
            this.explode(worldIn, pos, state.withProperty(EXPLODE, Boolean.valueOf(true)), playerIn);
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 11);

            if (itemstack.getItem() == Items.FLINT_AND_STEEL)
            {
                itemstack.damageItem(1, playerIn);
            }
            else if (!playerIn.capabilities.isCreativeMode)
            {
                itemstack.shrink(1);
            }

            return true;
        }
        else
        {
            return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
        }
	}
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        if (!worldIn.isRemote && entityIn instanceof EntityArrow)
        {
            EntityArrow entityarrow = (EntityArrow)entityIn;

            if (entityarrow.isBurning())
            {
                this.explode(worldIn, pos, worldIn.getBlockState(pos).withProperty(EXPLODE, Boolean.valueOf(true)), entityarrow.shootingEntity instanceof EntityLivingBase ? (EntityLivingBase)entityarrow.shootingEntity : null);
                worldIn.setBlockToAir(pos);
            }
        }
    }
	
	public void explode(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase igniter)
    {
        if (!worldIn.isRemote)
        {
            if (((Boolean)state.getValue(EXPLODE)).booleanValue())
            {
            	worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 1f, false);
            }
        }
    }
	
	@Override
	public boolean canDropFromExplosion(Explosion explosionIn)
    {
        return false;
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(EXPLODE, Boolean.valueOf((meta & 1) > 0));
    }
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return ((Boolean)state.getValue(EXPLODE)).booleanValue() ? 1 : 0;
	}
	
	@Override
	protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {EXPLODE});
    }
	//End Explosive side
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return MOreItems.guano_projectile;
	}
}
