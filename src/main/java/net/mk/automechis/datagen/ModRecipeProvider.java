package net.mk.automechis.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.mk.automechis.block.ModBlocks;
import net.mk.automechis.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.INDUSTRIAL_IRON_INGOT,
                RecipeCategory.MISC, ModBlocks.INDUSTRIAL_IRON_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GEAR, 1)
                .pattern(" # ")
                .pattern("# #")
                .pattern(" # ")
                .input('#', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEAR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.IRON_ROD, 1)
                .pattern("#")
                .pattern("#")
                .input('#', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.IRON_ROD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SPRING, 1)
                .pattern("NRN")
                .input('N', Items.IRON_NUGGET)
                .input('R', ModItems.IRON_ROD)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SPRING)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.INDUSTRIAL_IRON_INGOT)
                .input(Items.IRON_INGOT)
                .input(Items.IRON_NUGGET)
                .input(ModItems.IRON_ROD)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                .criterion(hasItem(ModItems.IRON_ROD), conditionsFromItem(ModItems.IRON_ROD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.INDUSTRIAL_IRON_INGOT)));
    }
}
