package dev.mega.afterrome.api;

import dev.mega.afterrome.user.Profession;
import dev.mega.afterrome.user.User;
import org.bukkit.entity.Player;

import java.util.*;

public class AfterRomeAPI {
    private static APIHandler api;

    public static boolean isDisabled() {
        return api.isDisabled();
    }

    public static Set<User> getUsers() {
        return api.getUsers();
    }

    public static Optional<User> getUser(Player player) {
        return api.getUser(player);
    }

    public static User getUserOrDefault(UUID uuid, String dataFolder) {
        return api.getUserOrDefault(uuid, dataFolder);
    }

    public static void serialize(Player player, String dataFolder) {
        api.serialize(player, dataFolder);
    }

    public static void serialize(User user, String dataFolder) {
        api.serialize(user, dataFolder);
    }

    public static void setProfession(User user, Profession.Type type) {
        api.setProfession(user, type);
    }
}
