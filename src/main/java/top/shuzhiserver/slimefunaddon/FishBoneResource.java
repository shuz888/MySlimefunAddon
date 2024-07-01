package top.shuzhiserver.slimefunaddon;

import io.github.thebusybiscuit.slimefun4.api.geo.GEOResource;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class FishBoneResource implements GEOResource {
    private final NamespacedKey key;
    private final ItemStack item;
    public FishBoneResource(Plugin plugin, ItemStack item) {
        this.key = new NamespacedKey(plugin,"fish_bone");
        this.item = item;
    }

    @Override
    public int getDefaultSupply(World.Environment environment, Biome biome) {
        if(environment == World.Environment.NORMAL&&(biome == Biome.RIVER||biome == Biome.BEACH||biome == Biome.OCEAN)){
            return 10;
        }
        else return 0;
    }

    @Override
    public int getMaxDeviation() {
        return 5;
    }

    @Override
    public String getName() {
        return "鱼骨";
    }

    @Override
    public ItemStack getItem() {
        return this.item.clone();
    }

    @Override
    public boolean isObtainableFromGEOMiner() {
        return true;
    }

    @Override
    public NamespacedKey getKey() {
        return key;
    }
}
