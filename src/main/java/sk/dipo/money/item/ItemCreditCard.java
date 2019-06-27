package sk.dipo.money.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import sk.dipo.money.MoneyMod;
import sk.dipo.money.block.MoneyBlocks;
import sk.dipo.money.handler.GuiHandler;
import sk.dipo.money.network.PacketDispatcher;
import sk.dipo.money.network.packet.client.OpenCloseAtmMessage;
import sk.dipo.money.tileentity.TileEntityATM;

public class ItemCreditCard extends MoneyItem {

	public ItemCreditCard(String name) {
		super(name);
		setMaxStackSize(1);
	}

	/*
	 * @Override public boolean onItemUse(ItemStack stack, EntityPlayer player,
	 * World world, int x, int y, int z, int side, float hitX, float hitY, float
	 * hitZ) { if (world.isRemote) return false; if (world.getBlock(x, y, z) !=
	 * MoneyBlocks.atm) return false; TileEntityATM atm = (TileEntityATM)
	 * world.getTileEntity(x, y, z);
	 * 
	 * if (!atm.openable) { player.addChatMessage(new
	 * ChatComponentTranslation("msg.atm.in_use", new Object[0])); return true; }
	 * 
	 * atm.openable = false; PacketDispatcher.sendToDimension(new
	 * OpenCloseAtmMessage(false, x, y, z), world.provider.dimensionId);
	 * player.openGui(MoneyMod.instance, GuiHandler.GUI_ATM, world, x, y, z);
	 * atm.setUser(player);
	 * 
	 * return true; }
	 */

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (world.isRemote)
			return EnumActionResult.PASS;
		if (world.getBlockState(pos).getBlock() != MoneyBlocks.atm)
			return EnumActionResult.PASS;

		TileEntityATM atm = (TileEntityATM) world.getTileEntity(pos);

		if (!atm.openable) {
			player.sendMessage(new TextComponentTranslation("msg.atm.in_use", new Object[0]));
			return EnumActionResult.SUCCESS;
		}

		atm.openable = false;
		PacketDispatcher.sendToDimension(new OpenCloseAtmMessage(false, pos.getX(), pos.getY(), pos.getZ()), world.provider.getDimension());
		atm.setUser(player, hand);
		player.openGui(MoneyMod.instance, GuiHandler.GUI_ATM, world, pos.getX(), pos.getY(), pos.getZ());

		return EnumActionResult.SUCCESS;
	}
}