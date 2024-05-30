package com.megadev.afterrome.object.menu.shop.upgrade.skill.mafia;

import com.megadev.afterrome.config.shop.upgrade.MafiaUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import lombok.Getter;
import org.bukkit.event.Event;

@Getter
public class Poison implements Skill {
    private final MenuItem menuItem;

    public Poison() {
        menuItem = ConfigManager.getInstance().getConfig(MafiaUpgradeShopConfig.class).getPoisonItem();
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
