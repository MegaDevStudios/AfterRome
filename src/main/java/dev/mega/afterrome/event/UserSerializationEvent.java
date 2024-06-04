package dev.mega.afterrome.event;

import dev.mega.afterrome.user.User;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.HandlerList;

import java.io.File;

@Getter @Setter
public class UserSerializationEvent extends CancellableAREvent {
    @Getter private final HandlerList handlers = new HandlerList();

    private User user;
    private File file;

    public UserSerializationEvent(User user, File file) {
        this.user = user;
        this.file = file;
    }
}
