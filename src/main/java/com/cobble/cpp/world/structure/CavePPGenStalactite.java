package com.cobble.cpp.world.structure;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class CavePPGenStalactite  extends WorldGenerator{
	private Block block;

	public CavePPGenStalactite(Block block)
	{
		this.block = block;
	}

	public boolean generate(World world, Random random, int x, int y, int z){
		for (int l = 0; l < 64; ++l){
			int i1 = x + random.nextInt(8) - random.nextInt(8);
			int j1 = y + random.nextInt(4) - random.nextInt(4);
			int k1 = z + random.nextInt(8) - random.nextInt(8);

			if (world.isAirBlock(i1, j1, k1) && this.block.canBlockStay(world, i1, j1, k1)){
				world.setBlock(i1, j1, k1, this.block);
			}
		}

		return true;
	}
}
