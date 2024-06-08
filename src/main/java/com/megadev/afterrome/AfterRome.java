package com.megadev.afterrome;

import co.aikar.commands.PaperCommandManager;

import com.megadev.afterrome.command.ProgCommand;
import com.megadev.afterrome.command.ShopCommand;
import com.megadev.afterrome.command.SkillsCommand;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.manager.UserManager;

import dev.mega.megacore.MegaCore;
import dev.mega.megacore.manager.MegaManager;

public class AfterRome extends MegaCore {
    public AfterRome() {
        super(ConfigManager.class, "com.megadev.afterrome.manager", "com.megadev.afterrome.listener");
    }

    @Override
    public void enable() {

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
}
