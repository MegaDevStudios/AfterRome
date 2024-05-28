package com.megadev.afterrome.object.user;

import com.megadev.afterrome.config.MainConfig;
import com.megadev.afterrome.manager.ConfigManager;
import com.megadev.afterrome.object.item.ItemBuilder;
import com.megadev.afterrome.object.profession.Profession;

import com.megadev.afterrome.util.Color;
import lombok.Setter;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import lombok.Getter;

import java.util.*;
import java.util.List;

@Getter
public class AfterRomeUser implements User, PointsHolder {
    private static final MainConfig mainConfig = ConfigManager.getInstance().getConfig(MainConfig.class);
    private static final int MAX_UNIT_PER_POINT = mainConfig.getMaxUnitsPerPoint();

    @Setter
    private Profession profession;
    @Setter
    private Player player;
    private int healths;
    private final String name;
    private final UUID uuid;
    private double points;

    public AfterRomeUser(Player player) {
        this.player = player;
        this.name = player.getName();
        this.uuid = player.getUniqueId();
        this.healths = 3;
    }

    @Override
    public void sendMessage(String... messages) {
        for (String message : messages) {
            player.sendMessage(Color.colorize(message));
        }
    }

    @Override
    public void sendMessage(List<String> messages) {
        for (String message : messages) {
            player.sendMessage(Color.colorize(message));
        }
    }

    @Override
    public void sendActionBar(String message) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
    }

    @Override
    public void sendTitle(String first, String second, int input, int delay, int out) {
        player.sendTitle(
                Color.colorize(first),
                Color.colorize(second),
                input, delay, out
        );
    }

    @Override
    public void teleport(Location location) {
        player.teleport(location);
    }

    @Override
    public void setItem(int slot, ItemBuilder builder) {
        player.getInventory().setItem(slot, builder.toItemStack());
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
}
