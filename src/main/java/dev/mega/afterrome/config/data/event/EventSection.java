package dev.mega.afterrome.config.data.event;

import dev.mega.afterrome.config.data.execute.ExecuteSection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class EventSection {
    private final String name;
    private final List<LevelSection> levelSections;
    private final List<ConditionSection> conditionSection;
    private final List<ExecuteSection> executes;
}
