package dev.mega.afterrome.config.data.execute;

import dev.mega.afterrome.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Ability implements Skill {
    private final Type type;

    public enum Type {
        TREECAPITATOR,
    }
}
