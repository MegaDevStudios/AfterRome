package dev.mega.afterrome.event;

import dev.mega.afterrome.user.User;
import dev.mega.megacore.event.CancellableEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.io.File;

@Getter @Setter
@AllArgsConstructor
public class UserSerializationEvent extends CancellableEvent {
    private final static HandlerList handlers = new HandlerList();
    private User user;
    private File file;

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
