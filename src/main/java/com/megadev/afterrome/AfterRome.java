package com.megadev.afterrome;

import com.megadev.afterrome.config.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class AfterRome extends JavaPlugin {
    @Override
    public void onEnable() {

    }

    private void setupManagers() {
        ConfigManager.init(this);
    }

    @Override
    public void onDisable() {

    }
}
