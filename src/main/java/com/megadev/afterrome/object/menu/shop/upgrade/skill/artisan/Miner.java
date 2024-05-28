package com.megadev.afterrome.object.menu.shop.upgrade.skill.artisan;

import com.megadev.afterrome.config.shop.upgrade.ArtisanUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import lombok.Getter;

@Getter
public class Miner implements Skill {
    private final MenuItem menuItem;

    public Miner() {
        menuItem = ConfigManager.getInstance().getConfig(ArtisanUpgradeShopConfig.class).getMinerItem();
    }
}
