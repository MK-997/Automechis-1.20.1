package net.mk.automechis;

import net.fabricmc.api.ModInitializer;

import net.mk.automechis.item.ModItemGroups;
import net.mk.automechis.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Automechis implements ModInitializer {
	public static final String MOD_ID = "automechis";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
	}
}