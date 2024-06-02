package com.megadev.afterrome.config.manager.shop;

import dev.mega.megacore.config.AbstractManager;
import org.bukkit.plugin.Plugin;

public class ShopManager extends AbstractManager {
    public ShopManager(Plugin plugin, String dataFolder) {
        super(plugin, dataFolder);

        addConfig(UpgradeManager.class, new UpgradeManager(plugin, getDataFolder() + "/upgrade"));
        addConfig(SaleManager.class, new SaleManager(plugin, getDataFolder() + "/sale"));
    }
}
