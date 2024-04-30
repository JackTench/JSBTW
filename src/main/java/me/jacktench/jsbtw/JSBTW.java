package me.jacktench.jsbtw;

import com.mojang.logging.LogUtils;
import me.jacktench.jsbtw.block.ModBlockEntities;
import me.jacktench.jsbtw.block.ModBlocks;
import me.jacktench.jsbtw.item.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(JSBTW.MODID)
public class JSBTW
{
    public static final String MODID = "jsbtw";
    private static final Logger LOGGER = LogUtils.getLogger();

    public JSBTW()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // The setRenderLayer method is being deprecated post-1.19, I should probably fix this.
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GLOWING_GLASS.get(), RenderType.translucent());
        }
    }
}
