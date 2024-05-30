package com.megadev.afterrome.object.menu.shop.upgrade.skill.initiated;

import com.megadev.afterrome.config.shop.upgrade.InitiatedUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import lombok.Getter;
import org.bukkit.event.Event;

@Getter
public class Datura implements Skill {
    private final MenuItem menuItem;

    public Datura() {
        menuItem = ConfigManager.getInstance().getConfig(InitiatedUpgradeShopConfig.class).getDaturaItem();
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
