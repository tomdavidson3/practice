package com.prinkipia.examples;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountArrayInversionsBruteForce {
    public static void main(String[] args) throws IOException {
        List<Integer> a = new ArrayList<>();
        try (Reader reader = new FileReader(args[0])) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextInt()) {
                a.add(scanner.nextInt());
            }
        }
        System.out.println(countInversions(a));
    }

    static long countInversions(List<Integer> a) {
        long count = 0;

        for (int i = 0; i < a.size(); i++) {
            for (int j = i + 1; j < a.size(); j++) {
                if (a.get(j) < a.get(i)) {
                    count++;
                }
            }
        }

        return count;
    }
}
