package sk.dipo.money.network.packet.server;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import sk.dipo.money.tileentity.TileEntityATM;

public class InitATMMessage implements IMessage {

	private int x, y, z;

	public InitATMMessage(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public InitATMMessage() {
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

	public static class Handler extends AbstractServerMessageHandler<InitATMMessage> {
		@Override
		public IMessage handleServerMessage(EntityPlayer player, InitATMMessage message, MessageContext ctx) {
			TileEntityATM atm = (TileEntityATM) player.world.getTileEntity(new BlockPos(message.x, message.y, message.z));

			return atm.init();
		}
	}
}