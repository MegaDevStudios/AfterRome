package com.megadev.afterrome.object.menu.shop.upgrade.skill;

import com.megadev.afterrome.object.menu.item.MenuItem;
import org.bukkit.event.Event;

public interface Skill {
    MenuItem getMenuItem();

    void execute(Event event);
}
