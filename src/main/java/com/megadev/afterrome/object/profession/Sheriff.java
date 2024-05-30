package com.megadev.afterrome.object.profession;

import com.megadev.afterrome.object.menu.AbstractUpgradeMenu;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.SkillType;
import com.megadev.afterrome.object.user.User;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class Sheriff implements HiddenProfession {
    @Override
    public String getNameOfProfession() {
        return "";
    }

    @Override
    public AbstractUpgradeMenu getUpgradeMenu(User user) {
        return null;
    }

    @Override
    public MenuItem getBackgroundItem() {
        return null;
    }

    @Override
    public List<Skill> getSkills() {
        return List.of();
    }

    @Override
    public Skill getSkill(SkillType skill) {
        return null;
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        return Map.of();
    }
}
