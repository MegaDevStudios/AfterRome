package com.megadev.afterrome.config;

import com.megadev.afterrome.config.manager.Manager;
import com.megadev.afterrome.config.manager.ProfessionManager;
import com.megadev.afterrome.config.manager.UserManager;
import lombok.Getter;
import org.bukkit.plugin.Plugin;

public class ConfigManager {
    @Getter private static ConfigManager instance;
    @Getter private final Manager userManager;
    @Getter private final Manager professionConfig;

    public ConfigManager(Plugin plugin) {
        this.userManager = UserManager.init(plugin, "userdata");
        this.professionConfig = ProfessionManager.init(plugin, "profession");
    }

    public static void init(Plugin plugin) {
        if (instance == null) {
            instance = new ConfigManager(plugin);
        }
    }
}
