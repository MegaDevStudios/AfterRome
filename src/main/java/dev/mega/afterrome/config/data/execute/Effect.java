package dev.mega.afterrome.config.data.execute;

import dev.mega.afterrome.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.potion.PotionEffectType;

@Getter @Setter
@AllArgsConstructor
public class Effect implements Skill {
    private final PotionEffectType potionEffectType;
    private final long duration;

}
