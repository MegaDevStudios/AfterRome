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
import dev.mega.megacore.manager.MegaManager;
import dev.mega.megacore.util.MegaCoreUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    UserManager userManager = MegaManager.getManager(UserManager.class);
    MegaCore megaCore;

    public PlayerJoinListener(MegaCore megaCore) {
        this.megaCore = megaCore;
    }

    @EventHandler
    public void onLogin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!userManager.isRegistered(player.getUniqueId())) {
            userManager.saveUser(player);
            MegaCoreUtil.getLogger().info("File exist for " + player.getUniqueId());
            userManager.serializeUser(userManager.getUser(player));
        } else {
            MegaCoreUtil.getLogger().info("File does not exist for " + player.getUniqueId() + " loading from player.");
            userManager.saveUser(userManager.deserialize(player.getUniqueId()));
        }
    }
}
