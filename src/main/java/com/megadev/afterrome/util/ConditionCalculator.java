package com.megadev.afterrome.util;

import java.util.Random;

public class ConditionCalculator {
    public static boolean isPassed(double percent) {
        return new Random().nextDouble() * 100 < percent;
    }

    public static boolean isValid(double[] percents) {
        double result = 0;
        for (double percent : percents)
            result += percent;
        return result == 100;
    }

    public static int isPassed(double[] percents) {
        for (int i = 0; i < percents.length; i++)
            if (isPassed(percents[i])) return i;
        return percents.length;
    }
}
