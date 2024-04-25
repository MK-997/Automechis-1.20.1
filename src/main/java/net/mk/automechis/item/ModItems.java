package net.mk.automechis.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mk.automechis.Automechis;

public class ModItems {

    public static final Item GEAR = registerItem("gear", new Item(new FabricItemSettings()));
    public static final Item SPRING = registerItem("spring", new Item(new FabricItemSettings()));
    public static final Item IRON_ROD = registerItem("iron_rod", new Item(new FabricItemSettings()));
    public static final Item INDUSTRIAL_IRON_INGOT = registerItem("industrial_iron_ingot", new Item(new FabricItemSettings()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(GEAR);
        entries.add(SPRING);
        entries.add(IRON_ROD);
        entries.add(INDUSTRIAL_IRON_INGOT);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Automechis.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Automechis.LOGGER.info("Registering Mod Items for " + Automechis.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
