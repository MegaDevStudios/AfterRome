package com.megadev.afterrome.object.profession;

import com.megadev.afterrome.object.menu.AbstractUpgradeMenu;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.user.User;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class Engineer implements HiddenProfession {
    List<Skill> skills;

    @Override
    public String getNameOfProfession() {
        return "";
    }

    @Override
    public AbstractUpgradeMenu getUpgradeMenu(User user) {
        return null;
    }

    @Override
    public List<Skill> getSkills() {
        return List.of();
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        return Map.of();
    }
    
}
