package com.megadev.afterrome.object.menu.shop.upgrade.menu;

import com.megadev.afterrome.config.shop.ShopConfig;
import com.megadev.afterrome.object.menu.AbstractUpgradeMenu;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.user.User;

import java.util.List;

public class AesculapiusMenu extends AbstractUpgradeMenu {
    public AesculapiusMenu(User user, List<Skill> skills) {
        super(user, skills);
    }

    @Override
    protected void setMenuItems() {

    }

    @Override
    public String getMenuName() {
        return (String) getConfigManager().getConfig(ShopConfig.class).getValue("asas");
    }
}
