package com.megadev.afterrome.config;

import com.megadev.afterrome.config.professions.ProfessionsManager;
import dev.mega.megacore.config.Manager;
import lombok.Getter;
import org.bukkit.plugin.Plugin;

public class ConfigManager extends Manager {
    @Getter
    private static ConfigManager instance;

    public ConfigManager(Plugin plugin, String dataFolder) {
        super(plugin, dataFolder);

        addConfig(ProfessionsManager.class, new ProfessionsManager(plugin, "professions"));
    }

    public static void init(Plugin plugin) {
        if (instance == null)
            instance = new ConfigManager(plugin, ".");
    }
}
