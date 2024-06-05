package dev.mega.afterrome.event;

import dev.mega.afterrome.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.HandlerList;

@Getter @Setter
@AllArgsConstructor
public class ClassChoiceEvent extends CancellableAREvent {
    private final HandlerList handlers = new HandlerList();

    private final User user;
}
