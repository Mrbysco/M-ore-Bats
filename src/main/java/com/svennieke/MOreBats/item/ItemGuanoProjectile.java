package com.svennieke.MOreBats.item;

import java.util.List;

import com.svennieke.MOreBats.MOreBats;
import com.svennieke.MOreBats.Reference;
import com.svennieke.MOreBats.entities.entity.EntityGuanoProjectile;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemGuanoProjectile extends Item
{
	private int density;
	
	public ItemGuanoProjectile(String registry, int density) {
		this.setUnlocalizedName(Reference.MOD_PREFIX + registry.replaceAll("_", ""));
		this.setRegistryName(registry);
		this.density = density;
		setCreativeTab(MOreBats.instance.tabBats);
	}
	
	@Override
	public Item setMaxStackSize(int maxStackSize) {
		switch(this.density)
		{
			case 1:
				return this.setMaxStackSize(16);
			case 2:
				return this.setMaxStackSize(8);
			case 3:
				return this.setMaxStackSize(4);
			case 4:
				return this.setMaxStackSize(2);
			default:
				return this.setMaxStackSize(16);
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
        	EntityGuanoProjectile projectile;
        	
        	NBTTagCompound nbt;
            if (itemstack.hasTagCompound())
            {
                nbt = itemstack.getTagCompound();
            }
            else
            {
                nbt = new NBTTagCompound();
            }
            
        	if (itemstack.hasTagCompound() && itemstack.getTagCompound().hasKey("Ore"))
        	{
        		projectile = new EntityGuanoProjectile(worldIn, playerIn, this.density - 1, itemstack.getTagCompound().getString("Ore"));
        	}
        	else
        	{
        		projectile = new EntityGuanoProjectile(worldIn, playerIn, this.density - 1, "oreCoal");
        	}
        	
            projectile.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            worldIn.spawnEntity(projectile);
        }
        
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		initTag(stack);
		
		if(GuiScreen.isShiftKeyDown()){
	    	if (stack.hasTagCompound() && stack.getTagCompound().hasKey("Ore"))
	    	{
	    		tooltip.add("Ore: " + stack.getTagCompound().getString("Ore"));
	    	}
	    	else
	    	{
				tooltip.add("No Specific Ore");
	    	}
		}
	}
	
	public ItemStack initTag(ItemStack stack){
		NBTTagCompound nbt;
	    if (stack.hasTagCompound())
	    {
	        nbt = stack.getTagCompound();
	    }
	    else
	    {
	        nbt = new NBTTagCompound();
	    }
        stack.setTagCompound(nbt);
		
		return stack;
	}
}
