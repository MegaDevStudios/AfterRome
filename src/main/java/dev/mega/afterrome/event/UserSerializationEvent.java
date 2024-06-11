package dev.mega.afterrome.event;

import dev.mega.afterrome.user.User;
import dev.mega.megacore.event.CancellableEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.HandlerList;

import java.io.File;

@Getter @Setter
@AllArgsConstructor
public class UserSerializationEvent extends CancellableEvent {
    private User user;
    private File file;
}
