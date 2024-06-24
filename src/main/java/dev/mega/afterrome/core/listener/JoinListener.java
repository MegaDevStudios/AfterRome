package dev.mega.afterrome.core.listener;

import dev.mega.afterrome.core.event.PreClassChoiceEvent;
import dev.mega.afterrome.core.event.UserJoinEvent;
import dev.mega.afterrome.core.manager.UserManager;
import dev.mega.megacore.MegaCore;
import dev.mega.megacore.manager.MegaManager;
import dev.mega.megacore.util.MegaCoreUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginManager;

public class JoinListener implements Listener {
    private final UserManager userManager;

    public JoinListener(MegaCore megaCore) {
        this.userManager = MegaManager.getManager(UserManager.class);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        PluginManager pluginManager = Bukkit.getPluginManager();

        userManager.addPlayer(event.getPlayer());

        UserJoinEvent userJoinEvent = new UserJoinEvent(userManager.getUsers().getValue(player.getUniqueId()));
        pluginManager.callEvent(userJoinEvent);

        if (!userManager.hasPlayedBefore(player)) {
            PreClassChoiceEvent preClassChoiceEvent = new PreClassChoiceEvent(userJoinEvent.getUser());
            pluginManager.callEvent(preClassChoiceEvent);
        }

        MegaCoreUtil.getLogger().info(userManager.getUsers().getData().values().toString());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        userManager.removePlayer(event.getPlayer());
        MegaCoreUtil.getLogger().info(userManager.getUsers().getData().values().toString());
    }
}
