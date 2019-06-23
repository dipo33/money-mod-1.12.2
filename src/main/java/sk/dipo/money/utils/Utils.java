package sk.dipo.money.utils;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

public class Utils {

	public static boolean isItemMoney(ItemStack stack) {
		NonNullList<ItemStack> moneys = OreDictionary.getOres("moneyDipo");
		for (ItemStack money : moneys)
			if (OreDictionary.itemMatches(money, stack, false)) {
				return true;
			}

		return false;
	}
}