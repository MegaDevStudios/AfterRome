package dev.mega.afterrome.core.event;

import dev.mega.afterrome.core.user.User;
import dev.mega.megacore.event.CancellableEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@Getter @Setter
@AllArgsConstructor
public class UserSetProfessionEvent extends CancellableEvent  {
    private final static HandlerList handlers = new HandlerList();
    private final User user;
    private String name;

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
