package dev.mega.afterrome.core.config.data.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Class represents the value section.
 */
@Getter @Setter
@AllArgsConstructor
public class ValueSection {
    private final double percent;
    private final int count;
}
