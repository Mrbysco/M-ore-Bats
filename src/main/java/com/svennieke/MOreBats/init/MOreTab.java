package com.svennieke.MOreBats.init;

import com.svennieke.MOreBats.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class MOreTab extends CreativeTabs{

	public MOreTab() {
		super(Reference.MOD_ID);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Items.SPAWN_EGG, 1);
	}
}
