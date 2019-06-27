package sk.dipo.money.register;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import sk.dipo.money.MoneyMod;
import sk.dipo.money.handler.CapabilityHandler;
import sk.dipo.money.handler.EventHandlerDipo;
import sk.dipo.money.handler.GuiHandler;
import sk.dipo.money.tileentity.TileEntityATM;
import sk.dipo.money.utils.Reference;

public class CommonRegisters {

	public static void registerHandlers() {
		NetworkRegistry.INSTANCE.registerGuiHandler(MoneyMod.instance, new GuiHandler());
		MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
		MinecraftForge.EVENT_BUS.register(new EventHandlerDipo());
	}
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityATM.class, new ResourceLocation(Reference.MODID, "atm"));
	}
}