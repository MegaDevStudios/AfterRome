package com.megadev.afterrome.manager;

import com.megadev.afterrome.config.MainConfig;
import com.megadev.afterrome.config.profession.ProfessionsManager;
import com.megadev.afterrome.config.shop.ShopConfig;
import dev.mega.megacore.config.Manager;

import lombok.Getter;

import org.bukkit.plugin.Plugin;

public class ConfigManager extends Manager {
    @Getter
    private static ConfigManager instance;

    protected ConfigManager(Plugin plugin, String dataFolder) {
        super(plugin, dataFolder);

        addConfig(ProfessionsManager.class, new ProfessionsManager(plugin, "professions"));
        addConfig(ShopConfig.class, new ShopConfig(plugin, "shop"));
        addConfig(MainConfig.class, new MainConfig(plugin, "config"));
    }

    public static void init(Plugin plugin) {
        if (instance == null)
            instance = new ConfigManager(plugin, ".");
    }
}
