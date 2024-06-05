package dev.mega.afterrome.event;

import dev.mega.afterrome.user.User;
import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.io.File;

@Getter
public class UserDeserializationEvent extends Event {
    private final HandlerList handlers = new HandlerList();

    private final File file;
    private final User user;

    public UserDeserializationEvent(File file, User user) {
        this.file = file;
        this.user = user;
    }
}
