package net.drok.poverhaul;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModHelper {

	private static ItemStack axe = new ItemStack(Items.DIAMOND_AXE);
	private static ItemStack pick = new ItemStack(Items.DIAMOND_PICKAXE);
	private static ItemStack shovel = new ItemStack(Items.DIAMOND_SHOVEL);
	private static ItemStack hoe = new ItemStack(Items.DIAMOND_HOE);
	
	private static Material[] filteredToolMats = new Material[]
			{
					Material.CACTUS,
					Material.CARPET,
					Material.CIRCUITS,
					Material.CLAY,
					Material.CLOTH,
					Material.CRAFTED_SNOW,
					Material.GLASS,
					Material.GOURD,
					Material.LEAVES,
					Material.PLANTS,
					Material.REDSTONE_LIGHT,
					Material.SAND,
					Material.SNOW,
					Material.SPONGE,
					Material.TNT,
					Material.VINE
			
			};
	
	public static float getFilteredStrength(ItemStack stack, IBlockState state) {
		
		for(Material mat : filteredToolMats) {
			if(state.getMaterial() == mat) {
				return 2.0f;
			}
		}
		
		return stack.getStrVsBlock(state);
	}
}
