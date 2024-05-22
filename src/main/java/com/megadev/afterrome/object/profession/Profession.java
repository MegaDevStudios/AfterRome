package com.megadev.afterrome.object.profession;

import com.megadev.afterrome.object.menu.Menu;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import java.util.List;

public interface Profession {
    String getNameOfProfession();

    Menu getUpgradeMenu();

    boolean isHidden();

    List<Skill> getSkills();
}
