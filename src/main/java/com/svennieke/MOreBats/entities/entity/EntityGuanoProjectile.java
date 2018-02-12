package com.svennieke.MOreBats.entities.entity;

import com.svennieke.MOreBats.block.BlockGuano;
import com.svennieke.MOreBats.util.OreList;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGuanoProjectile extends EntityThrowable
{
	private int density;
	private String oreName;
	
	public EntityGuanoProjectile(World worldIn)
    {
        super(worldIn);
    }

    public EntityGuanoProjectile(World worldIn, EntityLivingBase throwerIn, int densityIn, String oreName)
    {
        super(worldIn, throwerIn);
        this.density = densityIn;
        this.oreName = oreName;
    }
	
    public EntityGuanoProjectile(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    public static void registerFixesGuano(DataFixer fixer)
    {
        EntityThrowable.registerFixesThrowable(fixer, "GuanoProjectile");
    }

    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id)
    {
        if (id == 3)
        {
            for (int i = 0; i < 8; ++i)
            {
                this.world.spawnParticle(EnumParticleTypes.SNOWBALL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
            }
        }
    }
    
    protected void onImpact(RayTraceResult result)
    {
        if (!this.world.isRemote)
        {
        	int x = (int) this.posX;
        	int y = (int) this.posY;
        	int z = (int) this.posZ;
        	
        	BlockPos pos = this.getPosition();
        	
        	if(result.typeOfHit !=null && result.typeOfHit == RayTraceResult.Type.ENTITY)
        	{
        		Entity hit = result.entityHit;
        		if(hit instanceof EntityPlayer)
        		{
        			EntityPlayer hitPlayer = (EntityPlayer)hit;
        			
            		hitPlayer.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 12 * 20, 0, true, true));
            		hitPlayer.addPotionEffect(new PotionEffect(MobEffects.POISON, 10 * 20, 0, true, true));
            		dostuff(this.getPosition());
        		}
        		else
        		{
        			dostuff(this.getPosition());
        		}
        	}
        		
        	if(result.typeOfHit != null && result.typeOfHit == RayTraceResult.Type.BLOCK)
        	{
        		
        		//BlockPos position = new BlockPos(this.posX, this.posY, this.posZ);
        		BlockPos position = this.getPosition();
        		Block block = world.getBlockState(pos).getBlock();
        		boolean flag1 = (block == Blocks.AIR || block == Blocks.TALLGRASS);
        		
        		if(flag1 && !(block == OreList.getBlockFromName(this.oreName)))
        		{
        			dostuff(pos);
        		}
        		else if(block == Blocks.LAVA)
        		{
        			world.createExplosion(this, this.posX, this.posY, this.posZ, 1f, false);
        			this.world.setEntityState(this, (byte)3);
    	            this.setDead();
        		}
        	}
        	else
        	{
	            this.world.setEntityState(this, (byte)3);
	            this.setDead();
        	}
        }
    }
    
    private void dostuff(BlockPos pos) {
    	BlockGuano guano = OreList.getBlockFromName(this.oreName);
    	
    	switch(this.density)
    	{
	    	case 0:
	    		world.setBlockState(pos, guano.getDefaultState().withProperty(guano.DENSITY, Integer.valueOf(0)));
	    		break;
	    	case 1:
	    		world.setBlockState(pos, guano.getDefaultState().withProperty(guano.DENSITY, Integer.valueOf(1)));
	    		break;
	    	case 2:
	    		world.setBlockState(pos, guano.getDefaultState().withProperty(guano.DENSITY, Integer.valueOf(2)));
	    		break;
	    	case 3:
	    		world.setBlockState(pos, guano.getDefaultState().withProperty(guano.DENSITY, Integer.valueOf(3)));
	    		break;
    	}
    	
    	this.world.setEntityState(this, (byte)3);
        this.setDead();
    }
}
