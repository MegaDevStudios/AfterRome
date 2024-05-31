package com.megadev.afterrome.config.profession;

import com.megadev.afterrome.util.ConditionCalculator;
import lombok.Getter;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.stream.IntStream;

public class AgronomistConfig extends ProfessionConfig {
    public AgronomistConfig(@NotNull Plugin plugin, String... path) {
        super(plugin, path);
    }

    public double[] getPercents(int level, LevelType type) {
        double[] percents = IntStream.range(0, 5)
                .mapToDouble(i -> (double) getValue("skill.farmer.level." + level + "." + type.title + (i + 1)))
                .toArray();
        return ConditionCalculator.validateAndGet(percents);
    }

    public enum LevelType {
        FETUS("fetus"), MEAT("meat"), LEATHER("leather");
        private final String title;
        LevelType(String title) { this.title = title; }
    }
}
