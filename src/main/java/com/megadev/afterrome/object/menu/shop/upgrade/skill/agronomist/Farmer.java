package com.megadev.afterrome.object.menu.shop.upgrade.skill.agronomist;

import com.megadev.afterrome.config.shop.upgrade.AgronomistUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import lombok.Getter;

@Getter
public class Farmer implements Skill {
    private final MenuItem menuItem;

    public Farmer() {
        menuItem = ConfigManager.getInstance().getConfig(AgronomistUpgradeShopConfig.class).getFarmerItem();
    }
}
