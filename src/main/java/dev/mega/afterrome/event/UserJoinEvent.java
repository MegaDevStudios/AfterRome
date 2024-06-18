package dev.mega.afterrome.event;

import dev.mega.afterrome.user.User;
import dev.mega.megacore.event.MegaEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@Getter
@AllArgsConstructor
public class UserJoinEvent extends MegaEvent {
    private final static HandlerList handlers = new HandlerList();
    private final User user;

    public @NotNull HandlerList getHandlers() {
        return handlers;
    }
}
