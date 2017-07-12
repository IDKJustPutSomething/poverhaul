package net.drok.poverhaul;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ModRegistry {

	@SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
		POHMod.LOGGER.info("Starting Item Registry...");
        event.getRegistry().registerAll(
        			ModItems.rock,
        			ModItems.stoneCelt,
        			ModItems.basaltItem
        		);
        POHMod.LOGGER.info("Finished Item Registry...");
    }
	
	@SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
		POHMod.LOGGER.info("Starting Block Registry...");
        event.getRegistry().registerAll(
        			ModBlocks.basalt
        		);
        POHMod.LOGGER.info("Finished Block Registry...");
    }
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		
		Block[] blocks = {
	            ModBlocks.basalt
	        };
		
		for (Block block : blocks) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
					new ModelResourceLocation(block.getRegistryName(), "inventory"));
		}
		
		Item[] items = {
	            ModItems.rock
	        };

		for (Item item : items) {
			ModelLoader.setCustomModelResourceLocation(item, 0,
					new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}
	}
}
