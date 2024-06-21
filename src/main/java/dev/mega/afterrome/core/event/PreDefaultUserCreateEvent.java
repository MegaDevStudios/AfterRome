package dev.mega.afterrome.core.event;

import dev.mega.afterrome.core.user.User;
import dev.mega.megacore.event.MegaEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@Getter @Setter
@AllArgsConstructor
public class PreDefaultUserCreateEvent extends MegaEvent {
    private final static HandlerList handlers = new HandlerList();
    private User user;

    public @NotNull HandlerList getHandlers() {
        return handlers;
    }
}
