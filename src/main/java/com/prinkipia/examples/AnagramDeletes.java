package com.prinkipia.examples;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnagramDeletes {
    public static int numberNeeded(String first, String second) {
        if (first.isEmpty()) {
            return second.length();
        }

        if (second.isEmpty()) {
            return first.length();
        }

        Map<Character, Integer> characterFrequenciesInFirst = computeCharacterFrequencies(first);
        Map<Character, Integer> characterFrequenciesInSecnd = computeCharacterFrequencies(second);

        int count = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            count += Math.abs(characterFrequenciesInFirst.get(i) - characterFrequenciesInSecnd.get(i));
        }
        return count;
    }

    private static Map<Character, Integer> computeCharacterFrequencies(final String source) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            frequencies.put(c, 0);
        }

        for (char c : source.toCharArray()) {
            Integer frequency = frequencies.get(c);
            frequencies.put(c, frequency + 1);
        }
        return frequencies;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
