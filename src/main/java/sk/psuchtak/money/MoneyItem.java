package sk.psuchtak.money;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MoneyItem extends Item implements IHasModel {

	public MoneyItem(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MISC);

		MoneyMod.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		MoneyMod.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
