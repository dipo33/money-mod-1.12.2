package sk.dipo.money.entity;

import java.util.Random;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.passive.EntityVillager.ITradeList;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerCareer;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;
import sk.dipo.money.utils.Config;
import sk.dipo.money.utils.Reference;
import sk.dipo.money.utils.Utils;

@ObjectHolder(Reference.MODID)
public class MoneyVillager {
	public final static VillagerProfession exchanger = null;

	public static VillagerCareer exchangerCareer;

	public static void associateCareersAndTrades() {
		exchangerCareer = (new VillagerCareer(exchanger, "exchanger")).addTrade(1, new TradeEmeraldsForMoney());
	}

	public static class TradeEmeraldsForMoney implements ITradeList {

		public ItemStack stack;

		public TradeEmeraldsForMoney() {
			stack = new ItemStack(Utils.getCoinByValue(Config.emeraldValue));
		}

		@Override
		public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random) {
			int actualPrice = 1;

			ItemStack stackToPay = new ItemStack(Items.EMERALD, actualPrice, 0);
			recipeList.add(new MerchantRecipe(stackToPay, stack));
		}
	}
}