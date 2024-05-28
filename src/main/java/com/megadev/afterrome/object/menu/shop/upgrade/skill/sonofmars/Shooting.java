package com.megadev.afterrome.object.menu.shop.upgrade.skill.sonofmars;

import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.config.shop.upgrade.SonOfMarsUpgradeShopConfig;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import lombok.Getter;

@Getter
public class Shooting implements Skill {
    private final MenuItem menuItem;

    public Shooting() {
        menuItem = ConfigManager.getInstance().getConfig(SonOfMarsUpgradeShopConfig.class).getShootingItem();
    }
}
