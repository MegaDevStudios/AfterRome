package com.megadev.afterrome.object.skill;

import com.megadev.afterrome.object.menu.shop.upgrade.skill.SkillType;
import lombok.Getter;

@Getter
public class XSkill {
    private final SkillType skillType;
    private final int level;

    public XSkill(SkillType skillType, int level) {
        this.skillType = skillType;
        this.level = level;
    }
}
