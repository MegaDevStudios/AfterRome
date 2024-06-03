package com.megadev.afterrome.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;

import com.megadev.afterrome.manager.UserManager;
import com.megadev.afterrome.object.menu.AbstractUpgradeMenu;
import com.megadev.afterrome.object.user.User;

import dev.mega.megacore.manager.MegaManager;
import org.bukkit.entity.Player;

public class SkillsCommand extends BaseCommand {
    @CommandAlias("skills")
    public void onCommand(Player player) {
        User user = MegaManager.getManager(UserManager.class).getUser(player);

        if (user == null) return;

        AbstractUpgradeMenu upgradeMenu = user.getProfession().getUpgradeMenu(user);
        upgradeMenu.open();
    }
}
