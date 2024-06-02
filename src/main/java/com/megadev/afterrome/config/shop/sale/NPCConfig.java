package com.megadev.afterrome.config.shop.sale;

import dev.mega.megacore.config.Configurator;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class NPCConfig extends Configurator {
    public NPCConfig(@NotNull Plugin plugin, String... path) {
        super(plugin, path);
    }

    public String getNpcName() {
        return getValue("npc.name");
    }

    public String getMenuName() {
        return getValue("menu.name");
    }

    public Location getNpcLocation() {
        ConfigurationSection locationSection = config.getConfigurationSection("npc.location");

        if (locationSection == null) {
            return null;
        }

        World world = Bukkit.getWorld(Objects.requireNonNull(locationSection.getString("world")));
        double x = locationSection.getDouble("x");
        double y = locationSection.getDouble("y");
        double z = locationSection.getDouble("z");

        return new Location(world, x, y, z);
    }

    public List<ItemStack> getAgronomistSellItems() {
        List<ItemStack> itemStacks = new ArrayList<>();
        ConfigurationSection sellItemsSection = config.getConfigurationSection("menu.professions.agronomist.sell-items");

        if (sellItemsSection == null) return new ArrayList<>();

        Set<String> keysSellItems = sellItemsSection.getKeys(false);

        for (String item : keysSellItems) {
            itemStacks.add(new ItemStack(Material.valueOf(item)));
            int price = sellItemsSection.getInt(item);
        }

        return itemStacks;
    }
}
