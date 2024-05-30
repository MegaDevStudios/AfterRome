package com.megadev.afterrome.config.profession;

import com.megadev.afterrome.util.ConditionCalculator;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class AgronomistConfig extends ProfessionConfig {
    public AgronomistConfig(@NotNull Plugin plugin, String... path) {
        super(plugin, path);
    }

    public double[] getFarmerPercents(int level) {
        double[] percents = new double[5];

        for (int i = 1; i <= 5; i++)
            percents[i] = (double) getValue("skill.farmer.level." + level + ".fetus" + i);

        if (ConditionCalculator.isValid(percents)) return percents;
        else throw new IllegalArgumentException("The sum of the percentages does not equal 100%");
    }

    public double[] getButcherPercents(int level) {
        double[] percents = new double[5];
        for (int i = 1; i <= 5; i++)
            percents[i] = (double) getValue("skill.butcher.level." + level + ".meat" + i);

        if (ConditionCalculator.isValid(percents)) return percents;
        else throw new IllegalArgumentException("The sum of the percentages does not equal 100%");
    }

    public double[] getTannerPercents(int level) {
        double[] percents = new double[5];

        for (int i = 1; i <= 5; i++)
            percents[i] = (double) getValue("skill.tanner.level." + level + ".leather" + i);

        if (ConditionCalculator.isValid(percents)) return percents;
        else throw new IllegalArgumentException("The sum of the percentages does not equal 100%");
    }
}
