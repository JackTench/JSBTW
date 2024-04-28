package me.jacktench.jsbtw.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ItemOrb extends Item
{
    private List<String> messageKeys = Arrays.asList(
            "message.orb.1", "message.orb.2", "message.orb.3",
            "message.orb.4", "message.orb.5", "message.orb.6",
            "message.orb.7", "message.orb.8", "message.orb.9",
            "message.orb.10"
    );

    public ItemOrb(Properties properties)
    {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
    {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            player.sendSystemMessage(Component.translatable(getMessage()));
        }
        return super.use(level, player, hand);
    }

    public String getMessage()
    {
        int randomIndex = new Random().nextInt(messageKeys.size());
        return messageKeys.get(randomIndex);
    }
}
