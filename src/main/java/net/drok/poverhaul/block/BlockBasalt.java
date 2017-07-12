package net.drok.poverhaul.block;

import net.drok.poverhaul.ModTabs;
import net.drok.poverhaul.POHMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockBasalt extends Block {

	public BlockBasalt() {
		super(Material.ROCK);
		this.setCreativeTab(ModTabs.TABSTONEAGE);
		this.setHardness(1.5F);
		this.setResistance(10.0F);
		this.setSoundType(SoundType.STONE);
		this.setRegistryName(POHMod.MODID, "basalt");
		this.setUnlocalizedName(POHMod.getUnlocalizedNameBase(this.getRegistryName().getResourcePath()));
	}
}
