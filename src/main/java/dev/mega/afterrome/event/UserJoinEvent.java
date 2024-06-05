package dev.mega.afterrome.event;

import dev.mega.afterrome.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
@AllArgsConstructor
public class UserJoinEvent extends Event {
    private final HandlerList handlers = new HandlerList();

    private final User user;
}
