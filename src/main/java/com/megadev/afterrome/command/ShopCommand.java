package com.megadev.afterrome.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import com.megadev.afterrome.manager.UserManager;
import com.megadev.afterrome.object.menu.shop.ShopMenu;
import com.megadev.afterrome.object.profession.Profession;
import com.megadev.afterrome.object.user.User;
import dev.mega.megacore.manager.MegaManager;
import org.bukkit.entity.Player;

public class ShopCommand extends BaseCommand {
    @CommandAlias("shop")
    public boolean shopCommand(Player player) {
        User user = MegaManager.getManager(UserManager.class).getUser(player);

//        Profession profession = user.getProfession();

        ShopMenu shopMenu = new ShopMenu(user, 3);
        shopMenu.open();

        return true;
    }
}
