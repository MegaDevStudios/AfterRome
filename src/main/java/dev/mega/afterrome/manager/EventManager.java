package dev.mega.afterrome.manager;

import dev.mega.afterrome.handler.EventHandler;
import dev.mega.afterrome.user.User;
import dev.mega.megacore.MegaCore;
import dev.mega.megacore.manager.Manager;
import org.bukkit.event.Event;

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
        EventHandler eventHandler = new EventHandler(user, event);
        eventHandler.handleEvent();
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
