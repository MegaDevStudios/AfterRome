package dev.mega.afterrome.config.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Class represents the profession section.
 */
@Getter @Setter
@AllArgsConstructor
public class ProfessionSection {
    private String name;
    private final List<SkillSection> skills;
}
