package com.megadev.afterrome.object.menu.shop.upgrade.skill.aesculapius;

import com.megadev.afterrome.config.shop.upgrade.AesculapiusUpgradeShopConfig;
import com.megadev.afterrome.manager.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import lombok.Getter;

@Getter
public class DoctorMask implements Skill {

    private final MenuItem menuItem;

    public DoctorMask() {
        menuItem = ConfigManager.getInstance().getConfig(AesculapiusUpgradeShopConfig.class).getAlchemyItem();
    }
}
