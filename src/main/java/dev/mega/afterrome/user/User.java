package dev.mega.afterrome.user;

import dev.mega.afterrome.profession.ProfessionType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class User {
    private final UUID uuid;
    private ProfessionType type;
    private int level;
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
