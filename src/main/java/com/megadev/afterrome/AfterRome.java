package com.megadev.afterrome;

import co.aikar.commands.PaperCommandManager;
import com.megadev.afterrome.config.ConfigManager;
import dev.mega.megacore.MegaCore;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import java.util.ArrayList;
import java.util.List;

public class AfterRome extends MegaCore {
    public AfterRome() {
        super(ConfigManager.class, List.of("com.megadev.afterrome.manager"), new ArrayList<>());
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
