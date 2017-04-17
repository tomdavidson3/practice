package com.prinkipia.examples;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CourseraQuicksort {
    static int numComparisons = 0;
    static int numComparisons2 = 0;

    static void sort(int[] a, int l, int r) {
        if (r <= l) {
            return;
        }
        int i = partition(a, l, r);
        sort(a, l, i - 1);
        sort(a, i + 1, r);
    }

    static int partition(int[] a, int lo, int hi) {
        numComparisons += (hi - lo);

        int pivot = a[lo];
        int left = lo - 1;
        int right = hi + 1;

        while (true) {
            while (a[++left] < pivot) {
                numComparisons2++;
            }

            while (a[--right] > pivot) {
                numComparisons2++;
            }

            if (left >= right) {
                return right;
            }
            swap(a, left, right);
        }
    }

    static void swap(final int[] a, final int i, final int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) throws IOException {
        List<Integer> a = new ArrayList<>();
        try (Reader reader = new FileReader(args[0])) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextInt()) {
                a.add(scanner.nextInt());
            }
        }
        int[] b = new int[a.size()];
        int j = 0;
        for (int item : a) {
            b[j++] = item;
        }
        sort(b, 0, b.length - 1);
        System.out.println(Arrays.toString(b));

    }
}
