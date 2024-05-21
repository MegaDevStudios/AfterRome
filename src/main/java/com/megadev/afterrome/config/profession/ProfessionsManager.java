package com.megadev.afterrome.config.profession;

import dev.mega.megacore.config.Manager;

import lombok.Getter;

import org.bukkit.plugin.Plugin;

public class ProfessionsManager extends Manager {
    @Getter private static ProfessionsManager instance;
    public ProfessionsManager(Plugin plugin, String dataFolder) {
        super(plugin, dataFolder);

        addConfig(AesculapiusConfig.class, new AesculapiusConfig(plugin, getDataFolder() + "/aesculapius"));
        addConfig(AgronomistConfig.class, new AgronomistConfig(plugin, getDataFolder() + "/agronomist"));
        addConfig(ArtisanConfig.class, new ArtisanConfig(plugin, getDataFolder() + "/artisan"));
        addConfig(EngineerConfig.class, new EngineerConfig(plugin, getDataFolder() + "/engineer"));
        addConfig(ForesterConfig.class, new ForesterConfig(plugin, getDataFolder() + "/forester"));
        addConfig(InitiatedConfig.class, new InitiatedConfig(plugin, getDataFolder() + "/initiated"));
        addConfig(MafiaConfig.class, new MafiaConfig(plugin, getDataFolder() + "/mafia"));
        addConfig(SantaConfig.class, new SantaConfig(plugin, getDataFolder() + "/santa"));
        addConfig(SheriffConfig.class, new SheriffConfig(plugin, getDataFolder() + "/sheriff"));
        addConfig(SonOfMarsConfig.class, new SonOfMarsConfig(plugin, getDataFolder() + "/sonOfMars"));
    }
}