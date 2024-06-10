package com.megadev.afterrome.object.menu.shop.upgrade.skill.artisan;

import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.config.shop.upgrade.ArtisanUpgradeShopConfig;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.SkillType;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.event.Event;

@Getter
@SerializableAs("horseman")
public class Horseman implements Skill {
    private final MenuItem menuItem = ConfigManager.getInstance().getConfig(ArtisanUpgradeShopConfig.class).getHorsemanItem();
    @Setter
    private int level;

    public Horseman(int level) {
        this.level = level;
    }

    @Override
    public String getName() {
        return ConfigManager.getInstance().getConfig(ArtisanUpgradeShopConfig.class).getHorsemanName();
    }

    @Override
    public SkillType getSkillType() {
        return SkillType.HORSEMAN;
    }

    @Override
    public void execute(Event event) {

    }

    static {
        ConfigurationSerialization.registerClass(Horseman.class);
    }
}
