package dev.mega.afterrome.manager;

import dev.mega.afterrome.config.data.execute.ExecuteSection;
import dev.mega.afterrome.parser.Parser;
import dev.mega.afterrome.user.Profession;
import dev.mega.afterrome.user.User;
import dev.mega.megacore.MegaCore;
import dev.mega.megacore.manager.Manager;
import org.bukkit.event.Event;

import java.util.List;

/**
 * Class represents the event manager to manage events for professions.
 */
public class EventManager extends Manager {
    public EventManager(MegaCore megaCore) {
        super(megaCore);
    }

    /**
     * Handles the profession event.
     * @param user
     * @param event
     */
    public void handleEvent(User user, Event event) {
        Profession profession = user.getProfession();

        List<ExecuteSection> executeSections = Parser.getInstance().getExecutesIfMatches(user, event);
        executeSections.forEach(executeSection -> {
            //todo: do something
        });
    }

    /**
     * Calls when manager enables.
     */
    @Override
    public void enable() {

    }

    /**
     * Class when manager disables.
     */
    @Override
    public void disable() {

    }
}
