package com.megadev.afterrome.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConditionCalculatorTest {

    @Test
    void choiceOne() {
        double[] probabilities = {0.10, 0.20, 0.25, 0.30, 0.15};

        List<Integer> integers = new ArrayList<>();

        for (int i = 0; i < Math.pow(2, 30) - 1; i++) {
            int index = ConditionCalculator.choiceOne(probabilities);
            integers.add(index);
            System.out.println(i + "; current index is " + index);
        }

        double result = 0;
        for (int anInt : integers) result += anInt;
        System.out.println("Average index is: " + result / integers.size());
    }
}