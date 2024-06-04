package com.megadev.afterrome;

import co.aikar.commands.PaperCommandManager;
import com.megadev.afterrome.command.ProgCommand;
import com.megadev.afterrome.command.ShopCommand;
import com.megadev.afterrome.command.SkillsCommand;
import com.megadev.afterrome.listener.MenuListener;
import com.megadev.afterrome.listener.PlayerJoinListener;
import com.megadev.afterrome.config.ConfigManager;

import com.megadev.afterrome.listener.skill.BlockListener;
import com.megadev.afterrome.listener.skill.KillListener;
import com.megadev.afterrome.listener.skill.SpawnListener;
import com.megadev.afterrome.manager.UserManager;

import dev.mega.megacore.MegaCore;
import dev.mega.megacore.manager.MegaManager;
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
        UserManager userManager = MegaManager.getManager(UserManager.class);
        userManager.getUsers().forEach(userManager::serializeUser);
    }

    @Override
    public void registerCommands() {
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
