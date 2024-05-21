package com.megadev.afterrome;

import com.megadev.afterrome.listener.MenuListener;
import com.megadev.afterrome.listener.PlayerJoinListener;
import com.megadev.afterrome.manager.ConfigManager;

import com.megadev.afterrome.manager.MenuManager;
import com.megadev.afterrome.manager.UserManager;

import dev.mega.megacore.MegaCore;
import org.bukkit.Bukkit;

public final class AfterRome extends MegaCore {

    @Override
    public void enable() {
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);

        setupManagers();
    }

    @Override
    public void disable() {

    }

    private void setupManagers() {
        ConfigManager.init(this);
        MenuManager.init(this);
        UserManager.init(this);
    }
}
