package dev.mega.afterrome.event;

import dev.mega.afterrome.user.Profession;
import dev.mega.afterrome.user.User;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.HandlerList;

@Getter @Setter
public class UserSetProfessionEvent extends CancellableAREvent {
    @Getter private final HandlerList handlers = new HandlerList();

    private final User user;
    private Profession.Type type;

    public UserSetProfessionEvent(User user, Profession.Type file) {
        this.user = user;
        this.type = file;
    }
}
