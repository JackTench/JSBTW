package me.jacktench.jsbtw.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.*;

public class ItemOrb extends Item
{
    private List<String> messageKeys = Arrays.asList(
            "message.orb.1", "message.orb.2", "message.orb.3",
            "message.orb.4", "message.orb.5", "message.orb.6",
            "message.orb.7", "message.orb.8", "message.orb.9",
            "message.orb.10"
    );

    private List<MobEffectInstance> effects = Arrays.asList(
            // Positive Effects
            new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1),
            new MobEffectInstance(MobEffects.DIG_SPEED, 200, 1),
            // Negative Effects
            new MobEffectInstance(MobEffects.BLINDNESS, 200, 1),
            new MobEffectInstance(MobEffects.HARM, 200, 1),
            new MobEffectInstance(MobEffects.WITHER, 200, 1)
    );

    // User a map to track the last time the item was used by player UUID.
    private Map<UUID, Long> lastUseTimes = new HashMap<>();

    public ItemOrb(Properties properties)
    {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
    {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            UUID playerUUID = player.getUUID();
            long currentTime = System.currentTimeMillis();
            long lastUseTime = lastUseTimes.getOrDefault(playerUUID, 0L);

            if (currentTime - lastUseTime  < 60000) {
                return InteractionResultHolder.fail(player.getItemInHand(hand));
            }

            lastUseTimes.put(playerUUID, currentTime);

            player.sendSystemMessage(Component.translatable(getMessage()));
            player.addEffect(getEffect());
        }
        return super.use(level, player, hand);
    }

    public String getMessage()
    {
        int randomIndex = new Random().nextInt(messageKeys.size());
        return messageKeys.get(randomIndex);
    }

    public MobEffectInstance getEffect()
    {
        int randomIndex = new Random().nextInt(effects.size());
        return effects.get(randomIndex);
    }
}
