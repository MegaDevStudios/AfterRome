package dev.mega.afterrome.core.config.data.execute;

import dev.mega.afterrome.core.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;

@Getter @Setter
@AllArgsConstructor
public class Ability implements Skill {
    private final Type type;

    @Override
    public void execute (User user, Event event) {

    }

    public enum Type {
        TREECAPITATOR,
    }
}
