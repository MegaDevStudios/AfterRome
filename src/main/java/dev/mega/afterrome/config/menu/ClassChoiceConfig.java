package dev.mega.afterrome.config.menu;

import dev.mega.megacore.config.Configurator;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class ClassChoiceConfig extends Configurator {

    protected ClassChoiceConfig(@NotNull Plugin plugin, String... path) {
        super(plugin, path);
    }

    public ClassChoiceMenuData getClassChoiceMenuData() {
        return null;
    }
}
