package com.megadev.afterrome.object.profession;

import com.megadev.afterrome.object.menu.Menu;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import java.util.List;

public class Santa implements Profession {
    @Override
    public String getNameOfProfession() {
        return "";
    }

    @Override
    public Menu getUpgradeMenu() {
        return null;
    }

    @Override
    public boolean isHidden() {
        return false;
    }

    @Override
    public List<Skill> getSkills() {
        return List.of();
    }
}
