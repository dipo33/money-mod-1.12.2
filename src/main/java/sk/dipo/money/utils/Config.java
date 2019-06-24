package sk.dipo.money.utils;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Config {

	public static boolean allowVillager;

	public static int emeraldValue;

	public static void loadConfiguration(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		allowVillager = config.getBoolean("allowVillager", Configuration.CATEGORY_GENERAL, true, "Allow custom villager to trade emerald for money");
		emeraldValue = config.getInt("emeraldValue", Configuration.CATEGORY_GENERAL, 500, 1, 50000, "Value of emerald in cents when trading with villager [ALLOWED VALUES: 1, 2, 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000, 20000, 50000]");

		config.save();
	}
}