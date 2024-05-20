package com.megadev.afterrome.manager;

import com.megadev.afterrome.config.MainConfig;
import com.megadev.afterrome.config.profession.*;
import com.megadev.afterrome.config.shop.ShopConfig;
import dev.mega.megacore.config.Manager;

import lombok.Getter;

import org.bukkit.plugin.Plugin;

public class ConfigManager extends Manager {
    @Getter
    private static ConfigManager instance;

    protected ConfigManager(Plugin plugin, String dataFolder) {
        super(plugin, dataFolder);

//        addConfig(ProfessionsManager.class, new ProfessionsManager(plugin, "professions"));
        addConfig(ShopConfig.class, new ShopConfig(plugin, "shop"));
        addConfig(MainConfig.class, new MainConfig(plugin, "config"));

        addConfig(AesculapiusConfig.class, new AesculapiusConfig(plugin, "aesculapius"));
        addConfig(AgronomistConfig.class, new AgronomistConfig(plugin, "agronomist"));
        addConfig(ArtisanConfig.class, new ArtisanConfig(plugin, "artisan"));
        addConfig(EngineerConfig.class, new EngineerConfig(plugin, "engineer"));
        addConfig(ForesterConfig.class, new ForesterConfig(plugin, "forester"));
        addConfig(InitiatedConfig.class, new InitiatedConfig(plugin, "initiated"));
        addConfig(MafiaConfig.class, new MafiaConfig(plugin, "mafia"));
        addConfig(SantaConfig.class, new SantaConfig(plugin, "santa"));
        addConfig(SheriffConfig.class, new SheriffConfig(plugin, "sheriff"));
        addConfig(SonOfMarsConfig.class, new SonOfMarsConfig(plugin, "sonOfMars"));
    }

    public static void init(Plugin plugin) {
        if (instance == null)
            instance = new ConfigManager(plugin, ".");
    }
}
