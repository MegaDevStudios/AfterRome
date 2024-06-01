package com.megadev.afterrome.config.user;

import dev.mega.megacore.config.Configurator;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class UserConfig extends Configurator {
    protected UserConfig(@NotNull Plugin plugin, String... path) {
        super(plugin, path);
    }

    public void saveData(Map<String, Object> args) {
        for (Map.Entry<String, Object> arg : args.entrySet()) {
            String key = arg.getKey();
            Object value = arg.getValue();

            setValue(key, value);
        }
    }
}
