package dev.mega.afterrome.core.config.data.event;

import dev.mega.afterrome.core.config.data.execute.ExecuteSection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;

import java.util.List;

/**
 * Class represents the event section.
 */
@Getter @Setter
@AllArgsConstructor
public class EventSection {
    private final String name;
    private final List<LevelSection> levelSections;
    private final List<ConditionSection> conditionSections;
    private final List<ExecuteSection> executes;

    /**
     * Checks if event has matched conditions.
     * @param event
     * @return True if event matches, False otherwise.
     */
    public boolean matches(Event event) {
        return name.equals(event.getEventName()) && (
                        conditionSections.stream()
                                .filter(ConditionSection::isPositive)
                                .anyMatch(cs -> cs.matches(event)) &&
                        conditionSections.stream()
                                .filter(cs -> !cs.isPositive())
                                .noneMatch(cs -> cs.matches(event)));
    }
}
