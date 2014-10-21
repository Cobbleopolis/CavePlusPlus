package com.cobble.cpp.blocks;

import com.cobble.cpp.CPP;
import com.cobble.cpp.tileentity.TileEntityStlactite;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockStalactite extends Block {

	public BlockStalactite() {
		super(Material.rock);
		setCreativeTab(CPP.tabCPP);
		setHardness(3F);
		setResistance(5F);
		setBlockName("stalactite");
		setBlockTextureName("caveplusplus:stalactite");
	}

	public boolean isOpaqueCube() {
		return true;
	}

	@Override
	public int getRenderType() {
		return 0;
	}

	public boolean renderAsNormalBlock() {
		return true;
	}

	public TileEntity createNewTileEntity(World world, int metaData) {
		return new TileEntityStlactite();
	}
}
