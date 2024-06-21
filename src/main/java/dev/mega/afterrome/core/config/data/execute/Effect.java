package dev.mega.afterrome.core.config.data.execute;

import dev.mega.afterrome.core.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;
import org.bukkit.potion.PotionEffectType;

@Getter @Setter
@AllArgsConstructor
public class Effect implements Skill {
    private final PotionEffectType potionEffectType;
    private final long duration;

    @Override
    public void execute (User user, Event event) {

    }
}
