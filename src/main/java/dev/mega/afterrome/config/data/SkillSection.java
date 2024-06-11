package dev.mega.afterrome.config.data;

import dev.mega.afterrome.config.data.event.EventSection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class SkillSection {
    private String name;
    private final List<EventSection> events;
}
