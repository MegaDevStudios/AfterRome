package com.megadev.afterrome.config.profession;

import dev.mega.megacore.config.Configurator;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class EngineerConfig extends ProfessionConfig {
    public EngineerConfig(@NotNull Plugin plugin, String... path) {
        super(plugin, path);
    }

    @Override
    public String getName() {
        return "";
    }
}
