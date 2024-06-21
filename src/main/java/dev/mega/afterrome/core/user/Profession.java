package dev.mega.afterrome.core.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor(staticName = "of")
public class Profession {
    private String name;
    private List<Skill> skills;

    public static Profession copyOf(Profession profession) {
        return new Profession(profession.name, profession.skills);
    }
}
