package sk.dipo.money.register;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import sk.dipo.money.MoneyMod;
import sk.dipo.money.handler.CapabilityHandler;
import sk.dipo.money.handler.EventHandlerDipo;
import sk.dipo.money.handler.GuiHandler;

public class CommonRegisters {

	public static void registerHandlers() {
		NetworkRegistry.INSTANCE.registerGuiHandler(MoneyMod.instance, new GuiHandler());
		MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
		MinecraftForge.EVENT_BUS.register(new EventHandlerDipo());
	}
}