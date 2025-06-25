package com.ttrpg.helper.services.core.game.runner;

import lombok.Data;

import java.util.Arrays;
import java.util.Random;

public class DiceRoller {
    private static final Random rand = new Random();

    public static int roll(DiceType diceType) {
        int result;
        switch (diceType) {
            case D4 -> result = 4;
            case D6 -> result = 6;
            case D8 -> result = 8;
            case D10 -> result = 10;
            case D12 -> result = 12;
            case D20 -> result = 20;
            case D100 -> result = 100;
            default -> throw new IllegalArgumentException("Invalid dice type: " + diceType);
        }
        return result + 1;
    }

    public static int[] roll(DiceType diceType, int numberOfDice) {
        int[] result = new int[numberOfDice];
        Arrays.fill(result, roll(diceType));
        return result;
    }

    public static int[] rollWithAdvantage(DiceType diceType) {
        int[] result = new int[2];
        result[0] = roll(diceType);
        result[1] = roll(diceType);
        Arrays.sort(result);
        return result;
    }

    public static int[] rollWithDisadvantage(DiceType diceType) {
        int[] result = rollWithAdvantage(diceType);
        return new int[]{result[0], result[1]};
    }

    public enum DiceType {
        D4, D6, D8, D10, D12, D20, D100
    }
}