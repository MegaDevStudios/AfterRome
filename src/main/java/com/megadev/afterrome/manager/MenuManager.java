package com.megadev.afterrome.manager;

import com.megadev.afterrome.object.user.User;

import lombok.Getter;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

public class MenuManager {
    @Getter
    private static JavaPlugin plugin;
    @Getter
    private final static HashMap<User, BukkitTask> refreshingMenus = new HashMap<>();

    public static void init(JavaPlugin plugin) {
        MenuManager.plugin = plugin;
    }

    public static boolean containsPlayer(User user) {
        return refreshingMenus.containsKey(user);
    }

    private static BukkitTask getBukkitTask(User user) {
        return refreshingMenus.get(user);
    }

    public static void cancelTask(User user) {
        getBukkitTask(user).cancel();
    }

    public static void remove(User user) {
        refreshingMenus.remove(user);
    }

    public static void put(User user, BukkitTask task) {
        refreshingMenus.put(user, task);
    }
}
