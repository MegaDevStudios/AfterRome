package dev.mega.afterrome.core.user;

import dev.mega.afterrome.core.manager.ProfessionManager;
import dev.mega.megacore.manager.MegaManager;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor(staticName = "of")
public class User {
    private final UUID uuid;
    private Profession profession;
    private int health;
    private int points;

    public static User of(UUID uuid) {
        return User.of(uuid,
                MegaManager.getManager(ProfessionManager.class).getDefault(),
                0, 0);
    }
}
