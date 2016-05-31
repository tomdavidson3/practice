package com.prinkipia.examples;

import java.util.Arrays;

public class InsertionSort {
    public static void sort(int[] items) {
        for (int i = 0; i < items.length; i++) {
            for (int j = i + 1; j < items.length; j++) {
                if (items[j] < items[i]) {
                    int temp = items[i];
                    items[i] = items[j];
                    items[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] items = { 3, 1, 10, 6 };
        sort(items);
        System.out.println(Arrays.toString(items));
    }
}
