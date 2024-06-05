package dev.mega.afterrome.api;

import dev.mega.afterrome.config.Config;
import dev.mega.afterrome.config.ConfigManager;
import dev.mega.afterrome.event.PreDefaultUserCreateEvent;
import dev.mega.afterrome.event.PreUserDeserializationEvent;
import dev.mega.afterrome.event.UserSerializationEvent;
import dev.mega.afterrome.event.UserSetProfessionEvent;
import dev.mega.afterrome.manager.UserManager;
import dev.mega.afterrome.user.Profession;
import dev.mega.afterrome.user.Skill;
import dev.mega.afterrome.user.User;
import dev.mega.megacore.config.serializer.JsonSerializer;
import dev.mega.megacore.manager.MegaManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.*;

public class ArAPIHandler implements APIHandler {
    public ArAPIHandler() {}

    @Override
    public boolean isDisabled() {
        return MegaManager.getInstance() == null || !MegaManager.getInstance().isRunning();
    }

    @Override
    public Set<User> getUsers() {
        if (isDisabled()) return Set.of();
        return (Set<User>) MegaManager.getManager(UserManager.class).getUsers().getData().values();
    }

    @Override
    public Optional<User> getUser(Player player) {
        if (isDisabled()) return Optional.empty();
        return getUsers().stream()
                .filter(user -> user.getUuid().equals(player.getUniqueId()))
                .findAny();
    }

    @Override
    public User getUserOrDefault(UUID uuid, String dataFolder) {
        PreUserDeserializationEvent event = new PreUserDeserializationEvent(new File(dataFolder+uuid+".json"));
        Bukkit.getPluginManager().callEvent(event);

        User user = (User) JsonSerializer.deserialize(event.getFile(), User.class);

        return Objects.requireNonNullElseGet(user, () -> {
            List<Skill.Type> skillTypes = ConfigManager.getInstance().getConfig(Config.class).getSkillsOf(Profession.Type.DEFAULT);

            User defaultUser = User.of(uuid, skillTypes);

            PreDefaultUserCreateEvent preDefaultUserCreateEvent = new PreDefaultUserCreateEvent(defaultUser);
            Bukkit.getPluginManager().callEvent(preDefaultUserCreateEvent);

            return defaultUser;
        });
    }

    @Override
    public void serialize(Player player, String dataFolder) {
        User user = AfterRomeAPI.getUserOrDefault(player.getUniqueId(), dataFolder);
        serialize(user, dataFolder);
    }

    @Override
    public void serialize(User user, String dataFolder) {
        UserSerializationEvent event = new UserSerializationEvent(user,
                new File(dataFolder+user.getUuid()+".json"));
        Bukkit.getPluginManager().callEvent(event);

        if (event.isCancelled()) return;

        JsonSerializer.serialize(event.getFile(), event.getUser());
    }

    @Override
    public void setProfession(User user, Profession.Type type) {
        if (isDisabled()) return;

        UserSetProfessionEvent event = new UserSetProfessionEvent(user, type);
        Bukkit.getPluginManager().callEvent(event);

        if (event.isCancelled()) return;

        user.setType(event.getType());
    }

    @Override
    public boolean hasPlayedBefore(Player player) {
        if (isDisabled()) return false;
        return MegaManager.getManager(UserManager.class).hasPlayedBefore(player);
    }
}
