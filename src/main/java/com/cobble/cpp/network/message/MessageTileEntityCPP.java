package com.cobble.cpp.network.message;

import com.cobble.cpp.tileentity.CavePPTileEntity;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

public class MessageTileEntityCPP implements IMessage, IMessageHandler<MessageTileEntityCPP, IMessage>
{
	public int x, y, z;
	public byte orientation, state;
	public String customName, owner;

	public MessageTileEntityCPP()
	{
	}

	public MessageTileEntityCPP(CavePPTileEntity tileEntityCPP)
	{
		this.x = tileEntityCPP.xCoord;
		this.y = tileEntityCPP.yCoord;
		this.z = tileEntityCPP.zCoord;
		this.orientation = (byte) tileEntityCPP.getOrientation().ordinal();
		this.state = (byte) tileEntityCPP.getState();
		this.customName = tileEntityCPP.getCustomName();
		this.owner = tileEntityCPP.getOwner();
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.x = buf.readInt();
		this.y = buf.readInt();
		this.z = buf.readInt();
		this.orientation = buf.readByte();
		this.state = buf.readByte();
		int customNameLength = buf.readInt();
		this.customName = new String(buf.readBytes(customNameLength).array());
		int ownerLength = buf.readInt();
		this.owner = new String(buf.readBytes(ownerLength).array());
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
		buf.writeByte(orientation);
		buf.writeByte(state);
		buf.writeInt(customName.length());
		buf.writeBytes(customName.getBytes());
		buf.writeInt(owner.length());
		buf.writeBytes(owner.getBytes());
	}

	@Override
	public IMessage onMessage(MessageTileEntityCPP message, MessageContext ctx)
	{
		TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);

		if (tileEntity instanceof CavePPTileEntity)
		{
			((CavePPTileEntity) tileEntity).setOrientation(message.orientation);
			((CavePPTileEntity) tileEntity).setState(message.state);
			((CavePPTileEntity) tileEntity).setCustomName(message.customName);
			((CavePPTileEntity) tileEntity).setOwner(message.owner);
		}

		return null;
	}

	@Override
	public String toString()
	{
		return String.format("MessageTileEntityCPP - x:%s, y:%s, z:%s, orientation:%s, state:%s, customName:%s, owner:%s", x, y, z, orientation, state, customName, owner);
	}
}