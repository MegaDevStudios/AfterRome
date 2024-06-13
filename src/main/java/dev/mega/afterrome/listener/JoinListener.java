package dev.mega.afterrome.listener;

import dev.mega.afterrome.event.PreClassChoiceEvent;
import dev.mega.afterrome.event.UserJoinEvent;
import dev.mega.afterrome.manager.UserManager;
import dev.mega.megacore.MegaCore;
import dev.mega.megacore.manager.MegaManager;
import dev.mega.megacore.util.MegaCoreUtil;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class JoinListener implements Listener {
    private final UserManager userManager;

    public JoinListener(MegaCore megaCore) {
        this.userManager = MegaManager.getManager(UserManager.class);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        userManager.addPlayer(event.getPlayer());

        UserJoinEvent userJoinEvent = new UserJoinEvent(userManager.getUsers().getValue(player.getUniqueId()));
        Bukkit.getPluginManager().callEvent(userJoinEvent);

        if (!userManager.hasPlayedBefore(player)) {
            Bukkit.getPluginManager().callEvent(new PreClassChoiceEvent(userJoinEvent.getUser()));
        }

        MegaCoreUtil.getLogger().info(userManager.getUsers().getData().values().toString());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        userManager.removePlayer(event.getPlayer());
        MegaCoreUtil.getLogger().info(userManager.getUsers().getData().values().toString());
    }
}
