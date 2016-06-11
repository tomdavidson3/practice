package com.prinkipia.examples;

import java.util.Random;

public class Quicksort {
    private int[] values;

    public Quicksort(final int[] values) {
        this.values = values;
    }

    private void sort(int lo, int hi) {
        if (lo < hi) {
            int p = partition(lo, hi);
            sort(lo, p);
            sort(p + 1, hi);
        }
    }

    private int partition(int lo, int hi) {
        int pivot = values[lo];
        int left = lo - 1;
        int right = hi + 1;

        while (true) {
            while (values[++left] < pivot) {
            }

            while (values[--right] > pivot) {
            }

            if (left >= right) {
                return right;
            }
            swap(left, right);
        }
    }

    private void swap(final int i, final int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    private void printValues() {
        boolean notFirst = false;
        for (int v : values) {
            if (notFirst) {
                System.out.print(" ");
            }
            System.out.print(v);
            notFirst = true;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int numElements = 10000000;

        int[] valuesToSort = new int[numElements];
        Random r = new Random(1967);

        for (int i = 0; i < numElements; i++) {
            valuesToSort[i] = r.nextInt(numElements);
        }

        Quicksort sorter = new Quicksort(valuesToSort);
        System.out.println("initial values");
        //sorter.printValues();
        System.out.println();

        sorter.sort(0, valuesToSort.length - 1);

        System.out.println("\nfinal values");
        //sorter.printValues();
    }
}
