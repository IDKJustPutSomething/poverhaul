package net.drok.poverhaul.config;

import net.minecraftforge.common.config.Config;

@Config(modid = "poverhaul")
public class ModConfig {

	public static boolean value1 = true;
	
	public static class Overrides
	{
		@Config.Comment("Defines whether or not to use a more realistic harvest system.")
		public static boolean fixedHarvest = true;
	}
}
