package com.megadev.afterrome.object.menu.shop.upgrade.menu;

import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.config.shop.upgrade.AgronomistUpgradeShopConfig;
import com.megadev.afterrome.object.menu.AbstractUpgradeMenu;
import com.megadev.afterrome.object.profession.Profession;
import dev.mega.afterrome.user.User;

public class AgronomistMenu extends AbstractUpgradeMenu {
    public AgronomistMenu(User user, Profession profession) {
        super(user, profession);
    }

    @Override
    public String getMenuName() {
        return ConfigManager.getInstance().getConfig(AgronomistUpgradeShopConfig.class).getMenuName();
    }
}
