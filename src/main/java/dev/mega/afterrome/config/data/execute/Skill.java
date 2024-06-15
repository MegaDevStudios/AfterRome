package dev.mega.afterrome.config.data.execute;

import dev.mega.afterrome.user.User;
import org.bukkit.event.Event;

public interface Skill {
    void execute(User user, Event event);
}
