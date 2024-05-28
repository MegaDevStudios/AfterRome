package com.megadev.afterrome.object.menu.shop.upgrade.skill.mafia;

import com.megadev.afterrome.config.shop.upgrade.MafiaUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import lombok.Getter;

@Getter
public class Wake implements Skill {
    private final MenuItem menuItem;

    public Wake() {
        menuItem = ConfigManager.getInstance().getConfig(MafiaUpgradeShopConfig.class).getWakeItem();
    }
}
