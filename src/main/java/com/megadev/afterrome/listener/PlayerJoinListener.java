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
import dev.mega.megacore.config.serializer.SerializeUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    UserManager userManager = UserManager.getInstance();
    ConfigManager configManager = ConfigManager.getInstance();
    ConfigUserManager configUserManager = configManager.getConfig(ConfigUserManager.class);
    MegaCore megaCore;

    public PlayerJoinListener(MegaCore megaCore) {
        this.megaCore = megaCore;
    }

    @EventHandler
    public void onLogin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        UserConfig userConfig = configUserManager.getAfterRomeUserConfig(player.getUniqueId());

        boolean fileExist = configUserManager.userExist(player.getUniqueId());
        if (fileExist && !userManager.userExist(player)) {
            userManager.saveUser(AfterRomeUser.deserialize(SerializeUtil.deserialize(userConfig, "")));
        } else userManager.saveUser(player);

        User user = userManager.getUser(player);
        if (user == null) return;

        if (user.getProfession() instanceof DefaultProfession) {
            Menu menu = new ChoiceMenu(user, megaCore);
            menu.open();
        }
    }
}
