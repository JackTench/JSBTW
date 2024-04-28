package me.jacktench.jsbtw.block.custom;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.inventory.MenuType;

public class SlabCraftingMenu extends CraftingMenu
{
    private final ContainerLevelAccess access;

    public SlabCraftingMenu(int p_39356_, Inventory p_39357_, ContainerLevelAccess p_39358_)
    {
        super(p_39356_, p_39357_, p_39358_);
        this.access = p_39358_;
    }

    public SlabCraftingMenu(int p_39353_, Inventory p_39354_)
    {
        this(p_39353_, p_39354_, ContainerLevelAccess.NULL);
    }

    @Override
    public MenuType<?> getType()
    {
        return MY_MENU_TYPE.get();
    }

    @Override
    public boolean stillValid(Player p_39368_)
    {
        return stillValid(this.access, p_39368_, SlabCraftingTable.get());
    }
}
