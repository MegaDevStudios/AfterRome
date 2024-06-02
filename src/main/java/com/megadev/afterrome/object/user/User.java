package com.megadev.afterrome.object.user;

import com.megadev.afterrome.object.item.ItemBuilder;
import com.megadev.afterrome.object.profession.Profession;

import org.bukkit.Location;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public interface User extends ConfigurationSerializable, PointsHolder {

    Player getPlayer();

    UUID getUuid();

    Profession getProfession();

    void setProfession(Profession profession);

    void sendMessage(String... messages);

    void sendMessage(List<String> messages);

    void sendActionBar(String message);

    void teleport(Location location);

    void setItem(int slot, ItemBuilder builder);

    void addItem(ItemStack itemStack, int count);

    /**
     * Отправить сообщение в экран пользователю
     * @param first - Заглавная строка
     * @param second - Нижняя строка
     * @param input - Появление текста
     * @param delay - Задержка
     * @param out - Затухание текста
     */
    void sendTitle(String first, String second, int input, int delay, int out);
}
