package com.megadev.afterrome.manager;

import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.config.user.ConfigUserManager;
import com.megadev.afterrome.config.user.UserConfig;
import com.megadev.afterrome.object.user.AfterRomeUser;
import com.megadev.afterrome.object.user.User;

import dev.mega.megacore.MegaCore;
import lombok.Getter;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Getter
public class UserManager {
    ConfigManager configManager = ConfigManager.getInstance();
    ConfigUserManager configUserManager = configManager.getManager(ConfigUserManager.class);

    @Getter
    private static UserManager instance;
    private final Plugin plugin;
    private final Set<User> users = new HashSet<>();

    public static void init(Plugin plugin) {
        if (instance == null)
            instance = new UserManager(plugin);
    }

    public UserManager(Plugin plugin) {
        this.plugin = plugin;
        loadUsers();
    }

    public void loadUsers() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            UserConfig userConfig = configUserManager.getAfterRomeUserConfig(player.getUniqueId());
            if (configUserManager.userExist(player.getUniqueId())) {
                saveUser(AfterRomeUser.deserialize(userConfig.getData()));
            } else {
                saveUser(player);
            }
        }
    }

    public void saveUser(Player player) {
        if (!users.isEmpty()) return;
        saveUser(new AfterRomeUser(player));
    }

    public void saveUser(AfterRomeUser afterRomeUser) {
        MegaCore.getInstance().getLogger().info(getUsers().toString());
        users.add(afterRomeUser);
    }

    public boolean userExist(Player player) {
        return getUser(player) != null;
    }

    public User getUser(Player player) {
        return users.stream()
                .filter(user -> user.getUuid().equals(player.getUniqueId()))
                .findFirst().orElse(null);
    }

    public void printUsers() {
        System.out.println("==================================================================");
        for (User user : users)
            System.out.println(user + " " + user.getPlayer().getName());
        System.out.println("==================================================================");
    }
}
