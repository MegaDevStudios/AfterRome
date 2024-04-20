package com.megadev.afterrome.config;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class SettingsConfig extends Configurable {
    protected SettingsConfig(@NotNull Plugin plugin, String fileName) {
        super(plugin, ".", fileName, createDefaults());
    }

    private static Map<String, Object> createDefaults() {
        Map<String, Object> defaults = new HashMap<>();
        return defaults;
    }
}
