package dev.mega.afterrome.event;

import dev.mega.afterrome.user.User;
import dev.mega.megacore.event.CancellableEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class UserSetProfessionEvent extends CancellableEvent {
    private final User user;
    private String name;
}
