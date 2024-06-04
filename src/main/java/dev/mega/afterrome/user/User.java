package dev.mega.afterrome.user;

import dev.mega.afterrome.profession.ProfessionType;
import dev.mega.afterrome.skill.Skill;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter @Setter
public class User {
    private final UUID uuid;
    private ProfessionType type;
    private List<Skill> skills;
    private int health;
    private int points;

    public User(UUID uuid) {
        this.uuid = uuid;
    }

    public User(UUID uuid, ProfessionType type) {
        this.uuid = uuid;
        this.type = type;
    }
}
