package com.megadev.afterrome.config.profession;

import com.megadev.afterrome.util.ConditionCalculator;
import dev.mega.megacore.config.Configurator;
import dev.mega.megacore.util.Color;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.stream.IntStream;

public abstract class ProfessionConfig extends Configurator {
    protected ProfessionConfig(@NotNull Plugin plugin, String... path) {
        super(plugin, path);
    }

    public String getName() {
        return Color.getTranslated((String) getValue("name"));
    }

    public double[] getPercents(int level, LevelType type) {
        double[] percents = IntStream.range(0, 5)
                .mapToDouble(i -> getPercent(level, type, i))
                .toArray();
        return ConditionCalculator.validateAndGet(percents);
    }

    public double getPercent(int level, LevelType type, int index) {
        String value = getPercentValue("skill." + type.skillName + ".level." + level + "." + type.title + (index + 1));
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException exception) {
            return getPercent(value + ".0");
        }
    }

    public double getPercent(int level, LevelType type) {
        String value = getPercentValue("skill." + type.skillName + ".level." + level);
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException exception) {
            return getPercent(value + ".0");
        }
    }


    public String getPercentValue(String path) {
        return String.valueOf((double) getValue(path));
    }

    private double getPercent(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException exception) {
            return 0;
        }
    }

    public enum LevelType {
        FETUS("farmer", "fetus"),
        MEAT("butcher", "meat"),
        LEATHER("tanner", "leather"),
        CHICKEN("hatcher", "hatcher"),
        LUMBERJACK("lumberjack", "lumberjack"),

        BLACKSMITH("blacksmith", "meat"),
        FISHERMAN("fisherman", "meat"),
        HORSEMAN("horseman", "meat"),
        METALLURGIST("metallurgist", "meat"),
        MINER("miner", "meat"),
        TOOLMAKER("toolmaker", "meat"),
        ;
        private final String title;
        private final String skillName;
        LevelType(String skillName, String title) {
            this.title = title;
            this.skillName = skillName;
        }
    }
}
