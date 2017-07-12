package net.drok.poverhaul;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = POHMod.MODID, version = POHMod.VERSION, guiFactory="net.drok.poverhaul.config.GuiFactory")
public class POHMod
{
	@Mod.Instance
	public static POHMod instance;
    public static final String MODID = "poverhaul";
    public static Configuration CONFIG;

    public static final String VERSION = "1.12-0.0.1.0";
    public static final Logger LOGGER = LogManager.getLogger("Progressive Overhaul");
    public static final Random RAND = new Random();
    
    public static String getUnlocalizedNameBase(String name) {
    	
    	return MODID + "." + name;
    }
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
    	LOGGER.info("Starting Pre Initialization...");
    	
    	LOGGER.info("Loading Config");
    	
    	LOGGER.info("Asigning Ore Dcitionary Names...");
    	OreDictionary.registerOre("basalt", ModBlocks.basalt);
    	OreDictionary.registerOre("basalt", ModItems.basaltItem);
    	
    	LOGGER.info("Finished Pre Initialization...");
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	LOGGER.info("Starting Initialization...");
    	
    	LOGGER.info("Finished Initialization...");	
    }
    
    @EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {
    	LOGGER.info("Starting Post Initialization...");
    	
    	LOGGER.info("Finished Post Initialization...");
    }
}
