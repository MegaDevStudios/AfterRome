package dev.mega.afterrome.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Represents the profession's skill.
 */
@Getter
@AllArgsConstructor(staticName = "of")
public class Skill {
    private String name;
    private int level;

    /**
     * Increments and returns level of skill.
     * @return Skill level.
     */
    public int incrementAndGet() {
        return ++this.level;
    }
}
