package com.megadev.afterrome.util;

import java.util.Random;

public class ConditionCalculator {
    public static boolean isPassed(double percent) {
        return new Random().nextDouble() < percent;
    }
}
