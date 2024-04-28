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
    private List<String> messages = Arrays.asList(
            "The whispers of forgotten souls echo through the void...",
            "The Orb pulses with ancient energy, drawing the attention of unseen forces...",
            "Dark shadows dance at the edge of your vision as you hold the Orb...",
            "A chill runs down your spine as the Orb's light reveals spectral figures lurking nearby...",
            "You feel a presence watching you from beyond the veil as the Orb glows ominously...",
            "Visions of distant realms flicker in your mind's eye as you clutch the Orb tightly...",
            "The air grows heavy with the weight of unseen eyes, drawn to the Orb's power...",
            "Whispers of forgotten incantations fill your thoughts, spoken by voices long silenced...",
            "An otherworldly aura surrounds you, tingling with the energy of the Orb...",
            "The boundaries between worlds blur as the Orb's light pierces through the darkness..."
    );

    public ItemOrb(Properties properties)
    {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
    {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            player.sendSystemMessage(Component.literal(getMessage()));
        }
        return super.use(level, player, hand);
    }

    public String getMessage()
    {
        int randomIndex = new Random().nextInt(messages.size());
        return messages.get(randomIndex);
    }
}
