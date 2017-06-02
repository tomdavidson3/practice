package com.prinkipia.examples.stanford;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(args[0]));

        Map<Long, Long> unique = new HashMap<>();

        while (scanner.hasNext()) {
            long value = scanner.nextLong();
            unique.put(value, value);
        }

        Map<Long, Long> found = new HashMap<>();

        int row = 1;
        for (long y : unique.values()) {
            System.out.println("row: " + row);
            for (long t = -10000; t < 10001; t++) {
                long x = t - y;
                if (unique.containsKey(x)) {
                    found.put(t, x);
                    System.out.printf("%d: found a pair (%d,%d), x + y = %d\n", found.size(), x, y, x + y);
                }
            }
            row++;
        }
        System.out.println(found.size());
    }
}
