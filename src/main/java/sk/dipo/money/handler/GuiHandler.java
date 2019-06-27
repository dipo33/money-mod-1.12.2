package sk.dipo.money.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import sk.dipo.money.container.ContainerATM;
import sk.dipo.money.container.ContainerWallet;
import sk.dipo.money.gui.GuiATM;
import sk.dipo.money.gui.GuiWallet;
import sk.dipo.money.tileentity.TileEntityATM;

public class GuiHandler implements IGuiHandler {

	public static final int GUI_WALLET_MAIN = 0;
	public static final int GUI_WALLET_OFF = 1;
	public static final int GUI_ATM = 2;

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
		case GUI_ATM:
			TileEntityATM atm = (TileEntityATM) world.getTileEntity(new BlockPos(x, y, z));
			return new ContainerATM(player.inventory, atm);
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
		case GUI_ATM:
			TileEntityATM atm = (TileEntityATM) world.getTileEntity(new BlockPos(x, y, z));
			return new GuiATM(player.inventory, atm);
		default:
			return null;
		}
	}
}