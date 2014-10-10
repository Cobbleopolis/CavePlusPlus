package com.cobble.cpp.world.structure;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureMineshaftPieces;
import net.minecraft.world.gen.structure.StructureStart;

public class StructureCityStart extends StructureStart
{
    private static final String __OBFID = "CL_00000450";

    public StructureCityStart() {}

    public StructureCityStart(World world, Random rand, int x, int z)
    {
        super(x, z);
        StructureMineshaftPieces.Room room = new StructureMineshaftPieces.Room(0, rand, (x << 4) + 2, (z << 4) + 2);
        this.components.add(room);
        room.buildComponent(room, this.components, rand);
        this.updateBoundingBox();
        this.markAvailableHeight(world, rand, 10);
    }
}
