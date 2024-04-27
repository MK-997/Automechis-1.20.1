package net.mk.automechis.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.mk.automechis.Automechis;
import net.mk.automechis.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup GEAR_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Automechis.MOD_ID, "gear"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.gear"))
                    .icon(() -> new ItemStack(ModItems.GEAR)).entries(

                            (displayContext, entries) -> {

                        entries.add(ModItems.GEAR);
                        entries.add(ModItems.SPRING);
                        entries.add(ModItems.IRON_ROD);
                        entries.add(ModItems.INDUSTRIAL_IRON_INGOT);
                        entries.add(ModItems.COPPER_NUGGET);
                        entries.add(ModItems.COPPER_ROD);
                        entries.add(ModItems.INDUSTRIAL_COPPER_INGOT);

                        entries.add(ModBlocks.INDUSTRIAL_IRON_BLOCK);
                        entries.add(ModBlocks.INDUSTRIAL_COPPER_BLOCK);

                    }).build());

    public static void registerItemGroups() {
        Automechis.LOGGER.info("Registering Item Groups for " + Automechis.MOD_ID);
    }
}
