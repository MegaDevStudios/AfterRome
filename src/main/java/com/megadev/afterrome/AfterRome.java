package com.megadev.afterrome;

import co.aikar.commands.PaperCommandManager;
import com.megadev.afterrome.command.ProgCommand;
import com.megadev.afterrome.command.SkillsCommand;
import com.megadev.afterrome.config.user.ConfigUserManager;
import com.megadev.afterrome.listener.MenuListener;
import com.megadev.afterrome.listener.PlayerJoinListener;
import com.megadev.afterrome.config.ConfigManager;

import com.megadev.afterrome.manager.MenuManager;
import com.megadev.afterrome.manager.UserManager;

import dev.mega.megacore.MegaCore;
import org.bukkit.Bukkit;

public final class AfterRome extends MegaCore {
    @Override
    public void enable() {
        setupManagers();
        setupListeners();
        setupCommands();

        UserManager userManager = UserManager.getInstance();
        ConfigManager configManager = ConfigManager.getInstance();
        ConfigUserManager configUserManager = configManager.getManager(ConfigUserManager.class);

        //todo: store users from config to userManager may be?
    }

    @Override
    public void disable() {
        UserManager userManager = UserManager.getInstance();
        ConfigManager configManager = ConfigManager.getInstance();
        ConfigUserManager configUserManager = configManager.getManager(ConfigUserManager.class);

        userManager.getUsers().forEach(user -> {
            configUserManager.getAfterRomeUserConfig(user.getUuid()).saveData(user.serialize());
        });
    }

    private void setupManagers() {
        ConfigManager.init(this);

        MenuManager.init(this);
        UserManager.init(this);
    }

    private void setupCommands() {
        PaperCommandManager commandManager = new PaperCommandManager(this);
        commandManager.registerCommand(new SkillsCommand());
        commandManager.registerCommand(new ProgCommand());
    }

    private void setupListeners() {
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);
    }
}
