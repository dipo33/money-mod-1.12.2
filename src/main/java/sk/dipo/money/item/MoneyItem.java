package sk.dipo.money.item;

import net.minecraft.item.Item;
import sk.dipo.money.MoneyMod;

public class MoneyItem extends Item implements IHasModel {

	public MoneyItem(String name) {
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(MoneyMod.moneyTab);

		MoneyItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		MoneyMod.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
