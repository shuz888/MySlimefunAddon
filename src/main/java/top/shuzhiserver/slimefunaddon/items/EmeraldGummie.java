package top.shuzhiserver.slimefunaddon.items;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EmeraldGummie extends SlimefunItem {
    public EmeraldGummie(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
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
        PotionEffect resistanceEffect = new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE,88888*20,1);
        event.getPlayer().addPotionEffect(resistanceEffect);
        event.getPlayer().setFoodLevel(20);
        event.getPlayer().setSaturation(20.0f);
        event.getItem().setAmount(event.getItem().getAmount()-1);
        event.cancel();
    }
}
