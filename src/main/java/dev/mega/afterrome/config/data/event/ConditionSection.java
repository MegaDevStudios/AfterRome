package dev.mega.afterrome.config.data.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;

import java.util.List;

/**
 * Class represents the condition section.
 */
@Getter @Setter
@AllArgsConstructor
public class ConditionSection {
    private final List<MethodSection> methods;
    private final boolean positive;

    /**
     * Checks if event has matched conditions.
     * @param event
     * @return True if event matches, False otherwise.
     */
    public boolean matches(Event event) {
        return methods.stream().anyMatch(methodSection -> methodSection.matches(event));
    }
}
