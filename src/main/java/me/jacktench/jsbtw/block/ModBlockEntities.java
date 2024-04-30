package me.jacktench.jsbtw.block;

import me.jacktench.jsbtw.JSBTW;
import me.jacktench.jsbtw.block.entity.BlockEntityReflector;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities
{
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, JSBTW.MODID);

    public static final RegistryObject<BlockEntityType<BlockEntityReflector>> REFLECTOR = BLOCK_ENTITIES.register("reflector",
            () -> BlockEntityType.Builder.of(BlockEntityReflector::new, ModBlocks.REFLECTOR.get()).build(null));

    public static void register(IEventBus eventBus)
    {
        BLOCK_ENTITIES.register(eventBus);
    }
}
