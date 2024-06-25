package dev.mega.afterrome.core.manager;

import dev.mega.afterrome.core.api.AfterRomeAPI;
import dev.mega.afterrome.core.event.UserSerializationEvent;
import dev.mega.afterrome.core.user.User;
import dev.mega.megacore.MegaCore;
import dev.mega.megacore.config.serializer.JsonSerializer;
import dev.mega.megacore.manager.Manager;
import dev.mega.megacore.manager.priority.ManagerPriority;
import dev.mega.megacore.manager.priority.Priority;
import dev.mega.megacore.storage.Data;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.*;

/**
 * Class represents the manager to manage users.
 */
@Getter
@ManagerPriority(priority = Priority.LOW)
public class UserManager extends Manager {
    private final Data<User> users = new Data<>();
    private final String dataFolder = megaCore.getDataFolder().getAbsolutePath() + File.separator + "xdev/data/";

    public UserManager(MegaCore megaCore) {
        super(megaCore);
    }

    /**
     * Calls when manager enables.
     */
    @Override
    public void enable() {
        setRunning(true);
    }

    public void loadUsers() {
        Bukkit.getOnlinePlayers().forEach(this::addPlayer);
    }

    /**
     * Checks if player is already exists.
     * @param player
     * @return
     */
    public boolean hasPlayedBefore(Player player) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(dataFolder + player.getUniqueId() + ".json"));
            return br.readLine() != null;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Removes the player from map.
     * @param player
     */
    public void removePlayer(Player player) {
        users.remove(player.getUniqueId());

        User user = AfterRomeAPI.getUserOrDefault(player.getUniqueId(), dataFolder);
        AfterRomeAPI.serialize(user, dataFolder);
    }

    /**
     * Adds the User to map.
     * @param user
     */
    public void addUser(User user) {
        users.addValue(user.getUuid(), user);
    }

    /**
     * Adds the Player to map.
     * @param player
     */
    public void addPlayer(Player player) {
        User user = AfterRomeAPI.getUserOrDefault(player.getUniqueId(), dataFolder);

        if (has(user)) return;
        users.addValue(player.getUniqueId(), user);
    }

    /**
     * Checks if User is already registered.
     * @param user
     * @return
     */
    public boolean has(User user) {
        return users.contains(user.getUuid());
    }

    /**
     * Calls when plugin disables.
     */
    @Override
    public void disable() {
        users.getData().values().forEach(user -> {
            UserSerializationEvent event = new UserSerializationEvent(user,
                    new File(dataFolder+user.getUuid()+".json"));
            Bukkit.getPluginManager().callEvent(event);

            if (event.isCancelled()) return;

            JsonSerializer.serialize(event.getFile(), event.getUser());
        });

        setRunning(false);
    }
}
