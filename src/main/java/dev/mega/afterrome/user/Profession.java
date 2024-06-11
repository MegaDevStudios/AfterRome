package dev.mega.afterrome.user;

import dev.mega.afterrome.config.Config;
import dev.mega.afterrome.config.ConfigManager;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor(staticName = "of")
public class Profession {
    private Type type;
    private List<Skill> skills;

//    public static Profession of(Profession.Type type) {
//        Config config = ConfigManager.getInstance().getConfig(Config.class);
////        return of(type, config.getSkillsOf(type).stream().map(skillType -> Skill.of(skillType, 0)).toList());
//    }

    public enum Type {
        DEFAULT,
        AGRONOMIST,
        ARTISAN,
        AESCULAPIUS,
        SON_OF_MARS,
        FORESTER

    }
}
