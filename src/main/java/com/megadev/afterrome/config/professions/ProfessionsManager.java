package com.megadev.afterrome.config.professions;

import com.megadev.afterrome.config.ConfigManager;
import dev.mega.megacore.config.Manager;

import lombok.Getter;

import org.bukkit.plugin.Plugin;

public class ProfessionsManager extends Manager {
    @Getter private static ProfessionsManager instance;
    public ProfessionsManager(Plugin plugin, String dataFolder) {
        super(plugin, dataFolder);

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
}