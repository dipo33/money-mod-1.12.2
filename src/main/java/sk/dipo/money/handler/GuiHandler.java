package sk.dipo.money.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import sk.dipo.money.container.ContainerWallet;
import sk.dipo.money.gui.GuiWallet;

public class GuiHandler implements IGuiHandler {

	public static final int GUI_WALLET_MAIN = 0;
	public static final int GUI_WALLET_OFF = 1;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		IItemHandler cap;
		switch (ID) {
		case GUI_WALLET_MAIN:
			cap = player.getHeldItemMainhand().getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
			return new ContainerWallet(player.inventory, cap);
		case GUI_WALLET_OFF:
			cap = player.getHeldItemOffhand().getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
			return new ContainerWallet(player.inventory, cap);
		default:
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		IItemHandler cap;
		switch (ID) {
		case GUI_WALLET_MAIN:
			cap = player.getHeldItemMainhand().getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
			return new GuiWallet(player.inventory, cap);
		case GUI_WALLET_OFF:
			cap = player.getHeldItemOffhand().getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
			return new GuiWallet(player.inventory, cap);
		default:
			return null;
		}
	}
}