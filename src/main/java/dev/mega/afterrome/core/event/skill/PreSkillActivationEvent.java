package dev.mega.afterrome.core.event.skill;

import dev.mega.afterrome.core.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@Getter @Setter
@AllArgsConstructor
public class PreSkillActivationEvent extends Event implements Cancellable {
    private final static HandlerList handlers = new HandlerList();
    private final User user;
    private final String name;

    private String msg;
    private boolean cancelled;

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public enum SkillActivationType {
        ABILITY,
        BOOST,
        PERMISSION,
        ;
    }
}
