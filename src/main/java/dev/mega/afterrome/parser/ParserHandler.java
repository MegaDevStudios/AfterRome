package dev.mega.afterrome.parser;

import dev.mega.afterrome.config.data.event.ConditionSection;
import dev.mega.afterrome.config.data.execute.ExecuteSection;
import dev.mega.afterrome.user.Profession;
import org.bukkit.event.Event;

import java.util.List;

public interface ParserHandler {
    List<Profession> getProfessions();

    ConditionSection getConditionOf(Profession profession, Event event);

    void registerProfessionsEvents();

    List<ExecuteSection> getExecutes(Profession profession);
}
