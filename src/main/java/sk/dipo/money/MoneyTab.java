package sk.dipo.money;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import sk.dipo.money.item.MoneyItems;

public class MoneyTab extends CreativeTabs {

	public MoneyTab() {
		super("money_tab");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(MoneyItems.euro2);
	}
}