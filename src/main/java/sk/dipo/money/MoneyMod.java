package sk.dipo.money;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import sk.dipo.money.proxy.CommonProxy;
import sk.dipo.money.utils.Reference;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class MoneyMod {

	@SidedProxy(serverSide = Reference.PROXY_COMMON, clientSide = Reference.PROXY_CLIENT)
	public static CommonProxy proxy;

	@Instance
	public static MoneyMod instance = new MoneyMod();
}
