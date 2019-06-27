package sk.dipo.money.network.packet.server;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import sk.dipo.money.network.packet.AbstractMessageHandler;

public abstract class AbstractServerMessageHandler<T extends IMessage> extends AbstractMessageHandler<T> {
	public final IMessage handleClientMessage(EntityPlayer player, T message, MessageContext ctx) {
		return null;
	}
}