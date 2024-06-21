package dev.mega.afterrome.core.parser;

import dev.mega.afterrome.core.config.data.SkillSection;
import dev.mega.afterrome.core.config.data.event.ConditionSection;
import dev.mega.afterrome.core.config.data.event.EventSection;
import dev.mega.afterrome.core.config.data.execute.ExecuteSection;
import dev.mega.afterrome.core.user.Profession;
import dev.mega.afterrome.core.user.User;
import org.bukkit.event.Event;

import java.util.List;

public interface ParserHandler {
    List<Profession> getProfessions();

    List<ConditionSection> getConditionOf(Profession profession, Event event);

    List<ExecuteSection> getExecutesIfMatches(User user, Event event);

    List<EventSection> getAvailableEventSections(User user, Event event);

    List<SkillSection> getSkillSectionsBy(User user, Event event);

    void registerProfessionsEvents();

    List<ExecuteSection> getExecutes(Profession profession);
}
