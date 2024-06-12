package dev.mega.afterrome.config.data.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class LevelSection {
    private final int level;
    private final List<ValueSection> values;
    private final Type valueType;

    public enum Type {
        CHANCE,
        MULTIPLIER
    }
}
