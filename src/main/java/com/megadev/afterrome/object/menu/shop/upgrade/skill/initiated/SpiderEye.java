package com.megadev.afterrome.object.menu.shop.upgrade.skill.initiated;

import com.megadev.afterrome.config.shop.upgrade.InitiatedUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import lombok.Getter;

@Getter
public class SpiderEye implements Skill {
    private final MenuItem menuItem;

    public SpiderEye() {
        menuItem = ConfigManager.getInstance().getConfig(InitiatedUpgradeShopConfig.class).getSpiderEyeItem();
    }
}
