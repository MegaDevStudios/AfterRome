package com.megadev.afterrome.manager;

import com.megadev.afterrome.config.MainConfig;
import com.megadev.afterrome.config.manager.ProfessionsManager;
import com.megadev.afterrome.config.manager.ShopManager;
import com.megadev.afterrome.config.shop.ShopConfig;
import dev.mega.megacore.config.AbstractManager;

import lombok.Getter;

import org.bukkit.plugin.Plugin;

public class ConfigManager extends AbstractManager {
    @Getter
    private static ConfigManager instance;

    protected ConfigManager(Plugin plugin, String dataFolder) {
        super(plugin, dataFolder);

        addConfig(ProfessionsManager.class, new ProfessionsManager(plugin, "professions"));
        addConfig(ShopManager.class, new ShopManager(plugin, "shop"));
        addConfig(MainConfig.class, new MainConfig(plugin, "config"));

    }

    public static void init(Plugin plugin) {
        if (instance == null)
            instance = new ConfigManager(plugin, ".");
    }
}
