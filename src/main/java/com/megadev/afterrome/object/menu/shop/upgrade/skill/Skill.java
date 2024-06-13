package com.megadev.afterrome.object.menu.shop.upgrade.skill;

import com.megadev.afterrome.object.menu.item.MenuItem;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public interface Skill {
    String getName();

    SkillType getSkillType();

    MenuItem getMenuItem();

    void incrementLevel();

    int getLevel();

    void execute(Event event);

    default @NotNull Map<String, Object> serialize() {
        return Map.of("level", getLevel());
    }
}
