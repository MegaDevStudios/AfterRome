package dev.mega.afterrome.config.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class ProfessionSection {
    private String name;
    private final List<SkillSection> skills;
}
