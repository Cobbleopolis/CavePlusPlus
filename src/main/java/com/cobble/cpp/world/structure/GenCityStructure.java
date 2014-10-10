package com.cobble.cpp.world.structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureMineshaftStart;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;

public class GenCityStructure extends MapGenStructure
{
    private double chance = 0.1D;
    private static final String __OBFID = "CL_00000443";

    public GenCityStructure() {}

    public String func_143025_a()
    {
        return "Dwarf City";
    }

    public GenCityStructure(Map map)
    {
        Iterator iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Entry entry = (Entry)iterator.next();

            if (((String)entry.getKey()).equals("chance"))
            {
                this.chance = MathHelper.parseDoubleWithDefault((String)entry.getValue(), this.chance);
            }
        }
    }

    protected boolean canSpawnStructureAtCoords(int x, int z)
    {
        return this.rand.nextDouble() < this.chance && this.rand.nextInt(80) < Math.max(Math.abs(x), Math.abs(z));
    }

    protected StructureStart getStructureStart(int x, int z)
    {
        return new StructureMineshaftStart(this.worldObj, this.rand, x, z);
    }
}
