package com.megadev.afterrome.config.user;

import dev.mega.megacore.config.AbstractManager;
import org.bukkit.plugin.Plugin;

import java.util.Objects;
import java.util.UUID;
import java.io.File;

public class ConfigUserManager extends AbstractManager {
    public ConfigUserManager(Plugin plugin, String dataFolder) {
        super(plugin, dataFolder);
    }

    public UserConfig getAfterRomeUserConfig(UUID uuid) {
        return new UserConfig(getPlugin(), getDataFolder() + "/" + uuid.toString());
    }

    public boolean userExist(UUID uuid) {
        String dataFolderPath = getPlugin().getDataFolder().getAbsolutePath();

        File fileDataFolder = new File(dataFolderPath);

        for (File file : Objects.requireNonNull(fileDataFolder.listFiles())) {
            if (file.getName().equals(uuid.toString())) return true;
        }
        return false;
    }
}
