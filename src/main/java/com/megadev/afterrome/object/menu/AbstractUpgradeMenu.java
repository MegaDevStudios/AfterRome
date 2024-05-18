package com.megadev.afterrome.object.menu;


import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import com.megadev.afterrome.object.user.User;

public abstract class AbstractUpgradeMenu extends AbstractMenu {

    public AbstractUpgradeMenu(User user, Skill skill) {
        super(user, 3);
    }

    @Override
    public void open() {


        super.open();
    }
}
