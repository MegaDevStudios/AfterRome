package com.megadev.afterrome.config.shop;

import dev.mega.megacore.config.Configurator;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Objects;

public class ShopConfig extends Configurator {
    public ShopConfig(@NotNull Plugin plugin, String... path) {
        super(plugin, path);
    }

    public String getNpcName() {
        return getString("npc.name");
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
}
