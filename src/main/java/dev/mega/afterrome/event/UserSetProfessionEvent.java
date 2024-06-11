package dev.mega.afterrome.event;

import dev.mega.afterrome.user.Profession;
import dev.mega.afterrome.user.User;
import dev.mega.megacore.event.CancellableEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.HandlerList;

@Getter @Setter
@AllArgsConstructor
public class UserSetProfessionEvent extends CancellableEvent {
    private final User user;
    private Profession.Type type;
}
