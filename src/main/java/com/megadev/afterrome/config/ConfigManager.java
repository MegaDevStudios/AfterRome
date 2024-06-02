package com.megadev.afterrome.config;

import com.megadev.afterrome.config.manager.ProfessionsManager;
import com.megadev.afterrome.config.manager.shop.ShopManager;
import com.megadev.afterrome.config.user.ConfigUserManager;

import dev.mega.megacore.config.SubFolder;
import lombok.Getter;

import org.bukkit.plugin.Plugin;

public class ConfigManager extends SubFolder {
    @Getter
    private static ConfigManager instance;

    protected ConfigManager(Plugin plugin, String dataFolder) {
        super(plugin, dataFolder);

        addConfig(ProfessionsManager.class, new ProfessionsManager(plugin, "professions"));
        addConfig(ShopManager.class, new ShopManager(plugin, "shop"));
        addConfig(MainConfig.class, new MainConfig(plugin, "config"));
        addConfig(ConfigUserManager.class, new ConfigUserManager(plugin, "data"));
    }

    public static void init(Plugin plugin) {
        if (instance == null)
            instance = new ConfigManager(plugin, ".");
    }
}
