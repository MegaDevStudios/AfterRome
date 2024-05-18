package com.megadev.afterrome.object.user;

import com.megadev.afterrome.object.item.ItemBuilder;
import com.megadev.afterrome.object.profession.Profession;

import lombok.Setter;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import lombok.Getter;

import java.util.*;
import java.util.List;

@Getter
public class AfterRomeUser implements User {
    @Setter
    private Profession profession;
    private int healths;
    private final Player player;
    private final String name;
    private final UUID uuid;

    public AfterRomeUser(Player player) {
        this.player = player;
        this.name = player.getName();
        this.uuid = player.getUniqueId();
        this.healths = 3;
    }

    @Override
    public void sendMessage(String... messages) {
        for (String message : messages) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
        }
    }

    @Override
    public void sendMessage(List<String> messages) {
        for (String message : messages) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
        }
    }

    @Override
    public void sendActionBar(String message) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
    }

    @Override
    public void sendTitle(String first, String second, int input, int delay, int out) {
        player.sendTitle(
                ChatColor.translateAlternateColorCodes('&', first),
                ChatColor.translateAlternateColorCodes('&', second),
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
}
