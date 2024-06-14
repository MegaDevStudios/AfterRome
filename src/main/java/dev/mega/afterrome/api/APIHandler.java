package dev.mega.afterrome.api;

import dev.mega.afterrome.AfterRome;
import dev.mega.afterrome.user.Profession;
import dev.mega.afterrome.user.User;
import org.bukkit.entity.Player;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface APIHandler {
    boolean isDisabled();

    AfterRome getAfterRomeImpl();

    void setAfterRomeImpl(AfterRome afterRomeImpl);

    Set<User> getUsers();

    Optional<User> getUser(Player player);

    User getUserOrDefault(UUID uuid, String dataFolder);

    void serialize(Player player, String dataFolder);

    void serialize(User user, String dataFolder);

    void addProfession(Profession profession);

    void setProfession(User user, String name);

    void setProfession(User user, Profession profession);

    boolean hasPlayedBefore(Player player);
}
