package dev.mega.afterrome.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor(staticName = "of")
public class Profession {
    private Type type;
    private List<Skill> skills;

    public enum Type {
        DEFAULT,
        AGRONOMIST,
    }
}
