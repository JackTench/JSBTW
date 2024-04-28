package me.jacktench.jsbtw.item;

import me.jacktench.jsbtw.JSBTW;
import me.jacktench.jsbtw.ModCreativeModeTab;
import me.jacktench.jsbtw.item.custom.ItemOrb;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, JSBTW.MODID);

    public static final RegistryObject<Item> ORB = ITEMS.register("orb", () -> new ItemOrb(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.MOD_TAB)));
    public static final RegistryObject<Item> STARFALL_BLADE = ITEMS.register("starfall_blade", () -> new SwordItem(Tiers.NETHERITE, 3, -2.4F, (new Item.Properties()).tab(ModCreativeModeTab.MOD_TAB)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
