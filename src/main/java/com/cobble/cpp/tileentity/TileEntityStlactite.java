package com.cobble.cpp.tileentity;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityStlactite extends TileEntity {

	public static TileEntityStlactite tile;
	public static int size;

	public TileEntityStlactite() {
		size = 1;
	}

	public TileEntityStlactite(World world, int x, int y, int z) {
		while(world.getBlock(x, y, z) == Blocks.air){
			size++;
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound par1) {
		super.writeToNBT(par1);
		par1.setInteger("size", size);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1) {
		super.readFromNBT(par1);
		this.size = par1.getInteger("size");
	}
}
