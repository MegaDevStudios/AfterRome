package com.megadev.afterrome.config.profession;

import com.megadev.afterrome.util.Color;
import dev.mega.megacore.config.Configurator;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class AesculapiusConfig extends Configurator {

    public AesculapiusConfig(@NotNull Plugin plugin, String... path) {
        super(plugin, path);
    }

    public String getName() {
        return Color.colorize(getString("name"));
    }
}
