package sk.dipo.money;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class MoneyMod {

	@SidedProxy(serverSide = Reference.PROXY_COMMON, clientSide = Reference.PROXY_CLIENT)
	public static CommonProxy proxy;

	@Instance
	public static MoneyMod instance = new MoneyMod();

	public static final ArrayList<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item cent1;
	public static final Item cent2;
	public static final Item cent5;
	public static final Item cent10;
	public static final Item cent20;
	public static final Item cent50;
	public static final Item euro1;
	public static final Item euro2;
	public static final Item euro5;
	public static final Item euro10;
	public static final Item euro20;
	public static final Item euro50;
	public static final Item euro100;
	public static final Item euro200;
	public static final Item euro500;
	
	static {
		cent1 = new MoneyItem("cent1");
		cent2 = new MoneyItem("cent2");
		cent5 = new MoneyItem("cent5");
		cent10 = new MoneyItem("cent10");
		cent20 = new MoneyItem("cent20");
		cent50 = new MoneyItem("cent50");
		euro1 = new MoneyItem("euro1");
		euro2 = new MoneyItem("euro2");
		euro5 = new MoneyItem("euro5");
		euro10 = new MoneyItem("euro10");
		euro20 = new MoneyItem("euro20");
		euro50 = new MoneyItem("euro50");
		euro100 = new MoneyItem("euro100");
		euro200 = new MoneyItem("euro200");
		euro500 = new MoneyItem("euro500");
	}
}
