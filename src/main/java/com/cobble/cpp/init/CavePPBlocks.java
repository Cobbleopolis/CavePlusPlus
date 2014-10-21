package com.cobble.cpp.init;

import com.cobble.cpp.blocks.BlockStalactite;
import com.cobble.cpp.tileentity.TileEntityStlactite;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class CavePPBlocks {
	public static Block stlactite;

	public static void initBlock(){
		stlactite = new BlockStalactite();
	}

	public static void registerBlocks(){
		GameRegistry.registerBlock(stlactite,
				stlactite.getUnlocalizedName());
	}

	public static void registerTileEntity() {
		GameRegistry.registerTileEntity(TileEntityStlactite.class,
				"tileentityStlactite");
	}
}
