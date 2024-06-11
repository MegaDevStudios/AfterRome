package com.megadev.afterrome.listener;

import com.megadev.afterrome.manager.UserManager;

import dev.mega.megacore.MegaCore;
import dev.mega.megacore.listener.MegaListener;
import dev.mega.megacore.manager.MegaManager;
import dev.mega.megacore.util.MegaCoreUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    private final UserManager userManager = MegaManager.getManager(UserManager.class);

//    public PlayerJoinListener(MegaCore megaCore) {
//        super(megaCore);
//    }

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
