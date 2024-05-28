package com.megadev.afterrome.object.menu.shop.upgrade.skill.sonofmars;

import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.config.shop.upgrade.SheriffUpgradeShopConfig;
import com.megadev.afterrome.config.shop.upgrade.SonOfMarsUpgradeShopConfig;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import dev.mega.megacore.config.Configurator;
import lombok.Getter;

@Getter
public class IronInside implements Skill {
    private final MenuItem menuItem;

    public IronInside() {
        menuItem = ConfigManager.getInstance().getConfig(SonOfMarsUpgradeShopConfig.class).getIronInsideItem();
    }
}
