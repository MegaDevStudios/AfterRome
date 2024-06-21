package dev.mega.afterrome.core.config.data.execute;

import dev.mega.afterrome.core.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;

@Getter @Setter
@AllArgsConstructor
public class Permission implements Skill {

    @Override
    public void execute (User user, Event event) {

    }
}
