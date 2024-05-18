package com.megadev.afterrome.object.menu.shop.upgrade.menu;

import com.megadev.afterrome.object.menu.AbstractUpgradeMenu;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.user.User;

import java.util.List;

public class AgronomistMenu extends AbstractUpgradeMenu {
    public AgronomistMenu(User user, List<Skill> skills) {
        super(user, skills);
    }

    @Override
    protected void setMenuItems() {

    }

    @Override
    public String getMenuName() {
        return "";
    }
}
