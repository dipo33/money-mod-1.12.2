package sk.dipo.money.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemCreditCard extends MoneyItem {

	public ItemCreditCard(String name) {
		super(name);
		setMaxStackSize(1);
	}

	/*@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side,
			float hitX, float hitY, float hitZ) {
		if (world.isRemote)
			return false;
		if (world.getBlock(x, y, z) != MoneyBlocks.atm)
			return false;
		TileEntityATM atm = (TileEntityATM) world.getTileEntity(x, y, z);

		if (!atm.openable) {
			player.addChatMessage(new ChatComponentTranslation("msg.atm.in_use", new Object[0]));
			return true;
		}

		atm.openable = false;
		PacketDispatcher.sendToDimension(new OpenCloseAtmMessage(false, x, y, z), world.provider.dimensionId);
		player.openGui(MoneyMod.instance, GuiHandler.GUI_ATM, world, x, y, z);
		atm.setUser(player);

		return true;
	}*/
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (world.isRemote)
			return EnumActionResult.PASS;
		/*if (world.getBlockState(pos).getBlock() != MoneyBlocks.atm)
			return false;*/
		
		return EnumActionResult.PASS;
	}
}