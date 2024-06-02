package com.megadev.afterrome.object.user;

import com.google.common.collect.Maps;
import com.megadev.afterrome.config.MainConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.item.ItemBuilder;
import com.megadev.afterrome.object.profession.DefaultProfession;
import com.megadev.afterrome.object.profession.Profession;

import dev.mega.megacore.util.Color;
import lombok.Setter;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.entity.Player;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.List;

@Getter
@SerializableAs("users")
public class AfterRomeUser implements User {
    private static final MainConfig mainConfig = ConfigManager.getInstance().getConfig(MainConfig.class);
    private static final int MAX_UNIT_PER_POINT = mainConfig.getMaxUnitsPerPoint();

    @Setter
    private Profession profession;
    private int healths;
    private final UUID uuid;
    private int points;

    public AfterRomeUser(Player player) {
        this.uuid = player.getUniqueId();
        this.profession = new DefaultProfession();
        this.healths = 3;
        this.points = 0;
    }

    public AfterRomeUser(UUID uuid, Profession profession, int healths, int points) {
        this.uuid = uuid;
        this.profession = profession;
        this.healths = healths;
        this.points = points;
    }

    public AfterRomeUser(Map<String, Object> data) {
        this.uuid = UUID.fromString((String) data.get("uuid"));
        this.profession = (Profession) data.get("profession");
        this.healths = (int) data.get("healths");
        this.points = (int) data.get("points");
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(uuid);
    }

    @Override
    public void sendMessage(String... messages) {
        sendMessage(List.of(messages));

        Bukkit.getServer().getPlayer("");
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

    @Override
    public void addItem(ItemStack itemStack, int count) {
        ItemStack[] items = new ItemStack[count];
        Arrays.fill(items, itemStack);
        getPlayer().getInventory().addItem(items);
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
        points += (int) (amount / MAX_UNIT_PER_POINT);
    }

    @Override
    public boolean subtractPoints() {
        if (points < 1)
            return false;
        points--;
        return true;
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        Map<String, Object> data = Maps.newConcurrentMap();
        data.put("uuid", this.uuid.toString());
        data.put("profession", this.profession.serialize());
        data.put("healths", this.healths);
        data.put("points", this.points);
        return data;
    }

    public static AfterRomeUser deserialize(Map<String, Object> data) {
        return new AfterRomeUser(data);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        AfterRomeUser that = (AfterRomeUser) object;
        return Objects.equals(getUuid(), that.getUuid());
    }

    static {
        ConfigurationSerialization.registerClass(AfterRomeUser.class);
    }
}
