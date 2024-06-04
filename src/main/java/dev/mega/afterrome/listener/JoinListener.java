package dev.mega.afterrome.listener;

import dev.mega.afterrome.manager.UserManager;
import dev.mega.megacore.MegaCore;
import dev.mega.megacore.manager.MegaManager;
import dev.mega.megacore.util.MegaCoreUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinListener implements Listener {
    private final UserManager userManager;

    public JoinListener(MegaCore megaCore) {
        this.userManager = MegaManager.getManager(UserManager.class);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        userManager.addPlayer(event.getPlayer());
        MegaCoreUtil.getLogger().info(userManager.getUsers().getData().values().toString());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        userManager.removePlayer(event.getPlayer());
        MegaCoreUtil.getLogger().info(userManager.getUsers().getData().values().toString());
    }
}
