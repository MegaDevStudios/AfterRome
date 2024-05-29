package com.megadev.afterrome.object.menu.shop.upgrade.menu;

import com.megadev.afterrome.object.menu.AbstractUpgradeMenu;
import com.megadev.afterrome.object.menu.Menu;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.profession.Profession;
import com.megadev.afterrome.object.user.User;

import java.util.ArrayList;
import java.util.List;

public class EngineerMenu extends AbstractUpgradeMenu {
    public EngineerMenu(User user, Profession profession) {
        super(user, profession);
    }

    @Override
    protected void setMenuItems() {

    }

    @Override
    public String getMenuName() {
        return "";
    }
}
