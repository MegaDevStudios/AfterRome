package dev.mega.afterrome.impl.api;

import dev.mega.afterrome.core.AfterRome;
import dev.mega.afterrome.core.api.APIHandler;
import dev.mega.afterrome.core.api.AfterRomeAPI;
import dev.mega.afterrome.core.event.PreDefaultUserCreateEvent;
import dev.mega.afterrome.core.event.PreUserDeserializationEvent;
import dev.mega.afterrome.core.event.UserSerializationEvent;
import dev.mega.afterrome.core.event.UserSetProfessionEvent;
import dev.mega.afterrome.core.manager.ProfessionManager;
import dev.mega.afterrome.core.manager.UserManager;
import dev.mega.afterrome.core.parser.Parser;
import dev.mega.afterrome.core.user.Profession;
import dev.mega.afterrome.core.user.User;
import dev.mega.megacore.config.serializer.JsonSerializer;
import dev.mega.megacore.manager.MegaManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.*;

public class ArAPIHandler implements APIHandler {
    private final AfterRome afterRome;

    public ArAPIHandler(AfterRome afterRome) {
        this.afterRome = afterRome;
    }

    @Override
    public boolean isDisabled() {
        return MegaManager.getInstance() == null || !MegaManager.getInstance().isRunning();
    }

    @Override
    public AfterRome getAfterRomeImpl() {
        return afterRome;
    }

    @Override
    public void setAfterRomeImpl(AfterRome afterRomeImpl) {
        //todo: set implementation
    }

    @Override
    public Collection<User> getUsers() {
        if (isDisabled()) return Set.of();
        return  MegaManager.getManager(UserManager.class).getUsers().getData().values();
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

        if (user != null) return user;

        User defaultUser = User.of(uuid);

        PreDefaultUserCreateEvent preDefaultUserCreateEvent = new PreDefaultUserCreateEvent(defaultUser);
        Bukkit.getPluginManager().callEvent(preDefaultUserCreateEvent);

        return defaultUser;
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
    public void addProfession(Profession profession) {
        MegaManager.getManager(ProfessionManager.class).add(profession);
    }

    @Override
    public void setProfession(User user, String name) {
        if (isDisabled()) return;

        UserSetProfessionEvent event = new UserSetProfessionEvent(user, name);
        Bukkit.getPluginManager().callEvent(event);

        if (event.isCancelled()) return;

        Optional<Profession> optionalProfession = Parser.getInstance().getProfessions()
                .stream()
                .filter(p -> p.getName().equals(event.getName()))
                .findAny();

        if (optionalProfession.isEmpty()) return;
        Profession profession = optionalProfession.get();

        user.setProfession(profession);
    }

    @Override
    public void setProfession(User user, Profession settingProfession) {
        if (isDisabled()) return;

        String name = settingProfession.getName();

        setProfession(user, name);
    }

    @Override
    public boolean hasPlayedBefore(Player player) {
        if (isDisabled()) return false;
        return MegaManager.getManager(UserManager.class).hasPlayedBefore(player);
    }
}
