package net.mk.automechis.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.mk.automechis.Automechis;

public class ModItemGroups {

    public static final ItemGroup GEAR_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Automechis.MOD_ID, "iron_gear"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.iron_gear"))
                    .icon(() -> new ItemStack(ModItems.IRON_GEAR)).entries((displayContext, entries) -> {

                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.IRON_GEAR);

                    }).build());

    public static void registerItemGroups() {
        Automechis.LOGGER.info("Registering Item Groups for " + Automechis.MOD_ID);
    }
}
