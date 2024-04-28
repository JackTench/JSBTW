package me.jacktench.jsbtw;

import me.jacktench.jsbtw.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab
{
    public static final CreativeModeTab MOD_TAB = new CreativeModeTab("jsbtwtab")
    {
        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(ModItems.ORB.get());
        }
    };
}
