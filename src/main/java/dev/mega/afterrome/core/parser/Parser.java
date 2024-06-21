package dev.mega.afterrome.core.parser;

import dev.mega.afterrome.core.config.data.SkillSection;
import dev.mega.afterrome.core.config.data.event.ConditionSection;
import dev.mega.afterrome.core.config.data.event.EventSection;
import dev.mega.afterrome.core.config.data.execute.ExecuteSection;
import dev.mega.afterrome.core.user.Profession;
import dev.mega.afterrome.core.user.Skill;
import dev.mega.afterrome.core.user.User;
import org.bukkit.event.Event;

import java.util.List;
import java.util.Optional;

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
     * Determines if Parser has been set.
     * @return True if Parser initialized, False otherwise.
     */
    public boolean isInitialized() {
        return this.parserHandler != null;
    }

    public List<SkillSection> getSkillSectionBy(User user, Event event) {
        return parserHandler.getSkillSectionsBy(user, event);
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
        System.out.println("dev.mega.afterrome.parser.Parser#getProfessions");

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
     * Gets the available events list section by event.
     * @param user
     * @param event
     * @return
     */
    public List<EventSection> getAvailableEventSections(User user, Event event) {
        return parserHandler.getAvailableEventSections(user, event);
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

    public Optional<Integer> getUserLevel(User user, SkillSection skillSection) {
        return user.getProfession().getSkills().stream()
                .filter(skill -> skill.getName().equals(skillSection.getName()))
                .map(Skill::getLevel).findAny();
    }
}
