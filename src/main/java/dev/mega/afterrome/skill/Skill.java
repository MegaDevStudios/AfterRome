package dev.mega.afterrome.skill;

import com.megadev.afterrome.object.menu.shop.upgrade.skill.SkillType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Skill {
    private SkillType type;
    private int level;
}
