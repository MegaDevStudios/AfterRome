package dev.mega.afterrome.impl.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import dev.mega.afterrome.core.api.AfterRomeAPI;
import dev.mega.afterrome.core.user.User;
import dev.mega.afterrome.impl.menu.upgrade.UpgradeMenu;
import org.bukkit.entity.Player;

import java.util.Optional;

public class UpgradeCommand extends BaseCommand {
    @CommandAlias("skills")
    public void onCommand(Player player) {
        Optional<User> optionalUser = AfterRomeAPI.getUser(player);
        if (optionalUser.isEmpty()) return;
        User user = optionalUser.get();

        UpgradeMenu upgradeMenu = new UpgradeMenu(user, user.getProfession());
        upgradeMenu.open();
    }
}
