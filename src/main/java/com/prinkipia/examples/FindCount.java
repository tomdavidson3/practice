package com.prinkipia.examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCount {
    private Map<Integer, Integer> counts = new HashMap<>();

    public Integer findOdd(List<Integer> numbers) {
        for (int number : numbers) {
            Integer count = counts.get(number);
            if (count == null) {
                count = 1;
                counts.put(number, count);
            }
            else {
                count++;
                counts.put(number, count);
            }
        }

        for (Map.Entry<Integer, Integer> entries : counts.entrySet()) {
            if (entries.getValue() % 2 == 1) {
                return entries.getKey();
            }
        }

        return null;
    }

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 1, 2);
        System.out.println(new FindCount().findOdd(values));

        values = Arrays.asList(1, 1, 2, 2, 3);
        System.out.println(new FindCount().findOdd(values));
    }
}