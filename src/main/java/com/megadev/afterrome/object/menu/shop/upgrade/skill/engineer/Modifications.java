package com.megadev.afterrome.object.menu.shop.upgrade.skill.engineer;

import com.megadev.afterrome.config.shop.upgrade.EngineerUpgradeShopConfig;
import com.megadev.afterrome.manager.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import lombok.Getter;

@Getter
public class Modifications implements Skill {
    private final MenuItem menuItem;

    public Modifications() {
        menuItem = ConfigManager.getInstance().getConfig(EngineerUpgradeShopConfig.class).getModificationsItem();
    }
}
