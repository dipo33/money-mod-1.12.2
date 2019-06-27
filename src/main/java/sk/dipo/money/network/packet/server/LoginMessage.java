package sk.dipo.money.network.packet.server;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import sk.dipo.money.MoneyMod;
import sk.dipo.money.network.packet.client.AtmMovingTextMessage;
import sk.dipo.money.tileentity.TileEntityATM;

public class LoginMessage implements IMessage {

	private String PIN;
	private int x, y, z;

	public LoginMessage(String PIN, int x, int y, int z) {
		this.PIN = PIN;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public LoginMessage() {
	}

	@Override
	public void fromBytes(ByteBuf buffer) {
		this.PIN = ByteBufUtils.readUTF8String(buffer);
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	@Override
	public void toBytes(ByteBuf buffer) {
		ByteBufUtils.writeUTF8String(buffer, this.PIN);
		buffer.writeInt(this.x);
		buffer.writeInt(this.y);
		buffer.writeInt(this.z);
	}

	public static class Handler extends AbstractServerMessageHandler<LoginMessage> {
		@Override
		public IMessage handleServerMessage(EntityPlayer player, LoginMessage message, MessageContext ctx) {

			TileEntityATM atm = (TileEntityATM) player.world.getTileEntity(new BlockPos(message.x, message.y, message.z));
			NBTTagCompound nbt = player.getHeldItem(atm.getHand()).getTagCompound();
			if (nbt.getString("PIN").equalsIgnoreCase(message.PIN))
				return new AtmMovingTextMessage("msg.atm.welcome", (short) 3, MoneyMod.db.getInteger("Players", player.getUniqueID().toString() + ".Balance"));
			else {
				atm.attempts--;

				if (atm.attempts < 1) {
					player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
					return new AtmMovingTextMessage("msg.atm.card_eaten", (short) 4);
				} else
					return new AtmMovingTextMessage("msg.atm.bad_login", (short) 2, atm.attempts);
			}
		}
	}
}