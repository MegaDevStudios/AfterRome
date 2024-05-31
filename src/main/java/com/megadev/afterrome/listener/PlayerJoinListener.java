package com.megadev.afterrome.listener;

import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.config.user.ConfigUserManager;
import com.megadev.afterrome.config.user.UserConfig;
import com.megadev.afterrome.manager.UserManager;

import com.megadev.afterrome.object.menu.Menu;
import com.megadev.afterrome.object.menu.choice.ChoiceMenu;
import com.megadev.afterrome.object.profession.DefaultProfession;
import com.megadev.afterrome.object.user.AfterRomeUser;
import com.megadev.afterrome.object.user.User;

import dev.mega.megacore.MegaCore;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Optional;

public class PlayerJoinListener implements Listener {
    UserManager userManager = UserManager.getInstance();
    ConfigManager configManager = ConfigManager.getInstance();
    ConfigUserManager configUserManager = configManager.getManager(ConfigUserManager.class);

    @EventHandler
    public void onLogin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        UserConfig userConfig = configUserManager.getAfterRomeUserConfig(player.getUniqueId());

        boolean fileExist = configUserManager.userExist(player.getUniqueId());
        if (fileExist) {
            userManager.saveUser(AfterRomeUser.deserialize(userConfig.getData()));
        } else {
            userManager.saveUser(player);
        }

        userConfig.saveData(userManager.getUser(player).serialize());

        User user = userManager.getUser(player);
        if (user == null) return;

        if (user.getProfession() instanceof DefaultProfession) {
            Menu menu = new ChoiceMenu(user);
            menu.open();
        }
    }
}
