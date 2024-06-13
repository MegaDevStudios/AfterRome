package dev.mega.afterromeimpl.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import dev.mega.afterrome.api.AfterRomeAPI;
import dev.mega.afterrome.user.User;
import dev.mega.afterromeimpl.object.menu.shop.ShopMenu;
import org.bukkit.entity.Player;

import java.util.Optional;

public class ShopCommand extends BaseCommand {
    @CommandAlias("shop")
    public void shopCommand(Player player) {
        Optional<dev.mega.afterrome.user.User> optionalUser = AfterRomeAPI.getUser(player);
        if (optionalUser.isEmpty()) return;
        User user = optionalUser.get();

        ShopMenu shopMenu = new ShopMenu(user, 3);
        shopMenu.open();
    }
}
