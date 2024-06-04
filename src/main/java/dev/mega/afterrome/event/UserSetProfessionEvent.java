package dev.mega.afterrome.event;

import dev.mega.afterrome.user.User;
import dev.mega.afterrome.profession.ProfessionType;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.HandlerList;

@Getter @Setter
public class UserSetProfessionEvent extends CancellableAREvent {
    @Getter private final HandlerList handlers = new HandlerList();

    private final User user;
    private ProfessionType type;

    public UserSetProfessionEvent(User user, ProfessionType file) {
        this.user = user;
        this.type = file;
    }
}
