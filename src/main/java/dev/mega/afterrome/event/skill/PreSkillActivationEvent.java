package dev.mega.afterrome.event.skill;

import dev.mega.afterrome.user.Skill;
import dev.mega.afterrome.user.User;
import dev.mega.megacore.event.CancellableEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class PreSkillActivationEvent extends CancellableEvent {
    private final User user;
    private final Skill.Type type;

    public enum SkillActivationType {
        ABILITY,
        BOOST,
        PERMISSION,
        ;
    }
}
