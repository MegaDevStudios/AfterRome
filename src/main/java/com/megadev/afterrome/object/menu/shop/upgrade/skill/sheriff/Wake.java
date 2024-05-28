package com.megadev.afterrome.object.menu.shop.upgrade.skill.sheriff;

import com.megadev.afterrome.config.shop.upgrade.SheriffUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import lombok.Getter;

public class Wake implements Skill {
    @Getter
    private final MenuItem menuItem;

    public Wake() {
        menuItem = ConfigManager.getInstance().getConfig(SheriffUpgradeShopConfig.class).getWakeItem();
    }
}
