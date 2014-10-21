package com.cobble.cpp.network;

import com.cobble.cpp.CPP;
import com.cobble.cpp.network.message.MessageTileEntityCPP;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler
{
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(CPP.MODID.toLowerCase());

	public static void init()
	{
		INSTANCE.registerMessage(MessageTileEntityCPP.class, MessageTileEntityCPP.class, 0, Side.CLIENT);
	}
}