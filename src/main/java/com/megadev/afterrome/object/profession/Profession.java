package com.megadev.afterrome.object.profession;

import com.megadev.afterrome.config.Configurable;
import com.megadev.afterrome.object.menu. AbstractUpgradeMenu;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.user.User;

import java.util.List;

public interface Profession {
    String getNameOfProfession();

    AbstractUpgradeMenu getUpgradeMenu(User user);

    boolean isHidden();

    List<Skill> getSkills();
}
