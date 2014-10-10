package com.cobble.cpp;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CPPCreativeTab extends CreativeTabs {
	
	

	public CPPCreativeTab(String lable) {
		super(lable);
		// TODO Auto-generated constructor stub
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return Items.baked_potato;
	}

}
