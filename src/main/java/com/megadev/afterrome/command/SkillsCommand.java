package com.megadev.afterrome.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import com.megadev.afterrome.manager.UserManager;
import com.megadev.afterrome.object.menu.Menu;
import com.megadev.afterrome.object.user.User;
import org.bukkit.entity.Player;

import java.util.Optional;

public class SkillsCommand extends BaseCommand {
    @CommandAlias("skills")
    public void onCommand(Player sender) {
        Optional<User> optionalUser = UserManager.getInstance().getUser(sender);

        if (optionalUser.isEmpty()) return;

        Menu upgradeMenu = optionalUser.get().getProfession().getUpgradeMenu();

        upgradeMenu.open();
    }
}
