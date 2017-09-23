package com.svennieke.MOreBats.entity;

import com.svennieke.MOreBats.init.MOreBlocks;

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
	public EntityGuanoProjectile(World worldIn)
    {
        super(worldIn);
    }

    public EntityGuanoProjectile(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
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
        	
        	BlockPos pos1 = this.getPosition();
        	BlockPos pos2 = new BlockPos(x+1,y,z);
        	BlockPos pos3 = new BlockPos(x-1,y,z);
        	BlockPos pos4 = new BlockPos(x,y,z+1);
        	BlockPos pos5 = new BlockPos(x,y,z-1);
        	
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
        		
        		Block block = world.getBlockState(pos1).getBlock();
        		Block block2 = world.getBlockState(pos2).getBlock();
        		Block block3 = world.getBlockState(pos3).getBlock();
        		Block block4 = world.getBlockState(pos4).getBlock();
        		Block block5 = world.getBlockState(pos5).getBlock();

        		if(block == Blocks.AIR || block == Blocks.TALLGRASS && !(block == MOreBlocks.guano))
        		{
        			dostuff(pos1);
        		}
        		else if(block2 == Blocks.AIR || block2 == Blocks.TALLGRASS && !(block2 == MOreBlocks.guano))
        		{
        			dostuff(pos2);
        		}
        		else if(block3 == Blocks.AIR || block3 == Blocks.TALLGRASS && !(block3 == MOreBlocks.guano))
        		{
        			dostuff(pos3);
        		}
        		else if(block4 == Blocks.AIR || block4 == Blocks.TALLGRASS && !(block4 == MOreBlocks.guano))
        		{
        			dostuff(pos4);
        		}
        		else if(block5 == Blocks.AIR || block5 == Blocks.TALLGRASS && !(block5 == MOreBlocks.guano))
        		{
        			dostuff(pos5);
        		}
        		
        		else if(block == Blocks.LAVA || block2 == Blocks.LAVA | block3 == Blocks.LAVA | block4 == Blocks.LAVA | block5 == Blocks.LAVA )
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
    	world.setBlockState(pos, MOreBlocks.guano.getDefaultState());
		this.world.setEntityState(this, (byte)3);
        this.setDead();
    }
}
