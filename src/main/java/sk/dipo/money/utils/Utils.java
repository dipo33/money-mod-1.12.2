package sk.dipo.money.utils;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
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

	public static ArrayList<EntityItem> randomCoinValue(LivingDropsEvent event, int low, int high) {
		ArrayList<EntityItem> itemsToDrop = new ArrayList<EntityItem>();
		int value = new Random().nextInt(high - low + 1);
		value += low;
		System.out.println(value);
		int coins[] = { 50000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1 };
		while (value > 0) {
			for (int coin : coins) {
				if (coin <= value) {
					value -= coin;
					ItemStack drop = new ItemStack(getCoinByValue(coin), 1);
					itemsToDrop.add(
							new EntityItem(event.getEntity().getEntityWorld(), event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, drop));
					break;
				}
			}
		}

		return itemsToDrop;
	}
}