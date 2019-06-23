package sk.dipo.money.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import sk.dipo.money.MoneyMod;
import sk.dipo.money.handler.GuiHandler;

public class ItemWallet extends MoneyItem {

	public ItemWallet(String name) {
		super(name);
		setMaxStackSize(1);
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 1;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		if (!world.isRemote) {
			if (hand == EnumHand.MAIN_HAND)
				player.openGui(MoneyMod.instance, GuiHandler.GUI_WALLET_MAIN, world, player.getPosition().getX(), player.getPosition().getY(),
						player.getPosition().getZ());
			else
				player.openGui(MoneyMod.instance, GuiHandler.GUI_WALLET_OFF, world, player.getPosition().getX(), player.getPosition().getY(),
						player.getPosition().getZ());

			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
		}
		return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(hand));
	}
}