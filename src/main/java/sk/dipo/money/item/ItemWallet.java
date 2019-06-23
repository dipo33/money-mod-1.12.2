package sk.dipo.money.item;

import net.minecraft.item.ItemStack;

public class ItemWallet extends MoneyItem {

	public ItemWallet(String name) {
		super(name);
		setMaxStackSize(1);
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 1;
	}
}