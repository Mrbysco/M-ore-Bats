package com.svennieke.MOreBats.item;

import com.svennieke.MOreBats.MOreBats;
import com.svennieke.MOreBats.entity.EntityGuanoProjectile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemGuanoProjectile extends Item{
	public ItemGuanoProjectile(String unlocalised, String registry) {
		setUnlocalizedName(unlocalised);
		setRegistryName(registry);
		setCreativeTab(MOreBats.instance.tabBats);
	}
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if (!playerIn.capabilities.isCreativeMode)
        {
            itemstack.shrink(1);
        }

        worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isRemote)
        {
            EntityGuanoProjectile guanoprojectile = new EntityGuanoProjectile(worldIn, playerIn);
            guanoprojectile.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            worldIn.spawnEntity(guanoprojectile);
        }

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
}
