package dev.mega.afterrome.event;

import dev.mega.afterrome.user.User;
import dev.mega.megacore.event.CancellableEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.HandlerList;

@Getter @Setter
@AllArgsConstructor
public class PreClassChoiceEvent extends CancellableEvent {
    private final User user;
}
