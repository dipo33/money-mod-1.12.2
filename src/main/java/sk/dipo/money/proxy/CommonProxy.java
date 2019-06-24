package sk.dipo.money.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import sk.dipo.money.entity.MoneyVillager;
import sk.dipo.money.register.CommonRegisters;
import sk.dipo.money.register.OreDicts;

public class CommonProxy {

	public void registerItemRenderer(Item item, int meta, String id) {
	}

	public void init(FMLInitializationEvent event) {
		OreDicts.registerOreDicts();
		CommonRegisters.registerHandlers();
			MoneyVillager.associateCareersAndTrades();
	}
}