package com.megadev.afterrome.config.manager.shop;

import com.megadev.afterrome.config.shop.sale.AgronomistSaleConfig;
import com.megadev.afterrome.config.shop.sale.NPCConfig;
import dev.mega.megacore.config.SubFolder;
import org.bukkit.plugin.Plugin;

public class SaleManager extends SubFolder {
    public SaleManager(Plugin plugin, String dataFolder) {
        super(plugin, dataFolder);

        addConfig(NPCConfig.class, new NPCConfig(plugin, getDataFolder(), "npc"));
        addConfig(AgronomistSaleConfig.class, new AgronomistSaleConfig(plugin, getDataFolder(), "agronomist"));
    }
}
