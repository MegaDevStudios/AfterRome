package com.megadev.afterrome.config.user;

import dev.mega.megacore.config.AbstractManager;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

public class ConfigUserManager extends AbstractManager {
    public ConfigUserManager(Plugin plugin, String dataFolder) {
        super(plugin, dataFolder);
    }

    public UserConfig getAfterRomeUserConfig(UUID uuid) {
        return new UserConfig(getPlugin(), getDataFolder(), uuid.toString());
    }
}
