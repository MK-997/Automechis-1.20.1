package net.mk.automechis.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.mk.automechis.block.ModBlocks;
import net.mk.automechis.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.INDUSTRIAL_IRON_INGOT,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.INDUSTRIAL_IRON_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.INDUSTRIAL_COPPER_INGOT,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.INDUSTRIAL_COPPER_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.COPPER_NUGGET,
                RecipeCategory.MISC, Items.COPPER_INGOT);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GEAR, 1)
                .pattern(" # ")
                .pattern("# #")
                .pattern(" # ")
                .input('#', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEAR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.IRON_ROD, 4)
                .pattern("#")
                .pattern("#")
                .input('#', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.IRON_ROD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COPPER_ROD, 4)
                .pattern("#")
                .pattern("#")
                .input('#', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.COPPER_ROD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SPRING, 1)
                .pattern("NRN")
                .input('N', Items.IRON_NUGGET)
                .input('R', ModItems.IRON_ROD)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SPRING)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.INDUSTRIAL_IRON_INGOT, 1)
                .input(Items.IRON_INGOT)
                .input(Items.IRON_NUGGET)
                .input(ModItems.IRON_ROD)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                .criterion(hasItem(ModItems.IRON_ROD), conditionsFromItem(ModItems.IRON_ROD))
                .offerTo(exporter, "industrial_iron_ingot_from_iron");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.INDUSTRIAL_COPPER_INGOT, 1)
                .input(Items.COPPER_INGOT)
                .input(ModItems.COPPER_NUGGET)
                .input(ModItems.COPPER_ROD)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(ModItems.COPPER_NUGGET), conditionsFromItem(ModItems.COPPER_NUGGET))
                .criterion(hasItem(ModItems.COPPER_ROD), conditionsFromItem(ModItems.COPPER_ROD))
                .offerTo(exporter, "industrial_copper_ingot_from_copper");
    }
}
