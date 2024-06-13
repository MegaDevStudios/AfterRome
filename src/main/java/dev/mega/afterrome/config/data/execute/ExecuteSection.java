package dev.mega.afterrome.config.data.execute;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Class represents the execute section.
 */
@Getter @Setter
@AllArgsConstructor
public class ExecuteSection {
    private final Skill skill;
    private final Type type;

    public enum Type {
        EFFECT,
        PERMISSION,
        BOOST,
        ABILITY,
    }
}
