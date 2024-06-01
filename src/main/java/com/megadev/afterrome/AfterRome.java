package com.megadev.afterrome;

import co.aikar.commands.PaperCommandManager;
import com.megadev.afterrome.command.ProgCommand;
import com.megadev.afterrome.command.ShopCommand;
import com.megadev.afterrome.command.SkillsCommand;
import com.megadev.afterrome.config.user.ConfigUserManager;
import com.megadev.afterrome.listener.MenuListener;
import com.megadev.afterrome.listener.PlayerJoinListener;
import com.megadev.afterrome.config.ConfigManager;

import com.megadev.afterrome.listener.skill.BlockListener;
import com.megadev.afterrome.listener.skill.KillListener;
import com.megadev.afterrome.listener.skill.SpawnListener;
import com.megadev.afterrome.manager.MenuManager;
import com.megadev.afterrome.manager.UserManager;

import dev.mega.megacore.MegaCore;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public final class AfterRome extends MegaCore {
    @Override
    public void enable() {
        setupManagers();
        setupListeners();
        setupCommands();
    }

    @Override
    public void disable() {
        UserManager userManager = UserManager.getInstance();

        if (userManager == null) {
            UserManager.init(this);
            userManager = UserManager.getInstance();
        }

        ConfigManager configManager = ConfigManager.getInstance();
        ConfigUserManager configUserManager = configManager.getConfig(ConfigUserManager.class);

        userManager.getUsers().forEach(user -> {
            configUserManager.getAfterRomeUserConfig(user.getUuid()).saveData(user.serialize());
        });
    }

    private void setupManagers() {
        ConfigManager.init(this);
        MenuManager.init(this);
        MenuManager.getInstance().reload();
        UserManager.init(this);
    }

    private void setupCommands() {
        PaperCommandManager commandManager = new PaperCommandManager(this);
        commandManager.registerCommand(new SkillsCommand());
        commandManager.registerCommand(new ProgCommand());
        commandManager.registerCommand(new ShopCommand());
    }

    private void setupListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new PlayerJoinListener(this), this);
        pluginManager.registerEvents(new MenuListener(), this);
        pluginManager.registerEvents(new BlockListener(), this);
        pluginManager.registerEvents(new KillListener(), this);
        pluginManager.registerEvents(new SpawnListener(), this);
    }
}
