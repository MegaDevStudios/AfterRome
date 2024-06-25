package dev.mega.afterrome.core.event;

import dev.mega.afterrome.core.user.User;
import dev.mega.megacore.event.CancellableEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@Getter @Setter
public class PreClassChoiceEvent extends Event implements Cancellable {
    private final static HandlerList handlers = new HandlerList();
    private final User user;

    private boolean cancelled;

    public PreClassChoiceEvent(User user) {
        this.user = user;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }


    public static HandlerList getHandlerList() {
        return handlers;
    }
}
