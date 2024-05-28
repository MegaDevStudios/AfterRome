package com.megadev.afterrome.object.menu.shop.upgrade.skill.santa;

import com.megadev.afterrome.config.shop.upgrade.MafiaUpgradeShopConfig;
import com.megadev.afterrome.config.shop.upgrade.SantaUpgradeShopConfig;
import com.megadev.afterrome.manager.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import lombok.Getter;

@Getter
public class ForTheFaith implements Skill {
    private final MenuItem menuItem;

    public ForTheFaith() {
        menuItem = ConfigManager.getInstance().getConfig(SantaUpgradeShopConfig.class).getForTheFaithItem();
    }
}
