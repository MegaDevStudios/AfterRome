package com.megadev.afterrome.config.profession;

import dev.mega.megacore.config.Configurator;
import dev.mega.megacore.util.Color;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public abstract class ProfessionConfig extends Configurator {

    protected ProfessionConfig(@NotNull Plugin plugin, String... path) {
        super(plugin, path);
    }

    public String getName() {
        return Color.getTranslated((String) getValue("name"));
    }
}
