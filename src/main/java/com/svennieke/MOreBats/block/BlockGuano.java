package com.svennieke.MOreBats.block;

import com.svennieke.MOreBats.MOreBats;
import com.svennieke.MOreBats.Reference;
import com.svennieke.MOreBats.block.base.BlockBase;
import com.svennieke.MOreBats.init.MOreItems;
import com.svennieke.MOreBats.util.OreList;

import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGuano extends BlockBase
{
    public static final PropertyInteger DENSITY = PropertyInteger.create("density", 0, 3);
	
	public BlockGuano(String registry) {
		super(Material.SNOW);
        this.setDefaultState(this.blockState.getBaseState().withProperty(this.getDensityProperty(), Integer.valueOf(0)).withProperty(EXPLODE, Boolean.valueOf(false)));

		this.setUnlocalizedName(Reference.MOD_PREFIX + registry.replaceAll("_", "").toLowerCase());
		this.setRegistryName(registry.toLowerCase());
		setCreativeTab(MOreBats.instance.tabBats);
		setHarvestLevel("shovel", 0);
		setHardness(0.45F);
	}
	
	protected PropertyInteger getDensityProperty()
    {
        return this.DENSITY;
    }
	
	protected int getDensity(IBlockState state)
    {
        return ((Integer)state.getValue(this.getDensityProperty())).intValue();
    }
	
	public IBlockState withDensity(int density)
    {
        return this.getDefaultState().withProperty(this.getDensityProperty(), Integer.valueOf(density));
    }
	
	@Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
		ItemStack guanoStack;
		
		switch(getDensity(state))
		{
			case 0:
				guanoStack = new ItemStack(MOreItems.guano_projectile);
				System.out.println("HI");
				break;
			case 1:
				guanoStack = new ItemStack(MOreItems.guano_projectile2);
				break;
			case 2:
				guanoStack = new ItemStack(MOreItems.guano_projectile3);
				break;
			case 3:
				guanoStack = new ItemStack(MOreItems.guano_projectile4);
				break;
			default:
				guanoStack = new ItemStack(MOreItems.guano_projectile);
				break;
		}
		
		String oreName = OreList.convertBlockName(this.getLocalizedName());
		
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
	    	nbt.setString("Ore", oreName );
	    }
	    else
	    {
	    	nbt.setString("Ore", oreName);
	    }
		
		guanoStack.setTagCompound(nbt);
		
		drops.remove(0);
		drops.add(guanoStack);
    }
	
	//Start block placement logic
	@Override
	public void onEndFalling(World worldIn, BlockPos pos, IBlockState state1, IBlockState state2) {	
		IBlockState block = worldIn.getBlockState(pos.down());
		int density = getDensity(state1);
		
		if (block == this.getDefaultState().withProperty(DENSITY, Integer.valueOf(0)) && density == 1)
		{
			worldIn.setBlockState(pos.down(), this.getDefaultState().withProperty(DENSITY, Integer.valueOf(1)));
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		}
		if (block == this.getDefaultState().withProperty(DENSITY, Integer.valueOf(1)) && density == 1)
		{
			worldIn.setBlockState(pos.down(), this.getDefaultState().withProperty(DENSITY, Integer.valueOf(2)));
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		}
		if (block == this.getDefaultState().withProperty(DENSITY, Integer.valueOf(2)) && density == 1)
		{
			worldIn.setBlockState(pos.down(), this.getDefaultState().withProperty(DENSITY, Integer.valueOf(3)));
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		}
		if (block == this.getDefaultState().withProperty(DENSITY, Integer.valueOf(1)) && density == 2)
		{
			worldIn.setBlockState(pos.down(), this.getDefaultState().withProperty(DENSITY, Integer.valueOf(3)));
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		}
		if (block == this.getDefaultState().withProperty(DENSITY, Integer.valueOf(0)) && density == 2)
		{
			worldIn.setBlockState(pos.down(), this.getDefaultState().withProperty(DENSITY, Integer.valueOf(2)));
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		}
		if (block == this.getDefaultState().withProperty(DENSITY, Integer.valueOf(0)) && density == 3)
		{
			worldIn.setBlockState(pos.down(), this.getDefaultState().withProperty(DENSITY, Integer.valueOf(2)));
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
		IBlockState block = worldIn.getBlockState(pos.down());
		int density = getDensity(state);
		
		if (block == this.getDefaultState().withProperty(DENSITY, Integer.valueOf(0)) && density == 1)
		{
			worldIn.setBlockState(pos.down(), this.getDefaultState().withProperty(DENSITY, Integer.valueOf(1)));
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		}
		if (block == this.getDefaultState().withProperty(DENSITY, Integer.valueOf(1)) && density == 1)
		{
			worldIn.setBlockState(pos.down(), this.getDefaultState().withProperty(DENSITY, Integer.valueOf(2)));
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		}

		if (block == this.getDefaultState().withProperty(DENSITY, Integer.valueOf(2)) && density == 1)
		{
			worldIn.setBlockState(pos.down(), this.getDefaultState().withProperty(DENSITY, Integer.valueOf(3)));
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		}
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
	}
	
	@Override
    public IBlockState getStateFromMeta(int meta)
    {
		return this.getDefaultState().withProperty(DENSITY, (meta & 3) % 4).withProperty(EXPLODE, Boolean.valueOf((meta & 4) > 0));
    }

	@Override
	public int getMetaFromState(IBlockState state) {
        int i = 0;
        i = i | this.getDensity(state);

        if (!((Boolean)state.getValue(EXPLODE)).booleanValue())
        {
            i |= 4;
        }

        return i;
	}
	
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {DENSITY, EXPLODE});
    }
}