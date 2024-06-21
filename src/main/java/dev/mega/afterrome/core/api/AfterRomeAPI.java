package dev.mega.afterrome.core.api;

import dev.mega.afterrome.core.AfterRome;
import dev.mega.afterrome.core.user.Profession;
import dev.mega.afterrome.core.user.User;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public class AfterRomeAPI {
    private static APIHandler api;

    public static boolean isImplemented() {
        return AfterRomeAPI.api != null;
    }

    public static boolean isDisabled() {
        return api.isDisabled();
    }

    public static AfterRome getAfterRomeImpl() {
        return api.getAfterRomeImpl();
    }

    public static void setAfterRomeImpl(final AfterRome afterRomeImpl) {
        api.setAfterRomeImpl(afterRomeImpl);
    }

    public static Collection<User> getUsers() {
        return api.getUsers();
    }

    public static Optional<User> getUser(Player player) {
        return api.getUser(player);
    }

    public static User getUserOrDefault(final UUID uuid, final String dataFolder) {
        return api.getUserOrDefault(uuid, dataFolder);
    }

    public static void serialize(final Player player, final String dataFolder) {
        api.serialize(player, dataFolder);
    }

    public static void serialize(final User user, final String dataFolder) {
        api.serialize(user, dataFolder);
    }

    public static void addProfession(Profession profession) {
        api.addProfession(profession);
    }

    public static void setProfession(final User user, final String name) {
        api.setProfession(user, name);
    }

    public static void setProfession(final User user, final Profession profession) {
        api.setProfession(user, profession);
    }

    public static void setApi(final APIHandler api) {
        AfterRomeAPI.api = api;
    }
}
