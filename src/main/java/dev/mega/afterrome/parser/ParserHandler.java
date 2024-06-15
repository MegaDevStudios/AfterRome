package dev.mega.afterrome.parser;

import dev.mega.afterrome.config.data.SkillSection;
import dev.mega.afterrome.config.data.event.ConditionSection;
import dev.mega.afterrome.config.data.event.EventSection;
import dev.mega.afterrome.config.data.execute.ExecuteSection;
import dev.mega.afterrome.user.Profession;
import dev.mega.afterrome.user.User;
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
