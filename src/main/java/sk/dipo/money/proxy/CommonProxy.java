package sk.dipo.money.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import sk.dipo.money.entity.MoneyVillager;
import sk.dipo.money.network.PacketDispatcher;
import sk.dipo.money.register.CommonRegisters;
import sk.dipo.money.register.OreDicts;
import sk.dipo.money.utils.Config;

public class CommonProxy {

	public void registerItemRenderer(Item item, int meta, String id) {
	}

	public void preInit(FMLPreInitializationEvent event) {
		PacketDispatcher.registerPackets();
		CommonRegisters.registerTileEntities();
		Config.loadConfiguration(event);
	}

	public void init(FMLInitializationEvent event) {
		OreDicts.registerOreDicts();
		CommonRegisters.registerHandlers();
		if (Config.allowVillager)
			MoneyVillager.associateCareersAndTrades();
	}

	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		return ctx.getServerHandler().player;
	}
}