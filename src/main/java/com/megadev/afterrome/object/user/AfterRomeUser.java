package com.megadev.afterrome.object.user;

import com.google.common.collect.Maps;
import com.megadev.afterrome.config.MainConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.item.ItemBuilder;
import com.megadev.afterrome.object.profession.Profession;

import dev.mega.megacore.util.Color;
import lombok.Setter;

import net.kyori.adventure.text.Component;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.entity.Player;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.List;

@Getter
@SerializableAs("users")
public class AfterRomeUser implements User, PointsHolder {
    private static final MainConfig mainConfig = ConfigManager.getInstance().getConfig(MainConfig.class);
    private static final int MAX_UNIT_PER_POINT = mainConfig.getMaxUnitsPerPoint();

    @Setter
    private Profession profession;
    private int healths;
    private final UUID uuid;
    private double points;

    public AfterRomeUser(Player player) {
        this.uuid = player.getUniqueId();
        this.healths = 3;
    }

    public AfterRomeUser(UUID uuid, Profession profession, int healths, double points) {
        this.uuid = uuid;
        this.profession = profession;
        this.healths = healths;
        this.points = points;
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(uuid);
    }

    @Override
    public void sendMessage(String... messages) {
        sendMessage(List.of(messages));
    }

    @Override
    public void sendMessage(List<String> messages) {
        for (String message : messages) {
            getPlayer().sendMessage(Color.getTranslated(message));
        }
    }

    @Override
    public void sendActionBar(String message) {
        getPlayer().sendActionBar(Component.text(Color.getTranslated(message)));
    }

    @Override
    public void sendTitle(String first, String second, int input, int delay, int out) {
        getPlayer().sendTitle(
                Color.getTranslated(first),
                Color.getTranslated(second),
                input, delay, out
        );

        // getPlayer().showTitle(Title.title(Component.text(first), Component.text(second)));
        // TODO: change deprecated method
    }

    @Override
    public void teleport(Location location) {
        getPlayer().teleport(location);
    }

    @Override
    public void setItem(int slot, ItemBuilder builder) {
        getPlayer().getInventory().setItem(slot, builder.toItemStack());
    }

    public void subtractHealth() {
        if (healths > 0)
            --healths;
    }

    @Override
    public double getPoints() {
        return points;
    }

    @Override
    public void addPoints(double amount) {
        points += (amount / MAX_UNIT_PER_POINT);
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        Map<String, Object> data = Maps.newConcurrentMap();
        data.put("uuid", this.uuid);
        data.put("profession", this.profession);
        data.put("healths", this.healths);
        data.put("points", this.points);
        return data;
    }

    public static AfterRomeUser deserialize(Map<String, Object> args) {
        UUID uuid = (UUID) args.get("uuid");
        Profession profession = (Profession) args.get("profession");
        int healths = (int) args.get("healths");
        double points = (double) args.get("points");

        return new AfterRomeUser(uuid, profession, healths, points);
    }
}
