package dev.mega.afterrome.event;

import dev.mega.megacore.event.MegaEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.io.File;

@Getter @Setter
@AllArgsConstructor
public class PreUserDeserializationEvent extends MegaEvent {
    private File file;
}
