package com.megadev.afterrome;

import co.aikar.commands.PaperCommandManager;
import com.megadev.afterrome.config.ConfigManager;
import dev.mega.megacore.MegaCore;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class AfterRome extends MegaCore {
    public AfterRome() {
        super(ConfigManager.class, "com.megadev.afterrome.manager", "");
    }

    @Override
    public void enable() {
        setupListeners();
    }

    @Override
    public void disable() {
    }

    @Override
    public void registerCommands() {
        PaperCommandManager commandManager = new PaperCommandManager(this);
    }

    private void setupListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();

    }
}
