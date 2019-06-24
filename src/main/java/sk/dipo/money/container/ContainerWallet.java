package sk.dipo.money.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import sk.dipo.money.capability.provider.WalletProvider;
import sk.dipo.money.container.slot.SlotWallet;
import sk.dipo.money.item.MoneyItems;

public class ContainerWallet extends Container {

	private final IItemHandler walletInventory;

	private static final int INV_START = WalletProvider.INV_SIZE, INV_END = INV_START + 26, HOTBAR_START = INV_END + 1, HOTBAR_END = HOTBAR_START + 8;

	public ContainerWallet(InventoryPlayer playerInventory, IItemHandler inventory) {
		walletInventory = inventory;

		for (int j = 0; j < 3; ++j) {
			for (int k = 0; k < 9; ++k) {
				this.addSlotToContainer(new SlotWallet(walletInventory, k + j * 9, 8 + k * 18, 17 + j * 18));
			}
		}

		for (int j = 0; j < 3; ++j) {
			for (int k = 0; k < 9; ++k) {
				this.addSlotToContainer(new Slot(playerInventory, k + j * 9 + 9, 8 + k * 18, 84 + j * 18));
			}
		}

		for (int j = 0; j < 9; ++j) {
			this.addSlotToContainer(new Slot(playerInventory, j, 8 + j * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = (Slot) this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack() && !slot.getStack().isEmpty()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (index < INV_START) {
				if (!this.mergeItemStack(itemstack1, INV_START, HOTBAR_END + 1, true)) {
					return ItemStack.EMPTY;
				}

				slot.onSlotChange(itemstack1, itemstack);
			} else {
				SlotWallet slotOut = (SlotWallet) this.inventorySlots.get(0);
				if (slotOut.isItemValid(itemstack1)) {
					if (!this.mergeItemStack(itemstack1, 0, INV_START, false)) {
						return ItemStack.EMPTY;
					}
				}
			}

			if (itemstack1.getCount() == 0) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}

			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}

			slot.onTake(player, itemstack1);
		}

		return itemstack;
	}
	
	@Override
	public ItemStack slotClick(int slot, int dragType, ClickType clickType, EntityPlayer player) {
		if (slot >= 0 && getSlot(slot) != null && getSlot(slot).getHasStack() && !getSlot(slot).getStack().isEmpty()
				&& getSlot(slot).getStack().getItem() == MoneyItems.wallet) {
			return ItemStack.EMPTY;
		}
		return super.slotClick(slot, dragType, clickType, player);
	}
}