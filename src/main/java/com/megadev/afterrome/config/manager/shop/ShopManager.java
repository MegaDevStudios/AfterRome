package com.megadev.afterrome.config.manager.shop;

import dev.mega.megacore.config.SubFolder;
import org.bukkit.plugin.Plugin;

public class ShopManager extends SubFolder {
    public ShopManager(Plugin plugin, String dataFolder) {
        super(plugin, dataFolder);

        addConfig(UpgradeManager.class, new UpgradeManager(plugin, getDataFolder() + "/upgrade"));
        addConfig(SaleManager.class, new SaleManager(plugin, getDataFolder() + "/sale"));
    }
}
