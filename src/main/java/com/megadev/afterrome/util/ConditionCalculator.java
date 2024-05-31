package com.megadev.afterrome.util;

import java.util.Arrays;
import java.util.Random;

public class ConditionCalculator {
    public static boolean isPassed(double percent) {
        return new Random().nextDouble() * 100 < percent;
    }

    public static boolean isValid(double[] percents) {
        return Arrays.stream(percents).sum() == 100;
    }

    public static double[] validateAndGet(double[] percents) {
        double sum = Arrays.stream(percents).sum();
        return Arrays.stream(percents)
                .map(percent -> percent + (100 - sum) / percents.length)
                .toArray();
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
