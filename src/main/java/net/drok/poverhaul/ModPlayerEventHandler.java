package net.drok.poverhaul;

import net.drok.poverhaul.config.ModConfig;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ModPlayerEventHandler {

	@SubscribeEvent
    public static void breakSpeed(PlayerEvent.BreakSpeed event) {
		Entity entity = event.getEntity();
		
		if(entity instanceof EntityPlayer) {
			if(true) {
				EntityPlayer player = (EntityPlayer) entity;
				ItemStack stack = player.getHeldItemMainhand();
				IBlockState state = player.world.getBlockState(event.getPos());
				float str = ModHelper.getFilteredStrength(stack, state);
				
				if(str <= 1.0f) {
					event.setNewSpeed(event.getOriginalSpeed() * 0.33f);
				}
			}
		}
	}
}
