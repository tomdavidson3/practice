package com.prinkipia.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class MinScalarProduct {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(in.nextLine());

        int testCount = 1;
        String[] testData = new String[2];
        for (int i = 0; i < numCases; i++) {
            in.nextLine();
            testData[0] = in.nextLine();
            testData[1] = in.nextLine();
            doMinScalar(testCount, testData);
            testCount++;
        }
    }

    private static void doMinScalar(int testNumber, final String[] testData) {
        long[] x = parseVector(testData[0]);
        long[] y = parseVector(testData[1]);
        System.out.printf("Case #%d: %d\n", testNumber, minScalarProduct(x, y));
    }

    private static long minScalarProduct(final long[] x, final long[] y) {
        long result = 0;
        Arrays.sort(x);
        Arrays.sort(y);
        for (int i = 0; i < x.length; i++) {
            result += x[i] * y[x.length - i - 1];
        }
        return result;
    }

    private static long[] parseVector(String line) {
        String[] parts = line.split(" ");
        long[] vector = new long[parts.length];
        int i = 0;
        for (String part : parts) {
            vector[i++] = Long.parseLong(part);
        }
        return vector;
    }
}
