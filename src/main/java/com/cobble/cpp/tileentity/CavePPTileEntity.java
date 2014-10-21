package com.cobble.cpp.tileentity;

import com.cobble.cpp.network.PacketHandler;
import com.cobble.cpp.network.message.MessageTileEntityCPP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class CavePPTileEntity  extends TileEntity {
	protected ForgeDirection orientation;
	protected byte state;
	protected String customName;
	protected String owner;

	public CavePPTileEntity() {
		this.orientation = ForgeDirection.SOUTH;
		this.state = 0;
		this.customName = "";
		this.owner = "";
	}

	public ForgeDirection getOrientation() {
		return this.orientation;
	}

	public void setOrientation(ForgeDirection orientation) {
		this.orientation = orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = ForgeDirection.getOrientation(orientation);
	}

	public short getState() {
		return (short) this.state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	public String getCustomName() {
		return this.customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void readFromNBT(NBTTagCompound nbtTagCompound) {
		super.readFromNBT(nbtTagCompound);

		if (nbtTagCompound.hasKey("teDirection")) {
			this.orientation = ForgeDirection.getOrientation(nbtTagCompound
					.getByte("teDirection"));
		}

		if (nbtTagCompound.hasKey("teState")) {
			this.state = nbtTagCompound.getByte("teState");
		}

		if (nbtTagCompound.hasKey("CustomName")) {
			this.customName = nbtTagCompound.getString("CustomName");
		}

		if (!(nbtTagCompound.hasKey("owner")))
			return;
		this.owner = nbtTagCompound.getString("owner");
	}

	public void writeToNBT(NBTTagCompound nbtTagCompound) {
		super.writeToNBT(nbtTagCompound);

		nbtTagCompound
				.setByte("teDirection", (byte) this.orientation.ordinal());
		nbtTagCompound.setByte("teState", this.state);

		if (hasCustomName()) {
			nbtTagCompound.setString("CustomName", this.customName);
		}

		if (!(hasOwner()))
			return;
		nbtTagCompound.setString("owner", this.owner);
	}

	public boolean hasCustomName() {
		return ((this.customName != null) && (this.customName.length() > 0));
	}

	public boolean hasOwner() {
		return ((this.owner != null) && (this.owner.length() > 0));
	}

	public Packet getDescriptionPacket() {
		return PacketHandler.INSTANCE.getPacketFrom(new MessageTileEntityCPP());
	}
}