package com.cobble.cpp.world.structure;

import static net.minecraftforge.common.ChestGenHooks.MINESHAFT_CORRIDOR;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureMineshaftPieces;
import net.minecraftforge.common.ChestGenHooks;

public class StructureCityPieces{
    /** List of contents that can generate in Mineshafts. */
    public static final WeightedRandomChestContent[] mineshaftChestContents = new WeightedRandomChestContent[] {new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 5, 10), new WeightedRandomChestContent(Items.gold_ingot, 0, 1, 3, 5), new WeightedRandomChestContent(Items.redstone, 0, 4, 9, 5), new WeightedRandomChestContent(Items.dye, 4, 4, 9, 5), new WeightedRandomChestContent(Items.diamond, 0, 1, 2, 3), new WeightedRandomChestContent(Items.coal, 0, 3, 8, 10), new WeightedRandomChestContent(Items.bread, 0, 1, 3, 15), new WeightedRandomChestContent(Items.iron_pickaxe, 0, 1, 1, 1), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.rail), 0, 4, 8, 1), new WeightedRandomChestContent(Items.melon_seeds, 0, 2, 4, 10), new WeightedRandomChestContent(Items.pumpkin_seeds, 0, 2, 4, 10), new WeightedRandomChestContent(Items.saddle, 0, 1, 1, 3), new WeightedRandomChestContent(Items.iron_horse_armor, 0, 1, 1, 1)};
    private static final String __OBFID = "CL_00000444";

    public static void registerStructurePieces()
    {
        MapGenStructureIO.func_143031_a(StructureCityPieces.Corridor.class, "CPPCorridor");
    }

    private static StructureComponent getRandomComponent(List p_78815_0_, Random p_78815_1_, int p_78815_2_, int p_78815_3_, int p_78815_4_, int p_78815_5_, int p_78815_6_)
    {
        int j1 = p_78815_1_.nextInt(100);
        StructureBoundingBox structureboundingbox;

        if (j1 >= 80)
        {
            structureboundingbox = StructureMineshaftPieces.Cross.findValidPlacement(p_78815_0_, p_78815_1_, p_78815_2_, p_78815_3_, p_78815_4_, p_78815_5_);

            if (structureboundingbox != null)
            {
                return new StructureMineshaftPieces.Cross(p_78815_6_, p_78815_1_, structureboundingbox, p_78815_5_);
            }
        }
        else if (j1 >= 70)
        {
            structureboundingbox = StructureMineshaftPieces.Stairs.findValidPlacement(p_78815_0_, p_78815_1_, p_78815_2_, p_78815_3_, p_78815_4_, p_78815_5_);

            if (structureboundingbox != null)
            {
                return new StructureMineshaftPieces.Stairs(p_78815_6_, p_78815_1_, structureboundingbox, p_78815_5_);
            }
        }
        else
        {
            structureboundingbox = StructureMineshaftPieces.Corridor.findValidPlacement(p_78815_0_, p_78815_1_, p_78815_2_, p_78815_3_, p_78815_4_, p_78815_5_);

            if (structureboundingbox != null)
            {
                return new StructureMineshaftPieces.Corridor(p_78815_6_, p_78815_1_, structureboundingbox, p_78815_5_);
            }
        }

        return null;
    }

    private static StructureComponent getNextCityComponent(StructureComponent component, List p_78817_1_, Random p_78817_2_, int p_78817_3_, int p_78817_4_, int p_78817_5_, int p_78817_6_, int p_78817_7_)
    {
        if (p_78817_7_ > 8)
        {
            return null;
        }
        else if (Math.abs(p_78817_3_ - component.getBoundingBox().minX) <= 80 && Math.abs(p_78817_5_ - component.getBoundingBox().minZ) <= 80)
        {
            StructureComponent structurecomponent1 = getRandomComponent(p_78817_1_, p_78817_2_, p_78817_3_, p_78817_4_, p_78817_5_, p_78817_6_, p_78817_7_ + 1);

            if (structurecomponent1 != null)
            {
                p_78817_1_.add(structurecomponent1);
                structurecomponent1.buildComponent(component, p_78817_1_, p_78817_2_);
            }

            return structurecomponent1;
        }
        else
        {
            return null;
        }
    }

    public static class Corridor extends StructureComponent
        {
    	
    	private int sectionSize;

		@Override
		protected void func_143012_a(NBTTagCompound nbt) {
			nbt.setInteger("sectionSize", this.sectionSize);
		}

		@Override
		protected void func_143011_b(NBTTagCompound nbt) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean addComponentParts(World world, Random rand,
				StructureBoundingBox bound) {
			// TODO Auto-generated method stub
			return false;
		}
            
        }
}
