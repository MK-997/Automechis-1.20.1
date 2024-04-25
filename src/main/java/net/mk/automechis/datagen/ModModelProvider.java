package net.mk.automechis.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.mk.automechis.block.ModBlocks;
import net.mk.automechis.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.INDUSTRIAL_IRON_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.INDUSTRIAL_IRON_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPRING, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_ROD, Models.GENERATED);
    }
}
