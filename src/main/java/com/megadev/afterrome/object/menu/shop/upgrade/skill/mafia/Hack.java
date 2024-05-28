package com.megadev.afterrome.object.menu.shop.upgrade.skill.mafia;

import com.megadev.afterrome.config.shop.upgrade.MafiaUpgradeShopConfig;
import com.megadev.afterrome.manager.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import lombok.Getter;

@Getter
public class Hack implements Skill {
    private final MenuItem menuItem;

    public Hack() {
        menuItem = ConfigManager.getInstance().getConfig(MafiaUpgradeShopConfig.class).getHackItem();
    }
}
