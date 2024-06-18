package dev.mega.afterrome.event;

import dev.mega.afterrome.user.User;
import dev.mega.megacore.event.MegaEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@Getter @Setter
@AllArgsConstructor
public class PreDefaultUserCreateEvent extends MegaEvent {
    private User user;

    public @NotNull HandlerList getHandlers() {
        return handlers;
    }
}
