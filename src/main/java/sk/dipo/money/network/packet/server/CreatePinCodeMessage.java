package sk.dipo.money.network.packet.server;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import sk.dipo.money.network.packet.client.AtmMovingTextMessage;
import sk.dipo.money.tileentity.TileEntityATM;

public class CreatePinCodeMessage implements IMessage {

	private int x, y, z;
	private String PIN;

	public CreatePinCodeMessage(int x, int y, int z, String PIN) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.PIN = PIN;
	}

	public CreatePinCodeMessage() {
	}

	@Override
	public void fromBytes(ByteBuf buffer) {
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		this.PIN = ByteBufUtils.readUTF8String(buffer);
	}

	@Override
	public void toBytes(ByteBuf buffer) {
		buffer.writeInt(this.x);
		buffer.writeInt(this.y);
		buffer.writeInt(this.z);
		ByteBufUtils.writeUTF8String(buffer, this.PIN);
	}

	public static class Handler extends AbstractServerMessageHandler<CreatePinCodeMessage> {
		@Override
		public IMessage handleServerMessage(EntityPlayer player, CreatePinCodeMessage message, MessageContext ctx) {
			TileEntityATM atm = (TileEntityATM) player.world.getTileEntity(new BlockPos(message.x, message.y, message.z));
			NBTTagCompound nbt = player.getHeldItem(atm.getHand()).getTagCompound();
			
			if (nbt == null)
				nbt = new NBTTagCompound();
			nbt.setString("PIN", message.PIN);
			player.getHeldItem(atm.getHand()).setTagCompound(nbt);

			return new AtmMovingTextMessage("msg.atm.signed_login", (short) 2);
		}
	}
}