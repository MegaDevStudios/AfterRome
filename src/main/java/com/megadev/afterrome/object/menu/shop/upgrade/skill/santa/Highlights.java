package com.megadev.afterrome.object.menu.shop.upgrade.skill.santa;

import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.config.shop.upgrade.SantaUpgradeShopConfig;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import lombok.Getter;

@Getter
public class Highlights implements Skill {
    private final MenuItem menuItem;

    public Highlights() {
        menuItem = ConfigManager.getInstance().getConfig(SantaUpgradeShopConfig.class).getHighlightsItem();
    }
}
