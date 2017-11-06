package com.svennieke.MOreBats.item;

import com.svennieke.MOreBats.MOreBats;
import com.svennieke.MOreBats.entity.EntityGuanoProjectile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemGuanoProjectile extends Item
{
	private int density;
	
	public ItemGuanoProjectile(String unlocalised, String registry, int density) {
		setUnlocalizedName(unlocalised);
		setRegistryName(registry);
		this.density = density;
		setCreativeTab(MOreBats.instance.tabBats);
	}
	
	@Override
	public Item setMaxStackSize(int maxStackSize) {
		if(this.density == 1)
		{
			return this.setMaxStackSize(16);
		}
		if(this.density == 2)
		{
			return this.setMaxStackSize(8);
		}
		if(this.density == 3)
		{
			return this.setMaxStackSize(4);
		}
		else
		{
			return this.setMaxStackSize(2);
		}
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
            EntityGuanoProjectile guanoprojectile = new EntityGuanoProjectile(worldIn, playerIn, this.density);
            guanoprojectile.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            worldIn.spawnEntity(guanoprojectile);
        }

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
}
