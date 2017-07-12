package net.drok.poverhaul;

import net.drok.poverhaul.config.ModConfig;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ModBlockEventHandler {

	@SubscribeEvent
    public static void harvestDrops(BlockEvent.HarvestDropsEvent event) {

		EntityPlayer player = event.getHarvester();
		if(player != null) {
			if(true) {
				ItemStack stack = player.getHeldItemMainhand();
				IBlockState state = player.world.getBlockState(event.getPos());
				float str = ModHelper.getFilteredStrength(stack, state);
		
				if(str <= 1.0f) {
					event.getDrops().clear();
				}
			}
		}
	}
}
