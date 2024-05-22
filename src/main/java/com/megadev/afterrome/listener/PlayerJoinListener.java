package com.megadev.afterrome.listener;

import com.megadev.afterrome.manager.UserManager;

import com.megadev.afterrome.object.menu.Menu;
import com.megadev.afterrome.object.menu.choice.ChoiceMenu;
import com.megadev.afterrome.object.user.User;

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

        User user;

        if (!userManager.userExist(player)) {
            userManager.saveUser(player);
            Optional<User> optionalUser = userManager.getUser(player);
            if (optionalUser.isEmpty()) return;
            user = optionalUser.get();
        } else {
            Optional<User> optionalUser = userManager.getUser(player);
            if (optionalUser.isEmpty()) return;
            user = optionalUser.get();
            user.setPlayer(player);
        }

        if (user.getProfession() == null) {
            Menu menu = new ChoiceMenu(user);
            menu.open();
        }
    }
}
