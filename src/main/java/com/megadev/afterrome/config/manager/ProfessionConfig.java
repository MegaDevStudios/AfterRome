package com.megadev.afterrome.config.manager;

import com.megadev.afterrome.config.Configurable;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class ProfessionConfig extends Configurable implements ChildConfig {
    protected ProfessionConfig(@NotNull Plugin plugin, String dataFolderName, String fileName) {
        super(plugin, dataFolderName, fileName, createDefaults());
    }

    private static Map<String, Object> createDefaults() {
        Map<String, Object> defaults = new HashMap<>();
        return defaults;
    }
}
