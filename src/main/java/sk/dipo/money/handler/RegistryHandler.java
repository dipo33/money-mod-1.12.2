package sk.dipo.money.handler;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import sk.dipo.money.item.IHasModel;
import sk.dipo.money.item.MoneyItems;
import sk.dipo.money.utils.Reference;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class RegistryHandler {

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(MoneyItems.ITEMS.toArray(new Item[0]));
	}

	@SubscribeEvent
	public static void onModelRegistry(ModelRegistryEvent event) {
		for (Item item : MoneyItems.ITEMS) {
			if (item instanceof IHasModel) {
				((IHasModel) item).registerModels();
			}
		}
	}
}