package dev.mega.afterrome;

import dev.mega.afterrome.event.UserSetProfessionEvent;
import dev.mega.afterrome.manager.UserManager;
import dev.mega.afterrome.profession.ProfessionType;
import dev.mega.afterrome.user.User;
import dev.mega.megacore.manager.MegaManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Optional;
import java.util.Set;

public class API {
    public static boolean isRunning() {
        return MegaManager.getInstance() != null && MegaManager.getInstance().isRunning();
    }

    public static Set<User> getUsers() {
        if (!isRunning()) return Set.of();
        return (Set<User>) MegaManager.getManager(UserManager.class).getUsers().getData().values();
    }

    public static Optional<User> getUser(Player player) {
        if (!isRunning()) return Optional.empty();
        return getUsers().stream()
                .filter(user -> user.getUuid().equals(player.getUniqueId()))
                .findAny();
    }

    public static void setProfession(User user, ProfessionType type) {
        if (!isRunning()) return;

        UserSetProfessionEvent event = new UserSetProfessionEvent(user, type);
        Bukkit.getPluginManager().callEvent(event);

        if (event.isCancelled()) return;

        user.setType(event.getType());
    }
}
