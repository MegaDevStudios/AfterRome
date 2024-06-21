package dev.mega.afterrome.core.config.data;

import dev.mega.afterrome.core.config.data.event.EventSection;
import dev.mega.afterrome.core.config.data.execute.ExecuteSection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class represents the skill section.
 */
@Getter @Setter
@AllArgsConstructor
public class SkillSection {
    private String name;
    private final List<EventSection> events;

    /**
     * Returns the list of execute section if event has matched conditions.
     * @param event
     * @return List of execute sections.
     */
    public List<ExecuteSection> getExecutorsIfMatches(Event event) {
        return events.stream()
                .filter(eventSection -> eventSection.matches(event))
                .flatMap(eventSection -> eventSection.getExecutes().stream())
                .collect(Collectors.toList());
    }
}
