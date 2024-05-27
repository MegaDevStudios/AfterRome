package com.megadev.afterrome.object.menu.shop.upgrade.skill.aesculapius;

import com.megadev.afterrome.config.shop.upgrade.AesculapiusUpgradeShopConfig;
import com.megadev.afterrome.manager.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import lombok.Getter;

@Getter
public class BrutalSurgery implements Skill {
    private final MenuItem menuItem;

    public BrutalSurgery() {
        menuItem = ConfigManager.getInstance().getConfig(AesculapiusUpgradeShopConfig.class).getAlchemyItem();
    }
}
