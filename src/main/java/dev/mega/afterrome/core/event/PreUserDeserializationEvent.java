package dev.mega.afterrome.core.event;

import dev.mega.megacore.event.MegaEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.io.File;

@Getter @Setter
@AllArgsConstructor
public class PreUserDeserializationEvent extends MegaEvent {
    private final static HandlerList handlers = new HandlerList();
    private File file;

    public @NotNull HandlerList getHandlers() {
        return handlers;
    }
}
