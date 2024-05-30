package com.megadev.afterrome.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConditionCalculatorTest {

    @Test
    void choiceOne() {
        double[] probabilities = {0.10, 0.20, 0.25, 0.30, 0.15};
        double[] cumulativeProbabilities = new double[probabilities.length];

        // Тестируем функцию выбора событий
        int numTrials = 100000;
        int[] eventCounts = new int[probabilities.length];

        for (int i = 0; i < numTrials; i++) {
            int event = ConditionCalculator.chooseEvent(cumulativeProbabilities);
            eventCounts[event]++;
        }

        // Выводим результаты
        for (int i = 0; i < eventCounts.length; i++) {
            System.out.printf("Событие %d: %.2f%%\n", i + 1, 100.0 * eventCounts[i] / numTrials);
        }
    }
}