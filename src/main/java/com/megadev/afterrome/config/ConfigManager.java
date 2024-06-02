package com.megadev.afterrome.config;

import com.megadev.afterrome.config.manager.ProfessionsManager;
import com.megadev.afterrome.config.manager.shop.ShopManager;
import com.megadev.afterrome.config.user.ConfigUserManager;

import dev.mega.megacore.MegaCore;
import dev.mega.megacore.config.SubFolder;

public class ConfigManager extends SubFolder {
    public ConfigManager(MegaCore megaCore) {
        super(megaCore, ".");

        addConfig(ProfessionsManager.class, new ProfessionsManager(megaCore, "professions"));
        addConfig(ShopManager.class, new ShopManager(megaCore, "shop"));
        addConfig(MainConfig.class, new MainConfig(megaCore, "config"));
        addConfig(ConfigUserManager.class, new ConfigUserManager(megaCore, "data"));
    }
}
