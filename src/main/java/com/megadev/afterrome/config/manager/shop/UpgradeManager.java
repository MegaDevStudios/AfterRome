package com.megadev.afterrome.config.manager.shop;

import com.megadev.afterrome.config.shop.upgrade.*;
import dev.mega.megacore.config.SubFolder;
import org.bukkit.plugin.Plugin;

public class UpgradeManager extends SubFolder {
    public UpgradeManager(Plugin plugin, String dataFolder) {
        super(plugin, dataFolder);

        addConfig(AesculapiusUpgradeShopConfig.class, new AesculapiusUpgradeShopConfig(plugin, getDataFolder() + "/aesculapius"));
        addConfig(AgronomistUpgradeShopConfig.class, new AgronomistUpgradeShopConfig(plugin, getDataFolder() + "/agronomist"));
        addConfig(ArtisanUpgradeShopConfig.class, new ArtisanUpgradeShopConfig(plugin, getDataFolder() + "/artisan"));
        addConfig(EngineerUpgradeShopConfig.class, new EngineerUpgradeShopConfig(plugin, getDataFolder() + "/engineer"));
        addConfig(ForesterUpgradeShopConfig.class, new ForesterUpgradeShopConfig(plugin, getDataFolder() + "/forester"));
        addConfig(InitiatedUpgradeShopConfig.class, new InitiatedUpgradeShopConfig(plugin, getDataFolder() + "/initiated"));
        addConfig(MafiaUpgradeShopConfig.class, new MafiaUpgradeShopConfig(plugin, getDataFolder() + "/mafia"));
        addConfig(SantaUpgradeShopConfig.class, new SantaUpgradeShopConfig(plugin, getDataFolder() + "/santa"));
        addConfig(SheriffUpgradeShopConfig.class, new SheriffUpgradeShopConfig(plugin, getDataFolder() + "/sheriff"));
        addConfig(SonOfMarsUpgradeShopConfig.class, new SonOfMarsUpgradeShopConfig(plugin, getDataFolder() + "/sonOfMars"));
    }


}
