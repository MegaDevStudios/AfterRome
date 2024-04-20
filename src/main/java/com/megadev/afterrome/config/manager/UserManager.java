package com.megadev.afterrome.config.manager;

import lombok.Getter;
import org.bukkit.plugin.Plugin;

public class UserManager implements Manager {
    @Getter private static UserManager instance;
    private final Plugin plugin;
    private final String dataFolder;

    public UserManager(Plugin plugin, String dataFolder) {
        this.plugin = plugin;
        this.dataFolder = dataFolder;
    }

    public static Manager init(Plugin plugin, String dataFolder) {
        if (instance == null) {
            instance = new UserManager(plugin, dataFolder);
        }

        return instance;
    }

    @Override
    public ChildConfig getConfig(String uuid) {
        return new UserConfig(plugin, dataFolder, uuid);
    }
}
