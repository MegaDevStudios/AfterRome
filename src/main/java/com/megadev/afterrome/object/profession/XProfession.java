package com.megadev.afterrome.object.profession;

import com.megadev.afterrome.object.skill.XSkill;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class XProfession {
    private final ProfessionType professionType;
    private final List<XSkill> skill;

    public XProfession(ProfessionType professionType, List<XSkill> skill) {
        this.professionType = professionType;
        this.skill = skill;
    }
}
