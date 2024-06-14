package dev.mega.afterromeimpl.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import dev.mega.afterrome.api.AfterRomeAPI;
import dev.mega.afterrome.user.User;
import dev.mega.afterromeimpl.object.menu.upgrade.AbstractUpgradeMenu;
import dev.mega.afterromeimpl.object.menu.upgrade.UpgradeMenu;
import org.bukkit.entity.Player;

import java.util.Optional;

public class UpgradeCommand extends BaseCommand {
    @CommandAlias("skills")
    public void onCommand(Player player) {
        Optional<User> optionalUser = AfterRomeAPI.getUser(player);
        if (optionalUser.isEmpty()) return;
        User user = optionalUser.get();

        AbstractUpgradeMenu upgradeMenu = new UpgradeMenu(user, user.getProfession(), ""); //TODO искать название меню
        upgradeMenu.open();
    }
}
