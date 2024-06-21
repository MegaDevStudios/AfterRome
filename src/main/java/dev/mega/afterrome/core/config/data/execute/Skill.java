package dev.mega.afterrome.core.config.data.execute;

import dev.mega.afterrome.core.user.User;
import org.bukkit.event.Event;

public interface Skill {
    void execute(User user, Event event);
}
