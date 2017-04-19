package com.prinkipia.examples;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CourseraQuicksort {
    int numComparisons = 0;

    void sortLast(int[] a, int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            sortLast(a, p, q - 1);
            sortLast(a, q + 1, r);
        }
    }

    void sortFirst(int[] a, int p, int r) {
        if (p < r) {
            int q = partitionFirst(a, p, r);
            sortFirst(a, p, q - 1);
            sortFirst(a, q + 1, r);
        }
    }

    void sortMedianOf3(int[] a, int p, int r) {
        if (p < r) {
            int q = partitionMedianOf3(a, p, r);
            sortMedianOf3(a, p, q - 1);
            sortMedianOf3(a, q + 1, r);
        }
    }

    int partitionFirst(int[] a, int p, int r) {
        swap(a, p, r);
        return partition(a, p, r);
    }

    int partitionMedianOf3(int[] a, int p, int r) {
        int medianOf3 = medianOf3Pivot(a, p, r);
        swap(a, p, medianOf3);
        return partition(a, p, r);
    }

    int partition(int[] a, int l, int r) {
        //System.out.println(Arrays.toString(a));
        numComparisons += r - l;

        int p = a[l];
        //System.out.printf("pivot value is %d\n", p);
        int i = l + 1;
        for (int j = l + 1; j <= r; j++) {
            if (a[j] < p) {
                swap(a, j, i);
                i++;
            }
        }
        swap(a, l, i - 1);
        return i - 1;
    }

    private static int medianOf3Pivot(final int[] a, final int p, final int r) {

        int length = r - p + 1;
        if (length < 3) {
            return p;
        }

        int first = a[p];
        int last = a[r];

        int middleIndex;
        if (length % 2 == 0) {
            middleIndex = p + length / 2 - 1;
        }
        else {
            middleIndex = p + length / 2;
        }

        int middle = a[middleIndex];

        int[] set = new int[3];
        set[0] = first;
        set[1] = middle;
        set[2] = last;

        Arrays.sort(set);

        int medianValue = set[1];
        if (medianValue == a[p]) {
            return p;
        }
        if (medianValue == a[r]) {
            return r;
        }
        return middleIndex;
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

        int length = Integer.parseInt(args[1]);

        int[] first = Arrays.copyOf(b, length);
        int[] second = Arrays.copyOf(b, length);
        int[] third = Arrays.copyOf(b, length);

        CourseraQuicksort courseraQuicksort = new CourseraQuicksort();
        courseraQuicksort.sortFirst(first, 0, first.length - 1);
        System.out.println(courseraQuicksort.numComparisons);

        courseraQuicksort = new CourseraQuicksort();
        courseraQuicksort.sortLast(second, 0, second.length - 1);
        System.out.println(courseraQuicksort.numComparisons);

        courseraQuicksort = new CourseraQuicksort();
        courseraQuicksort.sortMedianOf3(third, 0, second.length - 1);
        System.out.println(courseraQuicksort.numComparisons);
    }
}
