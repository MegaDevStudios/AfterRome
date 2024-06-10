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
@SerializableAs("metallurgist")
public class Metallurgist implements Skill {
    private final MenuItem menuItem = ConfigManager.getInstance().getConfig(ArtisanUpgradeShopConfig.class).getMetallurgistItem();
    @Setter
    private int level;

    public Metallurgist(int level) {
        this.level = level;
    }

    @Override
    public String getName() {
        return ConfigManager.getInstance().getConfig(ArtisanUpgradeShopConfig.class).getMetallurgistName();
    }

    @Override
    public SkillType getSkillType() {
        return SkillType.METALLURGIST;
    }

    @Override
    public void execute(Event event) {

    }

    static {
        ConfigurationSerialization.registerClass(Metallurgist.class);
    }
}
