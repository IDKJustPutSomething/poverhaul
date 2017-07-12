package net.drok.poverhaul.item;

import net.drok.poverhaul.ModBlocks;
import net.drok.poverhaul.POHMod;
import net.minecraft.item.ItemBlock;

public class ItemBlockBasalt extends ItemBlock {

	public ItemBlockBasalt() {
		super(ModBlocks.basalt);
		this.setRegistryName(POHMod.MODID, "basalt");
		this.setUnlocalizedName(POHMod.getUnlocalizedNameBase(this.getRegistryName().getResourcePath()));
	}
}
