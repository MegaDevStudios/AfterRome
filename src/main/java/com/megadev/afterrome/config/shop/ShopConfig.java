package com.megadev.afterrome.config.shop;

import dev.mega.megacore.config.Configurable;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class ShopConfig extends Configurable {
    public ShopConfig(@NotNull Plugin plugin, String... path) {
        super(plugin, path);
    }
}
