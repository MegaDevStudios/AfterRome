package com.megadev.afterrome.config.manager;

import lombok.Getter;
import org.bukkit.plugin.Plugin;

public class ProfessionManager implements Manager {
    @Getter private static ProfessionManager instance;
    private final Plugin plugin;
    private final String dataFolder;

    public ProfessionManager(Plugin plugin, String dataFolder) {
        this.plugin = plugin;
        this.dataFolder = dataFolder;
    }

    public static Manager init(Plugin plugin, String dataFolder) {
        if (instance == null) {
            instance = new ProfessionManager(plugin, dataFolder);
        }

        return instance;
    }

    @Override
    public ChildConfig getConfig(String profession) {
        return new ProfessionConfig(plugin, dataFolder, profession);
    }
}
