package sk.dipo.money.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import sk.dipo.money.entity.MoneyVillager;
import sk.dipo.money.register.CommonRegisters;
import sk.dipo.money.register.OreDicts;
import sk.dipo.money.utils.Config;

public class CommonProxy {

	public void registerItemRenderer(Item item, int meta, String id) {
	}

	public void preInit(FMLPreInitializationEvent event) {
		Config.loadConfiguration(event);
	}

	public void init(FMLInitializationEvent event) {
		OreDicts.registerOreDicts();
		CommonRegisters.registerHandlers();
		if (Config.allowVillager)
			MoneyVillager.associateCareersAndTrades();
	}
}