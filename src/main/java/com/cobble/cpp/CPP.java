package com.cobble.cpp;

import com.cobble.cpp.init.CavePPBlocks;
import com.cobble.cpp.proxy.CommonProxy;
import com.cobble.cpp.world.CavePPWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = CPP.MODID, version = CPP.VERSION)
public class CPP {
	public static final String MODID = "caveplusplus";
	public static final String VERSION = "0.1";

	@Instance(CPP.MODID)
	public static CPP INSTANCE;


	@SidedProxy(clientSide = "com.cobble.cpp.proxy.ClientProxy", serverSide = "com.cobble.cpp.proxy.CommonProxy")
	public static CommonProxy commonProxy;

	public static CreativeTabs tabCPP = new CPPCreativeTab("Cave++");

	@EventHandler
	public void preInit(FMLInitializationEvent event){
		System.out.println("Loading Cave++ Blocks...");
		CavePPBlocks.initBlock();
		CavePPBlocks.registerBlocks();
		System.out.println("Finished Cave++ Blocks...");
		System.out.println("Loading Cave++ Tile Entitys...");
		CavePPBlocks.registerTileEntity();
		System.out.println("Finished Loading Cave++ Tile Entitys...");
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println("Loading Cave++ World Generator...");
		GameRegistry.registerWorldGenerator(new CavePPWorldGenerator(), 1);
		System.out.println("Finished Loading Cave++ World Generator...");
	}
}
