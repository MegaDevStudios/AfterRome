package dev.mega.afterrome.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor(staticName = "of")
public class Skill {
    private String name;
    private int level;

    public int incrementAndGet() {
        return ++this.level;
    }
}
