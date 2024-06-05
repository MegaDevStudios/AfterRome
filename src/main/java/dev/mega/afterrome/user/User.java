package dev.mega.afterrome.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor(staticName = "of")
public class User {
    private final UUID uuid;
    private Profession.Type type;
    private List<Skill> skills;
    private int health;
    private int points;

    public static User of(UUID uuid, List<Skill.Type> skillTypes) {
        return User.of(uuid,
                Profession.Type.DEFAULT,
                skillTypes.stream().map(type -> Skill.of(type, 0)).toList(),
                0, 0);
    }
}
