package com.megadev.afterrome.object.menu.shop.upgrade.skill.artisan;

import com.megadev.afterrome.config.shop.upgrade.ArtisanUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import lombok.Getter;
import org.bukkit.event.Event;

@Getter
public class Miner implements Skill {
    private final MenuItem menuItem;

    public Miner() {
        menuItem = ConfigManager.getInstance().getConfig(ArtisanUpgradeShopConfig.class).getMinerItem();
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
