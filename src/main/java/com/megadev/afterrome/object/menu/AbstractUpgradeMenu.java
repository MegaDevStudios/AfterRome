package com.megadev.afterrome.object.menu;

import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.profession.Profession;
import com.megadev.afterrome.object.user.User;

public abstract class AbstractUpgradeMenu extends AbstractMenu {
    Profession profession;

    public AbstractUpgradeMenu(User user, Profession profession) {
        super(user, 3);
        this.profession = profession;
    }

    @Override
    public void open() {
        super.open();
    }

    @Override
    protected void setMenuItems() {
        for (int i = 0; i < getSize(); i++)
            setItem(profession.getBackgroundItem(), i);

        int i = 1;
        for (Skill skill : profession.getSkills()) {
            setItem(skill.getMenuItem(), i);
            if (i == 7) i += 12;
            else i += 3;
        }
    }
}
