package dev.mega.afterrome.api;

import dev.mega.afterrome.user.Profession;
import dev.mega.afterrome.user.User;
import org.bukkit.entity.Player;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface APIHandler {
    boolean isDisabled();

    Set<User> getUsers();

    Optional<User> getUser(Player player);

    User getUserOrDefault(UUID uuid, String dataFolder);

    void serialize(Player player, String dataFolder);

    void serialize(User user, String dataFolder);

    void setProfession(User user, Profession.Type type);

    boolean hasPlayedBefore(Player player);
}
