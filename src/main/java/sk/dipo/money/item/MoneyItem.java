package sk.dipo.money.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import sk.dipo.money.MoneyMod;

public class MoneyItem extends Item implements IHasModel {

	public MoneyItem(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MISC);

		MoneyItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		MoneyMod.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
