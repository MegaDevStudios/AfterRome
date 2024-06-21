package dev.mega.afterrome.core.config;

import dev.mega.afterrome.core.config.data.ConfigData;
import dev.mega.megacore.config.Configurator;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class Config extends Configurator {
    protected Config(@NotNull Plugin plugin, String... path) {
        super(plugin, path);
    }

    public ConfigData getConfigData() {
        return null;
    }
}
