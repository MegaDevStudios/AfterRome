package com.megadev.afterrome.config.profession;

import dev.mega.megacore.config.Configurator;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class InitiatedConfig extends ProfessionConfig {
    public InitiatedConfig(@NotNull Plugin plugin, String... path) {
        super(plugin, path);
    }

    @Override
    public String getName() {
        return "";
    }
}
