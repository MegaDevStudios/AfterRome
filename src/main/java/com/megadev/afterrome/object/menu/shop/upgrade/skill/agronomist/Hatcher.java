package com.megadev.afterrome.object.menu.shop.upgrade.skill.agronomist;

import com.megadev.afterrome.config.profession.AgronomistConfig;
import com.megadev.afterrome.config.profession.ProfessionConfig;
import com.megadev.afterrome.config.shop.upgrade.AgronomistUpgradeShopConfig;
import com.megadev.afterrome.config.ConfigManager;
import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import com.megadev.afterrome.object.menu.shop.upgrade.skill.SkillType;
import com.megadev.afterrome.util.ConditionCalculator;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerEggThrowEvent;

@Getter
@SerializableAs("hatcher")
public class Hatcher implements Skill {
    private final MenuItem menuItem = ConfigManager.getInstance().getConfig(AgronomistUpgradeShopConfig.class).getHatcherItem();
    @Setter
    private int level;

    public Hatcher(int level) {
        this.level = level;
    }

    @Override
    public String getName() {
        return ConfigManager.getInstance().getConfig(AgronomistUpgradeShopConfig.class).getHatcherName();
    }

    @Override
    public SkillType getSkillType() {
        return SkillType.HATCHER;
    }

    @Override
    public void execute(Event event) {
        double percent = ConfigManager.getInstance().getConfig(AgronomistConfig.class)
                .getPercent(this.level, ProfessionConfig.LevelType.CHICKEN);
        int multiplier = ConditionCalculator.isPassed(percent);

        PlayerEggThrowEvent eggThrowEvent = ((PlayerEggThrowEvent) event);

        eggThrowEvent.setHatching(true);
        eggThrowEvent.setNumHatches((byte) multiplier);
    }

    static {
        ConfigurationSerialization.registerClass(Hatcher.class);
    }
}
