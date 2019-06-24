package sk.dipo.money.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.IItemHandler;
import sk.dipo.money.container.ContainerWallet;
import sk.dipo.money.item.MoneyItems;

public class GuiWallet extends GuiContainer {

	private static final ResourceLocation walletGuiTextures = new ResourceLocation("textures/gui/container/generic_54.png");
	private final InventoryPlayer inventoryPlayer;

	public GuiWallet(InventoryPlayer inventoryPlayer, IItemHandler inventoryWallet) {
		super(new ContainerWallet(inventoryPlayer, inventoryWallet));
		this.inventoryPlayer = inventoryPlayer;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
		ItemStack wallet = inventoryPlayer.player.getHeldItemMainhand();
		if (!inventoryPlayer.player.getHeldItemOffhand().isEmpty())
			if (inventoryPlayer.player.getHeldItemOffhand().getItem() == MoneyItems.wallet)
				wallet = inventoryPlayer.player.getHeldItemOffhand();

		this.fontRenderer.drawString(wallet.getDisplayName(), 8, 5, 4210752);
		this.fontRenderer.drawString(I18n.format(this.inventoryPlayer.getName(), new Object[0]), 8, this.ySize - 93, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(walletGuiTextures);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l - 1, 0, 0, this.xSize, 71);
		this.drawTexturedModalRect(k, l + 70, 0, 126, this.xSize, 96);
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}
}