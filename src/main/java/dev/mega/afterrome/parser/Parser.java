package dev.mega.afterrome.parser;

import dev.mega.afterrome.config.data.event.ConditionSection;
import dev.mega.afterrome.config.data.execute.ExecuteSection;
import dev.mega.afterrome.user.Profession;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;

import java.util.List;

@Getter @Setter
public class Parser {
    private static ParserHandler parserHandler;

    public static List<Profession> getProfessions() {
        return parserHandler.getProfessions();
    }

    public static ConditionSection getConditionOf(Profession profession, Event event) {
        return parserHandler.getConditionOf(profession, event);
    }

    public static void registerProfessionsEvents() {
        parserHandler.registerProfessionsEvents();
    }

    public static void setParserHandler(ParserHandler parserHandler) {
        Parser.parserHandler = parserHandler;
    }

    public static List<ExecuteSection> getExecutes(Profession profession) {
        return parserHandler.getExecutes(profession);
    }
}
