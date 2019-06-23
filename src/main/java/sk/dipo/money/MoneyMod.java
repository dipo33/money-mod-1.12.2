package sk.dipo.money;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import sk.dipo.money.proxy.CommonProxy;
import sk.dipo.money.utils.Reference;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class MoneyMod {

	@SidedProxy(serverSide = Reference.PROXY_COMMON, clientSide = Reference.PROXY_CLIENT)
	public static CommonProxy proxy;

	@Instance
	public static MoneyMod instance = new MoneyMod();

	public static CreativeTabs moneyTab = new MoneyTab();
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
	}
}