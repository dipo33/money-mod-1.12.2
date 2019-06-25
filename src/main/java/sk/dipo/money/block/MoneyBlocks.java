package sk.dipo.money.block;

import java.util.ArrayList;

import net.minecraft.block.Block;

public class MoneyBlocks {

	public static final ArrayList<Block> BLOCKS = new ArrayList<Block>();

	public static final Block atm;

	static {
		atm = new BlockATM("atm");
	}
}
