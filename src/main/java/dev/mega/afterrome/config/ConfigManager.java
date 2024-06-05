package dev.mega.afterrome.config;

import dev.mega.megacore.MegaCore;
import dev.mega.megacore.config.SubFolder;
import lombok.Getter;
import org.bukkit.plugin.Plugin;

public class ConfigManager extends SubFolder {
    @Getter private static ConfigManager instance;

    private ConfigManager(Plugin plugin) {
        super(plugin, "xdev");

        addConfig(Config.class, new Config(plugin, getDataFolder(), "config"));
    }

    public static void init(MegaCore megaCore) {
        if (instance == null) {
            instance = new ConfigManager(megaCore);
        }
    }
}
