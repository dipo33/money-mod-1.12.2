package sk.dipo.money.container.slot;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotATMOutput extends SlotItemHandler {

	public SlotATMOutput(IItemHandler inventory, int i, int x, int y) {
		super(inventory, i, x, y);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return false;
	}
}