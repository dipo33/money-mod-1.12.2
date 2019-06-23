package sk.dipo.money.proxy;

import net.minecraft.item.Item;
import sk.dipo.money.register.CommonRegisters;
import sk.dipo.money.register.OreDicts;

public class CommonProxy {

	public void registerItemRenderer(Item item, int meta, String id) {
	}

	public void init() {
		OreDicts.registerOreDicts();
		CommonRegisters.registerHandlers();
	}
}