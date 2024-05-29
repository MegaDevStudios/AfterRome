package com.megadev.afterrome.manager;

import com.megadev.afterrome.object.user.AfterRomeUser;
import com.megadev.afterrome.object.user.User;

import lombok.Getter;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Getter
public class UserManager {
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
        for (Player player : Bukkit.getOnlinePlayers())
            saveUser(player);
    }

    public void saveUser(Player player) {
        users.add(new AfterRomeUser(player));
    }

    public void saveUser(AfterRomeUser afterRomeUser) {
        users.add(afterRomeUser);
    }

    public boolean userExist(Player player) {
        return getUser(player).isPresent();
    }

    public User getUserNonNull(Player player) {
        Optional<User> optionalUser = getUser(player);
        return optionalUser.orElseGet(() -> new AfterRomeUser(player));
    }

    public Optional<User> getUser(Player player) {
        return users.stream()
                .filter(user -> user.getUuid().equals(player.getUniqueId()))
                .findFirst();
    }

    public void printUsers() {
        System.out.println("==================================================================");
        for (User user : users)
            System.out.println(user + " " + user);
        System.out.println("==================================================================");
    }
}
