package dev.mega.afterrome.parser;

import dev.mega.afterrome.config.data.event.ConditionSection;
import dev.mega.afterrome.config.data.execute.ExecuteSection;
import dev.mega.afterrome.user.Profession;
import dev.mega.afterrome.user.User;
import org.bukkit.event.Event;

import java.util.List;

/**
 * Class represents a Parser for build profession configuration objects.
 */
public class Parser {
    private static Parser instance;
    private ParserHandler parserHandler;

    private Parser() {}

    /**
     * Gets the instance of Parser
     * @return Parser.
     */
    public static synchronized Parser getInstance() {
        if (instance == null) {
            instance = new Parser();
        }
        return instance;
    }

    /**
     * Sets the parser holder strategy.
     * @param handler ParserHandler strategy.
     */
    public void setParserHandler(ParserHandler handler) {
        this.parserHandler = handler;
    }

    /**
     * Gets the list of professions.
     * @return Professions list.
     */
    public List<Profession> getProfessions() {
        return parserHandler.getProfessions();
    }

    /**
     * Gets all conditions of Profession by event.
     * @param profession
     * @param event
     * @return Condition sections.
     */
    public List<ConditionSection> getConditionOf(Profession profession, Event event) {
        return parserHandler.getConditionOf(profession, event);
    }

    /**
     * Gets the executes list by event.
     * @param user
     * @param event
     * @return List of execute sections.
     */
    public List<ExecuteSection> getExecutesIfMatches(User user, Event event) {
        return parserHandler.getExecutesIfMatches(user, event);
    }

    /**
     * Registers profession events. Should be called once!
     */
    public void registerProfessionsEvents() {
        parserHandler.registerProfessionsEvents();
    }

    /**
     * Gets all executes of profession.
     * @param profession
     * @return Execute sections list.
     */
    public List<ExecuteSection> getExecutes(Profession profession) {
        return parserHandler.getExecutes(profession);
    }
}
