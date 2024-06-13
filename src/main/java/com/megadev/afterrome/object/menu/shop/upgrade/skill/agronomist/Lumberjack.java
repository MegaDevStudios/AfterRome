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
@SerializableAs("lumberjack")
public class Lumberjack implements Skill, ConfigurationSerializable {
    private final MenuItem menuItem = null;
    private int level;

    public Lumberjack(int level) {
        this.level = level;
    }

    @Override
    public String getName() {
        return "lumberjack";
    }

    @Override
    public SkillType getSkillType() {
        return SkillType.LUMBERJACK;
    }

    @Override
    public void incrementLevel() {
        level++;
    }

    @Override
    public void execute(Event event) {
//        double percent = ConfigManager.getInstance().getConfig(AgronomistConfig.class).getPercent(this.level, AgronomistConfig.LevelType.LUMBERJACK);
//
//        BlockBreakEvent breakEvent = (BlockBreakEvent) event;
//
//        Block block = breakEvent.getBlock();
//
//        if (ConditionCalculator.isPassed(percent) == 1) {
//            MegaManager.getManager(TreecapitatorManager.class).treeCapitate(block);
//        }
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        return Skill.super.serialize();
    }

    static {
        ConfigurationSerialization.registerClass(Lumberjack.class);
    }
}
