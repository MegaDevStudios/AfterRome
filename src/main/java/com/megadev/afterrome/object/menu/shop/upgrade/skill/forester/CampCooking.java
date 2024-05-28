package com.megadev.afterrome.object.menu.shop.upgrade.skill.forester;

import com.megadev.afterrome.config.shop.upgrade.ForesterUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import lombok.Getter;

@Getter
public class CampCooking implements Skill {
    private final MenuItem menuItem;

    public CampCooking() {
        menuItem = ConfigManager.getInstance().getConfig(ForesterUpgradeShopConfig.class).getCampCookingItem();
    }
}
