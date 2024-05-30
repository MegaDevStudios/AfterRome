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

    public static int choiceOne(double[] probabilities) {
        double[] cumulativeProbabilities = new double[probabilities.length];

        double cumulativeSum = 0.0;
        for (int i = 0; i < probabilities.length; i++) {
            cumulativeSum += probabilities[i];
            cumulativeProbabilities[i] = cumulativeSum;
        }

        return chooseEvent(cumulativeProbabilities);
    }

    public static int chooseEvent(double[] cumulativeProbabilities) {
        Random random = new Random();
        double r = random.nextDouble();

        for (int i = 0; i < cumulativeProbabilities.length; i++) {
            if (r <= cumulativeProbabilities[i]) {
                return i;
            }
        }

        return cumulativeProbabilities.length - 1;
    }
}
