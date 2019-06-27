package sk.dipo.money.network.packet.server;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import sk.dipo.money.network.packet.client.AtmMovingTextMessage;
import sk.dipo.money.tileentity.TileEntityATM;

public class SignCreditCardMessage implements IMessage {

	private int x, y, z;

	public SignCreditCardMessage(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public SignCreditCardMessage() {
	}

	@Override
	public void fromBytes(ByteBuf buffer) {
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	@Override
	public void toBytes(ByteBuf buffer) {
		buffer.writeInt(this.x);
		buffer.writeInt(this.y);
		buffer.writeInt(this.z);
	}

	public static class Handler extends AbstractServerMessageHandler<SignCreditCardMessage> {
		@Override
		public IMessage handleServerMessage(EntityPlayer player, SignCreditCardMessage message, MessageContext ctx) {
			TileEntityATM atm = (TileEntityATM) player.world.getTileEntity(new BlockPos(message.x, message.y, message.z));
			NBTTagCompound nbt = player.getHeldItem(atm.getHand()).getTagCompound();
			
			if (nbt == null)
				nbt = new NBTTagCompound();
			nbt.setString("OwnerUUID", player.getUniqueID().toString());
			nbt.setString("OwnerName", player.getDisplayName().getFormattedText());
			player.getHeldItem(atm.getHand()).setTagCompound(nbt);

			return new AtmMovingTextMessage("msg.atm.create_pin", (short) 1);
		}
	}
}