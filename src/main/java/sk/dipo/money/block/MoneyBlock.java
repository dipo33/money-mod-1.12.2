package sk.dipo.money.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import sk.dipo.money.MoneyMod;
import sk.dipo.money.item.IHasModel;
import sk.dipo.money.item.MoneyItems;

public class MoneyBlock extends Block implements IHasModel {

	public MoneyBlock(Material material, String name) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MoneyMod.moneyTab);

		MoneyBlocks.BLOCKS.add(this);
		MoneyItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() {
		MoneyMod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
