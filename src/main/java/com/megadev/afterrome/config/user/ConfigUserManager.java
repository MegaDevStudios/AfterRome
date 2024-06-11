package com.megadev.afterrome.config.user;

import dev.mega.megacore.config.SubFolder;
import org.bukkit.plugin.Plugin;

import java.io.*;
import java.util.Objects;
import java.util.UUID;

public class ConfigUserManager extends SubFolder {
    public ConfigUserManager(Plugin plugin, String dataFolder) {
        super(plugin, dataFolder);
    }

    public UserConfig getAfterRomeUserConfig(UUID uuid) {
        return new UserConfig(getPlugin(), getDataFolder(), uuid.toString());
    }

    public boolean userExist(UUID uuid) {
        String dataFolderPath = getPlugin().getDataFolder().getAbsolutePath();

        File fileDataFolder = new File(dataFolderPath + File.separator + "data");
        fileDataFolder.mkdirs();

        for (File file : Objects.requireNonNull(fileDataFolder.listFiles())) {
            try {
                if (file.getName().replace(".yml", "").equals(uuid.toString())
                        && new BufferedReader(new FileReader(file)).readLine() != null)
                    return true;
            } catch (IOException exception) {
                exception.printStackTrace();;
            }
        }
        return false;
    }
}
