package dev.mega.afterromeimpl.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import com.megadev.afterrome.object.menu.AbstractUpgradeMenu;
import com.megadev.afterrome.object.menu.shop.upgrade.menu.AgronomistMenu;
import com.megadev.afterrome.object.profession.Agronomist;
import dev.mega.afterrome.api.AfterRomeAPI;
import dev.mega.afterrome.user.User;
import org.bukkit.entity.Player;

import java.util.Optional;

public class UpgradeCommand extends BaseCommand {
    @CommandAlias("skills")
    public void onCommand(Player player) {
        Optional<User> optionalUser = AfterRomeAPI.getUser(player);
        if (optionalUser.isEmpty()) return;
        User user = optionalUser.get();

        AbstractUpgradeMenu upgradeMenu = new AgronomistMenu(user, new Agronomist()); //todo получать меню прокачки из игрока
        upgradeMenu.open();
    }
}
