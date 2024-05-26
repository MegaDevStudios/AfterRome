package com.megadev.afterrome;

import co.aikar.commands.PaperCommandManager;
import com.megadev.afterrome.command.ProgCommand;
import com.megadev.afterrome.command.SkillsCommand;
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

        System.out.println("ЛАЛА");

        setupManagers();
        setupCommands();
    }

    @Override
    public void disable() {
    }

    private void setupManagers() {
        ConfigManager.init(this);

        MenuManager.init(this);
        UserManager.init(this);
    }

    private void setupCommands() {
        PaperCommandManager commandManager = new PaperCommandManager(this);
        System.out.println("ЛАЛА");
        commandManager.registerCommand(new SkillsCommand());
        commandManager.registerCommand(new ProgCommand());
    }
}
