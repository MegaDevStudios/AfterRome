package dev.mega.afterrome.event;

import dev.mega.afterrome.user.User;
import dev.mega.megacore.event.CancellableEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@Getter @Setter
@AllArgsConstructor
public class UserSetProfessionEvent extends CancellableEvent {
    private final User user;
    private String name;

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
