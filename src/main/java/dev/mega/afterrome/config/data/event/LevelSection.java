package dev.mega.afterrome.config.data.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class LevelSection {
    private final int level;
    private final double value;
    private final int count;
    private final Type valueType;

    public enum Type {
        CHANCE,
        MULTIPLIER
    }
}
