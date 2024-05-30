package com.megadev.afterrome.object.menu.shop.upgrade.skill.engineer;

import com.megadev.afterrome.config.shop.upgrade.EngineerUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import lombok.Getter;
import org.bukkit.event.Event;

@Getter
public class Drawings implements Skill {
    private final MenuItem menuItem;

    public Drawings() {
        menuItem = ConfigManager.getInstance().getConfig(EngineerUpgradeShopConfig.class).getDrawingsItem();
    }

    @Override
    public void incrementLevel() {

    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public void execute(Event event) {

    }
}
