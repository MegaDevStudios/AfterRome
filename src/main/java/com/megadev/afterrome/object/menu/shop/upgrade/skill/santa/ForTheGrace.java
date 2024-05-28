package com.megadev.afterrome.object.menu.shop.upgrade.skill.santa;

import com.megadev.afterrome.config.shop.upgrade.SantaUpgradeShopConfig;
import com.megadev.afterrome.manager.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import lombok.Getter;

@Getter
public class ForTheGrace implements Skill {
    private final MenuItem menuItem;

    public ForTheGrace() {
        menuItem = ConfigManager.getInstance().getConfig(SantaUpgradeShopConfig.class).getForTheGraceItem();
    }
}
