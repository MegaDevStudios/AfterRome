package com.megadev.afterrome.object.menu.shop.upgrade.skill.agronomist;

import com.megadev.afterrome.object.menu.item.MenuItem;
import com.megadev.afterrome.object.menu.shop.upgrade.skill.Skill;

import com.megadev.afterrome.object.menu.shop.upgrade.skill.SkillType;
import lombok.Getter;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

@Getter
@SerializableAs("hatcher")
public class Hatcher implements Skill, ConfigurationSerializable {
    private final MenuItem menuItem = null;
    private int level;

    public Hatcher(int level) {
        this.level = level;
    }

    @Override
    public String getName() {
        return "hatcher";
    }

    @Override
    public SkillType getSkillType() {
        return SkillType.HATCHER;
    }

    @Override
    public void incrementLevel() {
        level++;
    }

    @Override
    public void execute(Event event) {
//        double percent = ConfigManager.getInstance().getConfig(AgronomistConfig.class).getPercent(this.level, AgronomistConfig.LevelType.CHICKEN);
//        int multiplier = ConditionCalculator.isPassed(percent);
//
//        PlayerEggThrowEvent eggThrowEvent = ((PlayerEggThrowEvent) event);
//
//        eggThrowEvent.setHatching(true);
//        eggThrowEvent.setNumHatches((byte) multiplier);
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        return Skill.super.serialize();
    }

    static {
        ConfigurationSerialization.registerClass(Hatcher.class);
    }
}
