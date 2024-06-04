package dev.mega.afterrome.event;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.io.File;

@Getter @Setter
public class UserDeserializationEvent extends Event {
    @Getter private final HandlerList handlers = new HandlerList();

    private File file;

    public UserDeserializationEvent(File file) {
        this.file = file;
    }
}
