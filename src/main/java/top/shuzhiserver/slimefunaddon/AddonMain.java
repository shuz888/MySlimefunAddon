package top.shuzhiserver.slimefunaddon;

import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import top.shuzhiserver.slimefunaddon.items.*;
import top.shuzhiserver.slimefunaddon.items.CowBone;
import top.shuzhiserver.slimefunaddon.items.DiamondGummie;
import top.shuzhiserver.slimefunaddon.items.FishBone;
import top.shuzhiserver.slimefunaddon.items.GelatinSheets;

public class AddonMain extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }

        NamespacedKey researchKey = new NamespacedKey(this, "ancient");
        Research research = new Research(researchKey,1234012843,"成功解锁研究[远骨]",5);
        NamespacedKey categoryId = new NamespacedKey(this, "category1");
        CustomItemStack categoryItem = new CustomItemStack(Material.DIAMOND,"&4CAPTAINchad12自制扩展");
        ItemGroup itemGroup = new ItemGroup(categoryId,categoryItem);
        SlimefunItemStack fishBoneItem = new SlimefunItemStack("FISH_BONE","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQzMGFiNTQ1YjE0MjgyN2I5MzVmYzdlMzBmZDFhMTczZmE5MWI5M2NhYmJhNDVmODVmMjJhZWVkMGFlZmFjNyJ9fX0=","&5鱼骨","吉利丁片的原料");
        FishBone fishBone = new FishBone(itemGroup,fishBoneItem,RecipeType.GEO_MINER,new ItemStack[9]);
        fishBone.register(this);
        FishBoneResource resource = new FishBoneResource(this,fishBoneItem);
        resource.register();

        SlimefunItemStack cowBoneItem = new SlimefunItemStack("COW_BONE","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQzMGFiNTQ1YjE0MjgyN2I5MzVmYzdlMzBmZDFhMTczZmE5MWI5M2NhYmJhNDVmODVmMjJhZWVkMGFlZmFjNyJ9fX0=","&5牛骨","吉利丁片的原料");
        ItemStack[] recipe = {
                new ItemStack(Material.LEGACY_RAW_BEEF), null, null,
                                                   null, null, null,
                                                   null, null, null,
        };
        CowBone cowBone = new CowBone(itemGroup,cowBoneItem,RecipeType.ENHANCED_CRAFTING_TABLE,recipe);
        cowBone.register(this);
        research.addItems(fishBoneItem,cowBoneItem);
        research.register();

        SlimefunItemStack gelatinSheetsIItem = new SlimefunItemStack("GELATIN_SHEETS_I","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGEyNGRjOWYxNzMzZjAwZTY3NjUwOWEyMjFiOGE2NmE2ZTA1OWU1NTA0NWQwOGE3ZTRmYzA4ZDdkMzEwODc1OCJ9fX0=","&5吉利丁片 I","可以打造各种软糖...");
        recipe = new ItemStack[]{
                fishBoneItem, cowBoneItem, fishBoneItem,
                cowBoneItem,  cowBoneItem, cowBoneItem ,
                fishBoneItem, cowBoneItem, fishBoneItem
        };
        researchKey = new NamespacedKey(this, "softenerI");
        research = new Research(researchKey, 1203948286, "成功解锁研究[软化剂 I]", 3);
        GelatinSheets gelatinSheetsI = new GelatinSheets(itemGroup,gelatinSheetsIItem,RecipeType.ENHANCED_CRAFTING_TABLE,recipe);
        gelatinSheetsI.register(this);
        research.addItems(gelatinSheetsIItem);
        research.register();

        SlimefunItemStack diamondGummieItem = new SlimefunItemStack("DIAMOND_GUMMIE","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGEyNGRjOWYxNzMzZjAwZTY3NjUwOWEyMjFiOGE2NmE2ZTA1OWU1NTA0NWQwOGE3ZTRmYzA4ZDdkMzEwODc1OCJ9fX0=","&5钻石软糖","入口即化,附带抗性提升5");
        recipe = new ItemStack[]{
                gelatinSheetsIItem, new ItemStack(Material.SUGAR)  , gelatinSheetsIItem,
                gelatinSheetsIItem, new ItemStack(Material.DIAMOND), gelatinSheetsIItem,
                gelatinSheetsIItem, new ItemStack(Material.SUGAR)  , gelatinSheetsIItem
        };
        researchKey = new NamespacedKey(this, "gummiesI");
        research = new Research(researchKey, 386849233, "成功解锁研究[好吃的软糖]", 10);
        DiamondGummie diamondGummie = new DiamondGummie(itemGroup,diamondGummieItem,RecipeType.ENHANCED_CRAFTING_TABLE,recipe);
        diamondGummie.register(this);
        research.addItems(diamondGummie);
        SlimefunItemStack emeraldGummieItem = new SlimefunItemStack("EMERALD_GUMMIE","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTk4NWU5NjEyMjgzOTNhNGNkNTdmYWFlMTdiZmIwN2JkMGZkYTA4NTMxNmZkOGJlNTg0NTk4NzRkZWNjM2JjOCJ9fX0=","&5绿宝石软糖","入口即化,附带村庄英雄");
        recipe = new ItemStack[]{
                gelatinSheetsIItem, new ItemStack(Material.SUGAR)  , gelatinSheetsIItem,
                gelatinSheetsIItem, new ItemStack(Material.EMERALD), gelatinSheetsIItem,
                gelatinSheetsIItem, new ItemStack(Material.SUGAR)  , gelatinSheetsIItem
        };
        EmeraldGummie emeraldGummie = new EmeraldGummie(itemGroup,emeraldGummieItem,RecipeType.ENHANCED_CRAFTING_TABLE,recipe);
        emeraldGummie.register(this);
        research.addItems(emeraldGummie);
        SlimefunItemStack waterGummieItem = new SlimefunItemStack("WATER_GUMMIE","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2RkYWYyZTk0NDUzZjUzMDg2MWUwNWEwMGQ0MzRhZTRjMDFhYWZkMDQ5OWZmMmMyNGNiZTFiZjM0OTlmMmU0MCJ9fX0=","&5水软糖","入口即化,就是没啥味,附带水下呼吸");
        recipe = new ItemStack[]{
                gelatinSheetsIItem, gelatinSheetsIItem  , gelatinSheetsIItem,
                gelatinSheetsIItem, new ItemStack(Material.WATER_BUCKET), gelatinSheetsIItem,
                gelatinSheetsIItem, gelatinSheetsIItem  , gelatinSheetsIItem
        };
        WaterGummie waterGummie = new WaterGummie(itemGroup,waterGummieItem,RecipeType.ENHANCED_CRAFTING_TABLE,recipe);
        waterGummie.register(this);
        research.addItems(waterGummie);
        research.register();

        researchKey = new NamespacedKey(this, "softenerII");
        research = new Research(researchKey, 584769432, "成功解锁研究[软化剂 II]", 5);
        SlimefunItemStack gelatinSheetsIIItem = new SlimefunItemStack("GELATIN_SHEETS_II","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGEyNGRjOWYxNzMzZjAwZTY3NjUwOWEyMjFiOGE2NmE2ZTA1OWU1NTA0NWQwOGE3ZTRmYzA4ZDdkMzEwODc1OCJ9fX0=","&5吉利丁片 II","强化的吉利丁片,要想软化铀就必须用它");
        recipe = new ItemStack[]{
                gelatinSheetsIItem, gelatinSheetsIItem, gelatinSheetsIItem,
                gelatinSheetsIItem, gelatinSheetsIItem, gelatinSheetsIItem,
                gelatinSheetsIItem, gelatinSheetsIItem, gelatinSheetsIItem
        };
        GelatinSheets gelatinSheetsII = new GelatinSheets(itemGroup,gelatinSheetsIIItem,RecipeType.ENHANCED_CRAFTING_TABLE,recipe);
        gelatinSheetsII.register(this);
        research.addItems(gelatinSheetsII);
        research.register();

        researchKey = new NamespacedKey(this, "gummiesII");
        research = new Research(researchKey, 584769432, "成功解锁研究[高级软糖]", 15);
        SlimefunItemStack uraniumGummieItem = new SlimefunItemStack("URANIUM_GUMMIE",SlimefunItems.URANIUM,"&4轴软糖","有着强大的力量!");
        recipe = new ItemStack[]{
                gelatinSheetsIIItem, SlimefunItems.URANIUM        , gelatinSheetsIIItem,
                gelatinSheetsIIItem, SlimefunItems.URANIUM        , gelatinSheetsIIItem,
                gelatinSheetsIIItem, SlimefunItems.URANIUM        , gelatinSheetsIIItem
        };
        UraniumGummie uraniumGummie = new UraniumGummie(itemGroup,uraniumGummieItem,RecipeType.MAGIC_WORKBENCH,recipe);
        uraniumGummie.register(this);
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
