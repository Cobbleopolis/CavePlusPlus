package com.cobble.cpp;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

import com.cobble.cpp.proxy.CommonProxy;
import com.cobble.cpp.world.CavePPWorldGenerator;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = CPP.MODID, version = CPP.VERSION)
public class CPP
{
	@Instance(CPP.MODID)
	public static CPP INSTANCE;
    public static final String MODID = "caveplusplus";
    public static final String VERSION = "0.1";
    
    @SidedProxy(clientSide = "com.cobble.cpp.proxy.ClientProxy", serverSide = "com.cobble.cpp.proxy.CommonProxy")
    public static CommonProxy commonProxy;
    
    public static CreativeTabs tabCPP = new CPPCreativeTab("Cave++");
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	System.out.println("Loading Cave++ World Generator...");
		GameRegistry.registerWorldGenerator(new CavePPWorldGenerator(), 1);
		System.out.println("Finished Loading Cave++ World Generator...");
    }
}