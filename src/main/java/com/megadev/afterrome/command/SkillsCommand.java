package com.megadev.afterrome.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;

import com.megadev.afterrome.manager.UserManager;
import com.megadev.afterrome.object.menu.AbstractUpgradeMenu;
import com.megadev.afterrome.object.user.User;

import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public class SkillsCommand extends BaseCommand {
    @CommandAlias("skills")
    public void onCommand(Player player) {
        User user = UserManager.getInstance().getUser(player);

        if (user == null) return;

        AbstractUpgradeMenu upgradeMenu = user.getProfession().getUpgradeMenu(user);
        upgradeMenu.open();
    }
}
