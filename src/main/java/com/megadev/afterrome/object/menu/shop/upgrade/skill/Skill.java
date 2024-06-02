package com.megadev.afterrome.object.menu.shop.upgrade.skill;

import com.megadev.afterrome.object.menu.item.MenuItem;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public interface Skill extends ConfigurationSerializable {
    MenuItem getMenuItem();

    void incrementLevel();

    int getLevel();

    void execute(Event event);

    default @NotNull Map<String, Object> serialize() {
        return Map.of("level", getLevel());
    }
}
