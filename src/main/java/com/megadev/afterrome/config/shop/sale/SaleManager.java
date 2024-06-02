package com.megadev.afterrome.config.shop.sale;

import dev.mega.megacore.config.AbstractManager;
import org.bukkit.plugin.Plugin;

public class SaleManager extends AbstractManager {
    public SaleManager(Plugin plugin, String dataFolder) {
        super(plugin, dataFolder);

        addConfig(NPCConfig.class, new NPCConfig(plugin, getDataFolder(), "npc"));
        addConfig(AgronomistSaleConfig.class, new AgronomistSaleConfig(plugin, getDataFolder(), "agronomist"));
    }
}
