package dev.mega.afterrome.manager;

import dev.mega.afterrome.user.User;
import dev.mega.afterrome.event.UserDeserializationEvent;
import dev.mega.afterrome.event.UserSerializationEvent;
import dev.mega.megacore.MegaCore;
import dev.mega.megacore.config.serializer.JsonSerializer;
import dev.mega.megacore.manager.Manager;
import dev.mega.megacore.storage.Data;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.Objects;
import java.util.UUID;

@Getter
public class UserManager extends Manager {
    private final Data<User> users = new Data<>();
    private final String dataFolder = "xdev/data/";

    public UserManager(MegaCore megaCore) {
        super(megaCore);
    }

    @Override
    public void enable() {
        Bukkit.getOnlinePlayers().forEach(this::addPlayer);

        setRunning(true);
    }

    public void removePlayer(Player player) {
        users.remove(player.getUniqueId());
    }

    public void addPlayer(Player player) {
        UUID uuid = player.getUniqueId();
        User user = getUserOrDefault(uuid);

        if (!has(user))
            users.addValue(player.getUniqueId(), user);
    }

    public boolean has(User user) {
        return users.contains(user.getUuid());
    }

    public User getUserOrDefault(UUID uuid) {
        UserDeserializationEvent event = new UserDeserializationEvent(new File(dataFolder+uuid+".json"));
        Bukkit.getPluginManager().callEvent(event);

        User user = (User) JsonSerializer.deserialize(event.getFile(), User.class);
        return Objects.requireNonNullElseGet(user, () -> new User(uuid));
    }

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
