package sk.dipo.money.handler;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;
import net.minecraftforge.registries.IForgeRegistry;
import sk.dipo.money.block.MoneyBlocks;
import sk.dipo.money.item.IHasModel;
import sk.dipo.money.item.MoneyItems;
import sk.dipo.money.utils.Config;
import sk.dipo.money.utils.Reference;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class RegistryHandler {

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(MoneyItems.ITEMS.toArray(new Item[0]));
	}

	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(MoneyBlocks.BLOCKS.toArray(new Block[0]));
	}

	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		for (Item item : MoneyItems.ITEMS) {
			if (item instanceof IHasModel) {
				((IHasModel) item).registerModels();
			}
		}
		
		for (Block block : MoneyBlocks.BLOCKS) {
			if (block instanceof IHasModel) {
				((IHasModel) block).registerModels();
			}
		}
	}

	@SubscribeEvent
	public static void onVillagerRegister(final RegistryEvent.Register<VillagerProfession> event) {
		final IForgeRegistry<VillagerProfession> registry = event.getRegistry();

		if (Config.allowVillager)
			registry.register(new VillagerProfession(Reference.MODID + ":exchanger", Reference.MODID + ":textures/entity/exchanger.png",
					Reference.MODID + ":textures/entity/exchanger.png"));
	}
}