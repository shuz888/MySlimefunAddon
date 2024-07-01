package top.shuzhiserver.slimefunaddon;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

public class AddonMain extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }

        NamespacedKey categoryId = new NamespacedKey(this, "category1");
        CustomItemStack categoryItem = new CustomItemStack(Material.DIAMOND,"&4CAPTAINchad12自制扩展");
        ItemGroup itemGroup = new ItemGroup(categoryId,categoryItem);
        SlimefunItemStack fishBoneItem = new SlimefunItemStack("FISH_BONE","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQzMGFiNTQ1YjE0MjgyN2I5MzVmYzdlMzBmZDFhMTczZmE5MWI5M2NhYmJhNDVmODVmMjJhZWVkMGFlZmFjNyJ9fX0=","&5鱼骨","吉利丁片的原料","&r远古鱼类的化石,使用GEO矿机在河流,海洋群系挖掘");
        SlimefunItem fishBone = new SlimefunItem(itemGroup,fishBoneItem,RecipeType.GEO_MINER,new ItemStack[9]);
        fishBone.register(this);
        FishBoneResource resource = new FishBoneResource(this,fishBoneItem);
        resource.register();
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * You will need to return a reference to your Plugin here.
         * If you are using your main class for this, simply return "this".
         */
        return this;
    }

}