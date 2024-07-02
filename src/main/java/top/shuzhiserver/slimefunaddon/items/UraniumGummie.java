package top.shuzhiserver.slimefunaddon.items;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactive;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class UraniumGummie extends SlimefunItem implements Radioactive {
    public UraniumGummie(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }
    @Override
    public void preRegister(){
        ItemUseHandler itemUseHandler = this::onItemUseRightClick;
        addItemHandler(itemUseHandler);
    }
    private void onItemUseRightClick(PlayerRightClickEvent event) {
        // Calling event.cancel() in here would prevent the cake
        // from being placed down.
        Player player = event.getPlayer();
        // 给予玩家所有正向效果
        for (PotionEffectType effectType : PotionEffectType.values()) {
            if (effectType != null && isPositiveEffect(effectType)) {
                player.addPotionEffect(new PotionEffect(effectType, Integer.MAX_VALUE, 1));
            }
        }
        event.getPlayer().setFoodLevel(100);
        event.getPlayer().setSaturation(100);
        event.getItem().setAmount(event.getItem().getAmount()-1);
        event.cancel();
    }
    private boolean isPositiveEffect(PotionEffectType effectType) {
        switch (effectType.getName()) {
            case "SPEED":
            case "FAST_DIGGING":
            case "INCREASE_DAMAGE":
            case "HEAL":
            case "JUMP":
            case "REGENERATION":
            case "DAMAGE_RESISTANCE":
            case "FIRE_RESISTANCE":
            case "WATER_BREATHING":
            case "INVISIBILITY":
            case "NIGHT_VISION":
            case "HEALTH_BOOST":
            case "ABSORPTION":
            case "SATURATION":
            case "GLOWING":
            case "LEVITATION":
            case "LUCK":
            case "CONDUIT_POWER":
            case "DOLPHINS_GRACE":
            case "HERO_OF_THE_VILLAGE":
            case "SLOW_FALLING":
                return true;
            default:
                return false;
        }
    }

    @Override
    public Radioactivity getRadioactivity() {
        return Radioactivity.VERY_HIGH;
    }
}
