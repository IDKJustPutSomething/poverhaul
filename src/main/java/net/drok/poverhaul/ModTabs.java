package net.drok.poverhaul;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModTabs {

	public static final CreativeTabs TABSTONEAGE = new CreativeTabs(CreativeTabs.getNextID(), "stoneage")
    {
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem()
        {
            return new ItemStack(ModItems.stoneCelt);
        }
    };
	
}
