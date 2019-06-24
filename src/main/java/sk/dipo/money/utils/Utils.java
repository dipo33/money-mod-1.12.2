package sk.dipo.money.utils;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;
import sk.dipo.money.item.MoneyItems;

public class Utils {

	public static boolean isItemMoney(ItemStack stack) {
		NonNullList<ItemStack> moneys = OreDictionary.getOres("moneyDipo");
		for (ItemStack money : moneys)
			if (OreDictionary.itemMatches(money, stack, false)) {
				return true;
			}

		return false;
	}

	public static Item getCoinByValue(int value) {
		switch (value) {
		case 1:
			return MoneyItems.cent1;
		case 2:
			return MoneyItems.cent2;
		case 5:
			return MoneyItems.cent5;
		case 10:
			return MoneyItems.cent10;
		case 20:
			return MoneyItems.cent20;
		case 50:
			return MoneyItems.cent50;
		case 100:
			return MoneyItems.euro1;
		case 200:
			return MoneyItems.euro2;
		case 500:
			return MoneyItems.euro5;
		case 1000:
			return MoneyItems.euro10;
		case 2000:
			return MoneyItems.euro20;
		case 5000:
			return MoneyItems.euro50;
		case 10000:
			return MoneyItems.euro100;
		case 20000:
			return MoneyItems.euro200;
		case 50000:
			return MoneyItems.euro500;
		}

		return null;
	}
}