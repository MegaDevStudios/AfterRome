package dev.mega.afterrome.core.config.data;

import dev.mega.afterrome.core.config.menu.item.HeadSection;
import dev.mega.afterrome.core.config.menu.MenuSection;
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
    private final String name;
    private final boolean isHidden;
    private final List<SkillSection> skills;
    private final MenuSection menuSection;
    private final HeadSection headSection;
}
