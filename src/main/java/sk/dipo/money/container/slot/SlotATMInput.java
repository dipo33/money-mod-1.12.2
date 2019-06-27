package sk.dipo.money.container.slot;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import sk.dipo.money.utils.Utils;

public class SlotATMInput extends SlotItemHandler {

	public SlotATMInput(IItemHandler inventory, int i, int x, int y) {
		super(inventory, i, x, y);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return Utils.isItemMoney(stack);
	}
}