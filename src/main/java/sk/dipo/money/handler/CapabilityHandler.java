package sk.dipo.money.handler;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import sk.dipo.money.capability.provider.WalletProvider;
import sk.dipo.money.utils.Reference;

public class CapabilityHandler {
	public static final ResourceLocation WALLET_CAPABILITY = new ResourceLocation(Reference.MODID, "wallet");

	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent<ItemStack> event) {
		event.addCapability(WALLET_CAPABILITY, new WalletProvider());
	}
}