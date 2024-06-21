package dev.mega.afterrome.core.config;

import dev.mega.megacore.MegaCore;
import dev.mega.megacore.config.SubFolder;

public class ConfigManager extends SubFolder {
//    @Getter private static ConfigManager instance;

    public ConfigManager(MegaCore plugin) {
        super(plugin, "xdev");

        addConfig(new Config(plugin, getDataFolder(), "config"));
    }
//
//    public static SubFolder init(MegaCore megaCore) {
//        if (instance == null) {
//            instance = new ConfigManager(megaCore);
//        }
//        return instance;
//    }
}
