package sk.dipo.money.tileentity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketSetSlot;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import sk.dipo.money.network.packet.client.AtmMovingTextMessage;
import sk.dipo.money.utils.Utils;

public class TileEntityATM extends TileEntity implements ICapabilityProvider {

	public static final int INV_SIZE = 36;

	private ItemStackHandler inventory;
	private String customName;
	public boolean openable = true;
	public int attempts = 3;
	private EntityPlayer user;
	private EnumHand hand;

	public TileEntityATM() {
		inventory = new ItemStackHandler(INV_SIZE);
	}

	public void withdrawMoney(ItemStack stack, EntityPlayer player, int x, int y, int z) {
		System.out.println(getTileData().toString());
		IItemHandler inventory = this.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		for (int i = 18; i < 36; i++) {
			if (stack.isEmpty())
				return;
			stack = inventory.insertItem(i, stack, false);
			((EntityPlayerMP) player).connection.sendPacket(new SPacketSetSlot(player.openContainer.windowId, i, inventory.getStackInSlot(i)));
		}

		if (!stack.isEmpty()) {
			EntityItem item = new EntityItem(player.world, x, y, z, stack);
			player.world.spawnEntity(item);
		}
	}

	public int depositMoney(EntityPlayer player) {
		int balance = 0;
		IItemHandler inventory = this.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

		for (int i = 0; i < 18; i++) {
			balance += Utils.getValueByMoney(inventory.getStackInSlot(i));
			inventory.extractItem(i, 64, false);
			((EntityPlayerMP) player).connection.sendPacket(new SPacketSetSlot(player.openContainer.windowId, i, ItemStack.EMPTY));
		}

		return balance;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		if (compound.hasKey("CustomName", 8)) {
			this.customName = compound.getString("CustomName");
		}
		this.inventory.deserializeNBT(compound.getCompoundTag("Inventory"));
		super.readFromNBT(compound);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		if (this.hasCustomName()) {
			compound.setString("CustomName", this.customName);
		}
		compound.setTag("Inventory", this.inventory.serializeNBT());
		return super.writeToNBT(compound);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.<T>cast(inventory) : null;
	}

	public void setUser(EntityPlayer user, EnumHand hand) {
		this.user = user;
		this.hand = hand;
	}

	public EnumHand getHand() {
		return hand;
	}

	public IMessage init() {
		ItemStack creditCard = user.getHeldItem(this.hand);
		NBTTagCompound nbt = creditCard.getTagCompound();

		if (nbt != null && nbt.hasKey("OwnerUUID")) {
			if (nbt.hasKey("PIN")) {
				String ownerName = nbt.getString("OwnerName");
				return new AtmMovingTextMessage("msg.atm.login", (short) 2, ownerName);
			} else {
				return new AtmMovingTextMessage("msg.atm.create_pin", (short) 1);
			}
		} else {
			return new AtmMovingTextMessage("msg.atm.not_signed", (short) 0);
		}
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}
	
	public boolean hasCustomName() {
		return customName != null && customName.length() > 0;
	}
}