package com.megadev.afterrome.manager;

import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.config.user.ConfigUserManager;
import com.megadev.afterrome.config.user.UserConfig;
import com.megadev.afterrome.object.user.AfterRomeUser;
import com.megadev.afterrome.object.user.User;

import dev.mega.megacore.MegaCore;
import dev.mega.megacore.config.serializer.SerializeUtil;
import dev.mega.megacore.manager.Manager;
import lombok.Getter;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

@Getter
public class UserManager extends Manager {
    private final Set<User> users = new HashSet<>();

    public UserManager(MegaCore megaCore) {
        super(megaCore);
    }

    public void loadUsers() {
        ConfigManager configManager = ConfigManager.getInstance();
        ConfigUserManager configUserManager = configManager.getConfig(ConfigUserManager.class);

        for (Player player : Bukkit.getOnlinePlayers()) {
            UserConfig userConfig = configUserManager.getAfterRomeUserConfig(player.getUniqueId());
            if (configUserManager.userExist(player.getUniqueId())) {
                saveUser(AfterRomeUser.deserialize(SerializeUtil.deserialize(userConfig, "")));
            } else {
                saveUser(player);
            }
        }
    }

    public void saveUser(Player player) {
        saveUser(new AfterRomeUser(player));
    }

    public void saveUser(AfterRomeUser afterRomeUser) {
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

    @Override
    public void enable() {
        loadUsers();
        setRunning(true);
    }

    @Override
    public void disable() {
        setRunning(false);
    }
}
