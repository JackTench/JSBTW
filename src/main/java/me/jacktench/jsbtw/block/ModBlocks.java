package me.jacktench.jsbtw.block;

import me.jacktench.jsbtw.JSBTW;
import me.jacktench.jsbtw.ModCreativeModeTab;
import me.jacktench.jsbtw.block.custom.BlockSpeedStone;
import me.jacktench.jsbtw.block.custom.SlabCraftingTable;
import me.jacktench.jsbtw.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, JSBTW.MODID);

    public static final RegistryObject<Block> SPEEDSTONE = registerBlock("speedstone", () -> new BlockSpeedStone(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MOD_TAB);

    // Test Code: declaring half slab.
    public static final RegistryObject<Block> CRAFTING_TABLE_SLAB = registerBlock("craftingtableslab", () -> new SlabCraftingTable(BlockBehaviour.Properties.of(Material.WOOD).strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.MOD_TAB);

    // Helper methods for registering BlockItems.
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
