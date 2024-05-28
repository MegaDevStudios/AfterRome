package com.megadev.afterrome.listener;

import com.megadev.afterrome.manager.UserManager;

import com.megadev.afterrome.object.menu.Menu;
import com.megadev.afterrome.object.menu.choice.ChoiceMenu;
import com.megadev.afterrome.object.user.User;

import dev.mega.megacore.MegaCore;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Optional;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onLogin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        UserManager userManager = UserManager.getInstance();

        if (!userManager.userExist(player)) {
            userManager.saveUser(player);
        }

        Optional<User> optionalUser = userManager.getUser(player);
        if (optionalUser.isEmpty()) return;
        User user = optionalUser.get();

        if (user.getProfession() == null) {
            Menu menu = new ChoiceMenu(MegaCore.getInstance(), user);
            menu.open();
        }
    }
}
